package tools.vitruv.framework.tests.vsum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import pcm_mockup.Component;
import pcm_mockup.Repository;
import tools.vitruv.framework.tuid.AttributeTUIDCalculatorAndResolver;
import tools.vitruv.framework.tuid.TUID;
import tools.vitruv.framework.tuid.TUIDCalculatorAndResolver;
import tools.vitruv.framework.util.datatypes.ModelInstance;
import tools.vitruv.framework.util.datatypes.VURI;
import tools.vitruv.framework.vsum.InternalVirtualModel;

public class DefaultTUIDCalculatorTest extends VSUMTest {
    @Override
    @Test
    public void testAll() {
        InternalVirtualModel vsum = createMetaRepositoryVSUMAndModelInstances();
        VURI model1URI = VURI.getInstance(getDefaultPCMInstanceURI());
        ModelInstance model1 = vsum.getModelInstance(model1URI);
        Repository pcmRoot = (Repository) model1.getResource().getContents().get(0);
        String expectedTUID = pcmRoot.getId();
        EObject resolvedEObject = testTUIDCalculator(PCM_MM_URI, pcmRoot, pcmRoot, expectedTUID);
        assertEquals(resolvedEObject, pcmRoot);
        Component pcmComponent = (Component) pcmRoot.eContents().get(1);
        expectedTUID = pcmComponent.getId();
        resolvedEObject = testTUIDCalculator(PCM_MM_URI, pcmRoot, pcmComponent, expectedTUID);
        assertEquals(resolvedEObject, pcmComponent);
    }

    public EObject testTUIDCalculator(final String tuidPrefix, final EObject rootEObject, final EObject eObject,
            final String expectedTUID) {
        TUIDCalculatorAndResolver defaultTUIDCalculatorAndResolver = new AttributeTUIDCalculatorAndResolver(tuidPrefix,
                "id");
        String calculatedTuid = defaultTUIDCalculatorAndResolver.calculateTUIDFromEObject(eObject);
        // Calculated TUID contains more than just the UUID itself. It also contains the resource
        // and the class name that was used to create the TUID. Hence, we just compare with contains
        // instead of equals
        assertNotNull("Calculated TUID is null", calculatedTuid);
        assertTrue("Calculated TUID does not contain expected TUID", calculatedTuid.contains(expectedTUID));
        TUID tuid = TUID.getInstance(calculatedTuid);
        String tuidString = tuid.toString();
        assertNotNull("TUID string is null", tuidString);
        EObject resolvedEObject = defaultTUIDCalculatorAndResolver.resolveEObjectFromRootAndFullTUID(rootEObject,
                tuidString);
        assertNotNull(resolvedEObject);
        return resolvedEObject;
    }
}
