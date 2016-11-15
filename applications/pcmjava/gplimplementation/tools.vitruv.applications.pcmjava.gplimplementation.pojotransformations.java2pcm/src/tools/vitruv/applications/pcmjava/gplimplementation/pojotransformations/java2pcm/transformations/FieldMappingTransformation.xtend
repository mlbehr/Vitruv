package tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.java2pcm.transformations

import tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.util.transformationexecutor.EmptyEObjectMappingTransformation
import java.util.HashSet
import java.util.Set
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.emftext.language.java.members.Field
import org.emftext.language.java.types.TypeReference
import org.palladiosimulator.pcm.core.composition.AssemblyContext
import org.palladiosimulator.pcm.core.composition.CompositionFactory
import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity
import org.palladiosimulator.pcm.repository.CompositeDataType
import org.palladiosimulator.pcm.repository.InnerDeclaration
import org.palladiosimulator.pcm.repository.OperationRequiredRole
import org.palladiosimulator.pcm.repository.RepositoryComponent
import org.palladiosimulator.pcm.repository.RepositoryFactory

import static extension tools.vitruv.framework.correspondence.CorrespondenceModelUtil.*
import tools.vitruv.applications.pcmjava.util.java2pcm.JaMoPP2PCMUtils
import tools.vitruv.applications.pcmjava.util.java2pcm.TypeReferenceCorrespondenceHelper
import tools.vitruv.applications.pcmjava.util.PCMJaMoPPUtils
import tools.vitruv.domains.java.JavaNamespace
import tools.vitruv.framework.util.command.ChangePropagationResult

class FieldMappingTransformation extends EmptyEObjectMappingTransformation {

	override getClassOfMappedEObject() {
		return Field
	}

	override setCorrespondenceForFeatures() {
		JaMoPP2PCMUtils.addName2EntityNameCorrespondence(featureCorrespondenceMap)
	}

	/**
	 * Called when a field has been created. The following correspondences for a field are possible:
	 * i) InnerDeclaration, if the field has been created in a class that corresponds to a 
	 *    composite datatype. If the type of the field corresponds to a Component or interface 
	 *    type we display a warning  
	 * ii) OperationRequiredRole, 
	 * 	   a) the type of the field corresponds to a an OperationInterface
	 *     b) if the type of the field is from class that corresponds to 
	 * 	      a repository component require all interfaces the repository component provides
	 * iii) InnerDeclaration, OperationRequiredRole: If i) and ii) are true
	 * iv) AssemblyContext: If the field is in a class that represents a ComposedProvidingRequiringEntity
	 * 	   (a CompositeComponent or a System) it can either correspond to an assemblyContext or an OperationRequiredRole
	 */
	@Override
	override createEObject(EObject eObject) {
		val field = eObject as Field

		val fieldContainingClassifierCorrespondences = correspondenceModel.getCorrespondingEObjects(
			field.containingConcreteClassifier)
		val Set<EObject> newCorrespondingEObjects = new HashSet
		val compositeDataTypes = fieldContainingClassifierCorrespondences.filter(typeof(CompositeDataType))
		if (!compositeDataTypes.nullOrEmpty) {

			// i)
			for (cdt : compositeDataTypes) {
				val InnerDeclaration innerDeclaration = RepositoryFactory.eINSTANCE.createInnerDeclaration
				innerDeclaration.entityName = field.name
				innerDeclaration.datatype_InnerDeclaration = TypeReferenceCorrespondenceHelper.
					getCorrespondingPCMDataTypeForTypeReference(field.typeReference, correspondenceModel,
						userInteracting, null, field.arrayDimension)
				innerDeclaration.compositeDataType_InnerDeclaration = cdt
				newCorrespondingEObjects.add(innerDeclaration)
			}
		}

		val correspondingOperationRequiredRoles = field.checkAndAddOperationRequiredRolesCorrepondencesToField()
		if (null != correspondingOperationRequiredRoles) {
			newCorrespondingEObjects.addAll(correspondingOperationRequiredRoles)
		}
		val correspondingComposedProvidingRequiringEntitys = fieldContainingClassifierCorrespondences.filter(
			typeof(ComposedProvidingRequiringEntity))
		if (!correspondingComposedProvidingRequiringEntitys.nullOrEmpty &&
			null != JaMoPP2PCMUtils.getTargetClassifierFromTypeReference(field.typeReference)) {
			// new field is in a ComposedProvidingRequiringEntity
			val classifierOfField = JaMoPP2PCMUtils.getTargetClassifierFromTypeReference(field.typeReference)
			val correspondingComponents = correspondenceModel.getCorrespondingEObjectsByType(classifierOfField,
				RepositoryComponent)
			if (!correspondingComponents.nullOrEmpty) {

				val AssemblyContext assemblyContext = CompositionFactory.eINSTANCE.createAssemblyContext
				assemblyContext.entityName = field.name
				assemblyContext.encapsulatedComponent__AssemblyContext = correspondingComponents.get(0)
				assemblyContext.parentStructure__AssemblyContext = correspondingComposedProvidingRequiringEntitys.get(0)
				newCorrespondingEObjects.addAll(assemblyContext)
			}
		}
		return newCorrespondingEObjects
	}

