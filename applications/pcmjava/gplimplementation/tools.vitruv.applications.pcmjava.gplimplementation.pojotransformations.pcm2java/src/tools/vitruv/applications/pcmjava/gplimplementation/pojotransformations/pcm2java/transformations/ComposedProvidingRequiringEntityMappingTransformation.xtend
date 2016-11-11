package tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.pcm2java.transformations

import tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.util.transformationexecutor.EmptyEObjectMappingTransformation
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.emftext.language.java.containers.Package
import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity
import org.palladiosimulator.pcm.core.entity.NamedElement
import tools.vitruv.applications.pcmjava.util.pcm2java.PCM2JaMoPPUtils
import tools.vitruv.framework.util.command.ChangePropagationResult
import tools.vitruv.domains.pcm.PcmNamespace

/**
 * base class for RepositoryComponentMappingTransformation and SystemMappingTransformation
 */
abstract class ComposedProvidingRequiringEntityMappingTransformation extends EmptyEObjectMappingTransformation {

	override setCorrespondenceForFeatures() {
		PCM2JaMoPPUtils.addEntityName2NameCorrespondence(featureCorrespondenceMap)
	}

	def Package getParentPackage(EObject eObject)

	/**
	 * called when a ComposedProvidingRequiriungEntity has been created
	 * --> create a package, a compilation unit and a class for the entity
	 */
	override createEObject(EObject eObject) {
		val ComposedProvidingRequiringEntity composedEntity = eObject as ComposedProvidingRequiringEntity
		val Package parentPackage = getParentPackage(eObject)

		//create all elements
		val createdEObjects = PCM2JaMoPPUtils.createPackageCompilationUnitAndJaMoPPClass(composedEntity, parentPackage)

		return createdEObjects
	}

	override removeEObject(EObject eObject) {
		return null
	}

	override updateSingleValuedEAttribute(EObject eObject, EAttribute affectedAttribute, Object oldValue,
		Object newValue) {
		PCM2JaMoPPUtils.updateNameAsSingleValuedEAttribute(eObject, affectedAttribute, oldValue, newValue,
			featureCorrespondenceMap, correspondenceModel)
	}

	/**
	 * called when a AssemblyContext has been added
	 */
	override createNonRootEObjectInList(EObject newAffectedEObject, EObject oldAffectedEObject,
		EReference affectedReference, EObject newValue, int index, EObject[] newCorrespondingEObjects) {
		if ((affectedReference.name.equals(PcmNamespace.SYSTEM_ASSEMBLY_CONTEXTS__COMPOSED_STRUCTURE) ||
			affectedReference.name.equals(PcmNamespace.COMPONENT_PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY) ||
			affectedReference.name.equals(PcmNamespace.COMPONENT_REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY)) &&
			newValue instanceof NamedElement) {
			PCM2JaMoPPUtils.
				handleAssemblyContextAddedAsNonRootEObjectInList(newAffectedEObject as ComposedProvidingRequiringEntity,
					newValue as NamedElement, newCorrespondingEObjects, correspondenceModel)
		} 
		return new ChangePropagationResult
	}
	
	/**
	 * TODO: copied from BasicComponent: refactor 
	 * called when OperationProvidedRole has been removed from the current ComposedProvidingRequiringEntity
	 */
	override removeNonContainmentEReference(EObject affectedEObject, EReference affectedReference, EObject oldValue,
		int index) {

		//provided role removed - deletion of eobject should already be done in OperationProvidedRoleMappingTransformation - mark bc to save
		if (affectedReference.name.equals(PcmNamespace.COMPONENT_PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY) ||
			affectedReference.name.equals(PcmNamespace.COMPONENT_REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY)) {
		}
		return new ChangePropagationResult
	}

	/**
	 * TODO: copied from BasicComponent: refactor
	 * called when an OperationProvidedRole was has been inserted in the current ComposedProvidingRequiringEntity
	 */
	override insertNonRootEObjectInContainmentList(EObject oldAffectedEObject, EObject newAffectedEObject,
		EReference affectedReference, EObject newValue) {
		if (affectedReference.name.equals(PcmNamespace.COMPONENT_PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY) ||
			affectedReference.name.equals(PcmNamespace.COMPONENT_REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY)) {
			
		}
		return new ChangePropagationResult
	}

}
