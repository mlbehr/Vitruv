package edu.kit.ipd.sdq.vitruvius.tests.components;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import pcm_mockup.Pcm_mockupFactory;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.util.bridges.EcoreResourceBridge;
import edu.kit.ipd.sdq.vitruvius.tests.util.TestUtil;

public class PersistentTestUtil {
    private PersistentTestUtil() {

    }

    public static Set<VURI> createDummyVURIs(final int nrOfVURIs) {
        Set<VURI> vuris = new HashSet<VURI>();
        for (int i = 0; i < nrOfVURIs; ++i) {
            vuris.add(VURI.getInstance(TestUtil.PROJECT_URI + "/dummyInstances/testInstance_" + i + "."
                    + MetaRepositoryTest.PCM_FILE_EXT));
        }
        return vuris;
    }

    public static void createResources(final Set<VURI> vuris) throws IOException {
        ResourceSet resourceSet = new ResourceSetImpl();
        for (VURI vuri : vuris) {
            Resource resource = resourceSet.createResource(vuri.getEMFUri());
            resource.getContents().add(Pcm_mockupFactory.eINSTANCE.createRepository());
            EcoreResourceBridge.saveResource(resource);
        }
    }

    public static void assertEqualsSets(final Set<VURI> vuris, final Set<VURI> loadedVURIs) {
        assertEquals("Loaded VURIs must have the same size as saved VURIs", loadedVURIs.size(), vuris.size());
        Iterator<VURI> loadedVURIsIterator = loadedVURIs.iterator();
        while (loadedVURIsIterator.hasNext()) {
            URI loadedURI = loadedVURIsIterator.next().getEMFUri();
            Iterator<VURI> vuriIterator = vuris.iterator();
            boolean found = false;
            URI uri = null;
            while (vuriIterator.hasNext() && !found) {
                uri = vuriIterator.next().getEMFUri();
                if (loadedURI.equals(uri)) {
                    // uri found in loaded URI
                    found = true;
                }
            }
            if (!found) {
                throw new RuntimeException("URI (" + uri + ") not found in loaded URIs: " + loadedURI);
            }

        }
    }
}