	override removeEObject(EObject eObject) {
		return null
	}

	/**
	 * if the field is renamed rename the corresponding objects on PCM side 
	 */
	override updateSingleValuedEAttribute(EObject affectedEObject, EAttribute affectedAttribute, Object oldValue,
		Object newValue) {
		val transformationResult = new ChangePropagationResult
		JaMoPP2PCMUtils.updateNameAsSingleValuedEAttribute(affectedEObject, affectedAttribute, oldValue, newValue,
			featureCorrespondenceMap, correspondenceModel, transformationResult)
		return transformationResult
	}

	/**
	 * called when the type has been changed
	 * If the field corresponds to a InnerDeclaration: change type of InnerDeclaration
	 * If the field corresponds to a OperationRequiredRole: check whether the new type also corresponds 
	 * to a OperationRequiredRole and change it accordingly
	 * TODO:If the field corresponds to an AssemblyContext: also update the TypeReference or 
	 * even remove the AssemblyContext if the new TypeReference does not correspond to a component 
	 */
	override replaceNonRootEObjectSingle(EObject newAffectedEObject, EObject oldAffectedEObject,
		EReference affectedReference, EObject oldValue, EObject newValue) {
		val transformationResult = new ChangePropagationResult
		if (affectedReference.name.equals(JavaNamespace.JAMOPP_REFERENCE_TYPE_REFERENCE) &&
			newValue instanceof TypeReference) {
			val newTypeReference = newValue as TypeReference

			// udpate InnerDeclaration
			val innerDecs = correspondenceModel.getCorrespondingEObjectsByType(oldAffectedEObject, InnerDeclaration)
			if (!innerDecs.nullOrEmpty) {
				for (innerDec : innerDecs) {
					val oldTUID = correspondenceModel.calculateTUIDFromEObject(innerDec)
					innerDec.datatype_InnerDeclaration = TypeReferenceCorrespondenceHelper.
						getCorrespondingPCMDataTypeForTypeReference(newTypeReference, correspondenceModel,
							userInteracting, null, (newAffectedEObject as Field).arrayDimension )
					oldTUID.updateTuid(innerDec)
				}
			}

			// Remove all OperationRequiredRole for the field
			val operationRequiredRoles = correspondenceModel.getCorrespondingEObjectsByType(oldAffectedEObject,
				OperationRequiredRole)
			for (operationRequiredRole : operationRequiredRoles) {
				PCMJaMoPPUtils.removeCorrespondenceAndAllObjects(operationRequiredRole, null, correspondenceModel)
			}

			// add new OperationRequiredRoles that correspond to the field now
			if (newValue instanceof TypeReference) {
				val classifier = JaMoPP2PCMUtils.getTargetClassifierFromTypeReference(newValue as TypeReference)
				if (null != classifier) {
					val newField = newAffectedEObject as Field
					val newCorrespondingEObjects = newField.checkAndAddOperationRequiredRolesCorrepondencesToField()
					if (!newCorrespondingEObjects.nullOrEmpty) {
						for (newCorrspondingEObject : newCorrespondingEObjects) {
							correspondenceModel.createAndAddCorrespondence(newCorrspondingEObject, newAffectedEObject)
						}
					}
				}
			}
		}
		return transformationResult
	}

	def private EObject[] checkAndAddOperationRequiredRolesCorrepondencesToField(Field field) {
		return JaMoPP2PCMUtils.checkAndAddOperationRequiredRole(field, correspondenceModel, userInteracting)
	}

}
