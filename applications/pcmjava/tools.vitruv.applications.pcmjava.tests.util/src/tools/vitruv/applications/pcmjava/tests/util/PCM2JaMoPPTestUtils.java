package tools.vitruv.applications.pcmjava.tests.util;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.CompositeComponent;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryFactory;
import org.palladiosimulator.pcm.system.System;
import org.palladiosimulator.pcm.system.SystemFactory;

import tools.vitruv.domains.java.echange.feature.reference.JavaInsertEReference;
import tools.vitruv.domains.java.echange.feature.reference.ReferenceFactory;
import tools.vitruv.domains.pcm.PcmNamespace;
import tools.vitruv.framework.change.description.ConcreteChange;
import tools.vitruv.framework.change.description.VitruviusChangeFactory;
import tools.vitruv.framework.util.bridges.EMFBridge;
import tools.vitruv.framework.util.bridges.EcoreResourceBridge;
import tools.vitruv.framework.util.datatypes.ModelInstance;
import tools.vitruv.framework.util.datatypes.VURI;

public class PCM2JaMoPPTestUtils {

    public static final String REPOSITORY_NAME = "testRepository";
    public static final String BASIC_COMPONENT_NAME = "TestBasicComponent";
    public static final String IMPLEMENTING_CLASS_NAME = BASIC_COMPONENT_NAME + "Impl";
    public static final String INTERFACE_NAME = "TestInterface";
    public static final String RENAME = "Rename";
    public static final String OPERATION_SIGNATURE_1_NAME = "TestOperationSignature1";
    public static final String PARAMETER_NAME = "testParameterName";
    public static final String COMPOSITE_DATA_TYPE_NAME = "CompositeDataType";
    public static final String INNER_DEC_NAME = "testInnerDec";
    public static final String SYSTEM_NAME = "TestSystem";
    public static final String ASSEMBLY_CONTEXT_NAME = "assemblyContext";
    public static final String COMPOSITE_COMPONENT_NAME = "TestCompositeComponent";
    public static final String COLLECTION_DATA_TYPE_NAME = "TestCollectionDatatype";

    // private ctor for util class
    private PCM2JaMoPPTestUtils() {
    }

    public static Repository createRepository(final ResourceSet resourceSet, final String repositoryName,
            final String projectName) throws IOException {
        final VURI repoVURI = VURI.getInstance(
                projectName + "/model/" + repositoryName + "." + PcmNamespace.REPOSITORY_FILE_EXTENSION);
        final Resource resource = resourceSet.createResource(repoVURI.getEMFUri());
        final Repository repo = RepositoryFactory.eINSTANCE.createRepository();
        repo.setEntityName(repositoryName);
        resource.getContents().add(repo);
        EcoreResourceBridge.saveResource(resource);
        return repo;
    }

    public static BasicComponent createBasicComponent(final Repository repo) {
        return createBasicComponent(repo, BASIC_COMPONENT_NAME);
    }

    public static BasicComponent createBasicComponent(final Repository repo, final String name) {
        final BasicComponent basicComponent = RepositoryFactory.eINSTANCE.createBasicComponent();
        basicComponent.setRepository__RepositoryComponent(repo);
        basicComponent.setEntityName(name);
        return basicComponent;
    }

    public static CompositeComponent createCompositeComponent(final Repository repo, final String name) {
        final CompositeComponent compositeComponent = RepositoryFactory.eINSTANCE.createCompositeComponent();
        compositeComponent.setRepository__RepositoryComponent(repo);
        compositeComponent.setEntityName(name);
        return compositeComponent;
    }

    public static VURI createDummyVURI(final String name) {
        return VURI.getInstance(EMFBridge.createPlatformResourceURI("test/" + name));
    }

    public static Resource createResource(final String resourceName, final ResourceSet resourceSet) {
        final URI uri = EMFBridge.createPlatformResourceURI(resourceName);
        // final URI uri = URI.createPlatformResourceURI("test/" + resourceName, true);
        final Resource resource = resourceSet.createResource(uri);
        return resource;
    }

    public static ModelInstance createModelInstance(final String name, final ResourceSet resourceSet) {
        final Resource resource = createResource(name, resourceSet);
        final VURI vuri = VURI.getInstance(name);
        final ModelInstance modelInstance = new ModelInstance(vuri, resource);
        return modelInstance;
    }

    public static ConcreteChange createCreateChange(final EObject changedEObject, final EObject newAffectedEObject,
            final EObject oldAffectedEObject, final String featureName) {
        final JavaInsertEReference<EObject, EObject> createChange = ReferenceFactory.eINSTANCE
                .createJavaInsertEReference();
        createChange.setIsCreate(true);
        createChange.setNewValue(changedEObject);
        createChange.setAffectedEObject(newAffectedEObject);
        createChange.setOldAffectedEObject(oldAffectedEObject);
        createChange.setAffectedFeature(getEReferenceByName(newAffectedEObject, featureName));
        createChange.setNewValue(changedEObject);
        final ConcreteChange emfModelChange = VitruviusChangeFactory.getInstance().createConcreteChange(createChange,
                VURI.getInstance(oldAffectedEObject.eResource()));
        return emfModelChange;
    }

    public static EReference getEReferenceByName(final EObject eObject, final String featureName) {
        return (EReference) eObject.eClass().getEStructuralFeature(featureName);
    }

    public static Resource saveVURI(final VURI vuri, final ResourceSet resourceSet) throws IOException {
        final Resource resource = resourceSet.createResource(vuri.getEMFUri());
        EcoreResourceBridge.saveResource(resource);
        return resource;
    }

    public static System createSystem(final ResourceSet resourceSet, final String systemName, final String projectName)
            throws Throwable {
        final VURI repoVURI = VURI
                .getInstance(projectName + "/model/" + systemName + "." + PcmNamespace.SYSTEM_FILE_EXTENSION);
        final Resource resource = resourceSet.createResource(repoVURI.getEMFUri());
        final System system = SystemFactory.eINSTANCE.createSystem();
        system.setEntityName(systemName);
        resource.getContents().add(system);
        EcoreResourceBridge.saveResource(resource);
        return system;
    }
}
