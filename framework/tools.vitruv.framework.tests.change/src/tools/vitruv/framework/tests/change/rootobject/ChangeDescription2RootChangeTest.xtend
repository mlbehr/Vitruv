package tools.vitruv.framework.tests.change.rootobject

import tools.vitruv.framework.tests.change.ChangeDescription2ChangeTransformationTest
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Before

import static extension tools.vitruv.framework.tests.change.util.ChangeAssertHelper.*
import org.junit.After
import java.io.File
import allElementTypes.AllElementTypesFactory
import allElementTypes.Root

class ChangeDescription2RootChangeTest extends ChangeDescription2ChangeTransformationTest{
	var Root rootElement2;
	var rs = new ResourceSetImpl
	var protected Resource resource1
	var protected Resource resource2
	var protected String uri1 = System.getProperty("java.io.tmpdir").replace("\\", "/") + "dummyURI1.xmi"
	var protected String uri2 =  System.getProperty("java.io.tmpdir").replace("\\", "/") + "dummyURI2.xmi"
	
	@Before
	def override beforeTest(){
		super.beforeTest
		rootElement2 = AllElementTypesFactory.eINSTANCE.createRoot();
		resource1 = rs.createResource(URI.createFileURI(uri1))
		resource2 = rs.createResource(URI.createFileURI(uri2))
	}
	
	@After
	def override afterTest() {
		super.afterTest();
		new File(uri1).delete();
		new File(uri2).delete();
	}
	
	def protected startRecordingOnResourceSet() {
		startRecording(#[rs])
	}
	
		
	def protected void assertInsertRoot(int index, boolean isCreate, String uri) {
		claimChange(index).assertInsertRootEObject(this.rootElement, isCreate, uri)
	}
	
	def protected void assertInsertRoot2(int index, boolean isCreate, String uri) {
		claimChange(index).assertInsertRootEObject(this.rootElement2, isCreate, uri)
	}
	
	def protected void assertRemoveRoot(int index, boolean isDelete, String uri) {
		claimChange(index).assertRemoveRootEObject(this.rootElement, isDelete, uri)
	}
	
	def protected void assertRemoveRoot2(int index, boolean isDelete, String uri) {
		claimChange(index).assertRemoveRootEObject(this.rootElement2, isDelete, uri)
	}
	
	def protected void insertRootEObjectInResource(Resource resource){
		resource.contents.add(this.rootElement)
	}
	
	def protected void insertRootEObjectInResource2(Resource resource){
		resource.contents.add(this.rootElement2)
	}
}