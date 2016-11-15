package tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.java2pcm.transformations

import tools.vitruv.framework.userinteraction.UserInteractionType
import tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.util.transformationexecutor.EmptyEObjectMappingTransformation
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.emftext.language.java.members.Method
import org.emftext.language.java.types.TypeReference
import org.emftext.language.java.types.TypedElement
import org.palladiosimulator.pcm.repository.DataType
import org.palladiosimulator.pcm.repository.OperationInterface
import org.palladiosimulator.pcm.repository.OperationSignature
import org.palladiosimulator.pcm.repository.Parameter
import org.palladiosimulator.pcm.repository.Repository
import org.palladiosimulator.pcm.repository.RepositoryFactory

import static extension tools.vitruv.framework.correspondence.CorrespondenceModelUtil.*
import static extension tools.vitruv.framework.util.bridges.CollectionBridge.*
import tools.vitruv.applications.pcmjava.util.java2pcm.JaMoPP2PCMUtils
import tools.vitruv.applications.pcmjava.util.java2pcm.TypeReferenceCorrespondenceHelper
import tools.vitruv.applications.pcmjava.util.PCMJaMoPPUtils
import tools.vitruv.domains.java.JavaNamespace
import tools.vitruv.framework.util.command.ChangePropagationResult

class MethodMappingTransformation extends EmptyEObjectMappingTransformation {

	override getClassOfMappedEObject() {
		return Method
	}

	override setCorrespondenceForFeatures() {
		JaMoPP2PCMUtils.addName2EntityNameCorrespondence(featureCorrespondenceMap)
	}

	/**
	 * called when a Method has been added:
	 * creates a corresponding OperationInterface if the method is in an interface and 
	 * the interface has corresponding OperationInterface(s)
	 */
	override createEObject(EObject eObject) {
		val interfaceMethod = eObject as Method
		val interfaceClassifier = interfaceMethod.containingConcreteClassifier
		val operationInterfaces = correspondenceModel.getCorrespondingEObjectsByType(interfaceClassifier,
			OperationInterface)
		if (!operationInterfaces.nullOrEmpty) {
			for (opInterface : operationInterfaces) {
				userInteracting.showMessage(UserInteractionType.MODELESS,
					"Creating an OperationSignature in OperationInterface  " + opInterface.entityName +
						System.getProperty("line.separator") + " for method " + interfaceMethod.name)
				var OperationSignature opSig = RepositoryFactory.eINSTANCE.createOperationSignature
				opSig.entityName = interfaceMethod.name
				opSig.interface__OperationSignature = opInterface
				return opSig.toList
			}
		}
		return null
	}

	override removeEObject(EObject eObject) {
		val correspondingObjects = correspondenceModel.getCorrespondingEObjects(eObject)
		return correspondingObjects
	}

	override updateSingleValuedEAttribute(EObject affectedEObject, EAttribute affectedAttribute, Object oldValue,
		Object newValue) {
		val transformationResult = new ChangePropagationResult
		JaMoPP2PCMUtils.updateNameAsSingleValuedEAttribute(affectedEObject, affectedAttribute, oldValue, newValue,
			featureCorrespondenceMap, correspondenceModel, transformationResult)
		return transformationResult
	}

	/**
	 * called when the return type has been changed
	 */
	override replaceNonRootEObjectSingle(EObject newAffectedEObject, EObject oldAffectedEObject,
		EReference affectedReference, EObject oldValue, EObject newValue) {
		val transformationResult = new ChangePropagationResult
		if (oldAffectedEObject instanceof Method &&
			affectedReference.name.equals(JavaNamespace.JAMOPP_REFERENCE_TYPE_REFERENCE) &&
			newValue instanceof TypeReference) {
			val correspondingPCMSignatures = correspondenceModel.
				getCorrespondingEObjectsByType(oldAffectedEObject, OperationSignature)
			if (correspondingPCMSignatures.nullOrEmpty) {
				return transformationResult
			}
			for (correspondingSignature : correspondingPCMSignatures) {
				val Repository repo = correspondingSignature.interface__OperationSignature.repository__Interface
				val oldTUID = correspondenceModel.calculateTUIDFromEObject(correspondingSignature)
				val DataType newReturnValue = TypeReferenceCorrespondenceHelper.
					getCorrespondingPCMDataTypeForTypeReference(newValue as TypeReference,
						correspondenceModel, userInteracting, repo, (newAffectedEObject as Method).arrayDimension)
				correspondingSignature.returnType__OperationSignature = newReturnValue

				// guess this is not necessary since the id stay the same
				oldTUID.updateTuid(correspondingSignature)
			}
		}
		transformationResult
	}

	/**
	 *  called when a parameter has been added
	 *  If the type of the parameter is a component interface or another 
	 *  component an OperationRrovidedRole is added 
	 */
	override createNonRootEObjectInList(EObject newAffectedEObject, EObject oldAffectedEObject,
		EReference affectedReference, EObject newValue, int index, EObject[] newCorrespondingEObjects) {
		val transformationResult = new ChangePropagationResult
		if (!newCorrespondingEObjects.nullOrEmpty) {
			var operationSignatues = correspondenceModel.getCorrespondingEObjectsByType(oldAffectedEObject, OperationSignature)
			if(operationSignatues.nullOrEmpty){
				operationSignatues = correspondenceModel.getCorrespondingEObjectsByType(newAffectedEObject, OperationSignature)
			}
			val pcmParameters = newCorrespondingEObjects.filter(typeof(Parameter))
			if (!operationSignatues.nullOrEmpty) {
				for (opSig : operationSignatues) {
					for (pcmParameter : pcmParameters) {
						if (null == pcmParameter.dataType__Parameter.repository__DataType) {
							pcmParameter.dataType__Parameter.repository__DataType = opSig.interface__OperationSignature.
								repository__Interface
						}
						pcmParameter.operationSignature__Parameter = opSig
					}
				}
			}
		}

		JaMoPP2PCMUtils.createNewCorrespondingEObjects(newValue, newCorrespondingEObjects, correspondenceModel, transformationResult)
		if (newValue instanceof TypedElement) {
			val newCorrespondingOperationProvidedRoles = JaMoPP2PCMUtils.
				checkAndAddOperationRequiredRole(newValue as TypedElement, correspondenceModel,
					userInteracting)
			JaMoPP2PCMUtils.createNewCorrespondingEObjects(newValue, newCorrespondingOperationProvidedRoles, correspondenceModel, transformationResult)
		}
		return transformationResult
	}

	/**
	 * called when a parameter has been deleted/changed
	 * If the parameter had a correspondence to an OperationRequiredRole delete it as well
	 */
	override deleteNonRootEObjectInList(EObject newAffectedEObject, EObject oldAffectedEObject,
		EReference affectedReference, EObject oldValue, int index, EObject[] oldCorrespondingEObjectsToDelete) {
		if(affectedReference.name != JavaNamespace.JAMOPP_STATEMENTS_REFERENCE){
			val oldTUID = correspondenceModel.calculateTUIDFromEObject(oldAffectedEObject)
			PCMJaMoPPUtils.deleteNonRootEObjectInList(oldAffectedEObject, oldValue, correspondenceModel)
			oldTUID.updateTuid(oldAffectedEObject)
		}
		return new ChangePropagationResult
	}

}
