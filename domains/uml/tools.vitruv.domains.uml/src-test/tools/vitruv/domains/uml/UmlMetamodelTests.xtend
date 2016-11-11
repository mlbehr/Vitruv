package tools.vitruv.domains.uml

import org.junit.Test
import org.eclipse.uml2.uml.UMLFactory
import org.junit.Assert
import org.eclipse.uml2.uml.UMLPackage

class UmlMetamodelTests {
	@Test
	public def void testTuidCalculator() {
		val clazz = UMLFactory.eINSTANCE.createClass();
		clazz.name = "Test";
		val tuidFragments = UmlMetamodel.getInstance().calculateTuid(clazz).toString.split("#");
		Assert.assertEquals(3, tuidFragments.length);
		Assert.assertEquals(UMLPackage.eNS_URI, tuidFragments.get(0));
		Assert.assertEquals(UMLPackage.Literals.NAMED_ELEMENT__NAME.name + "=" + clazz.name, tuidFragments.get(2));
		Assert.assertNotNull(tuidFragments.get(1));
	}
	
	@Test
	public def void testSingletonRealization() {
		val instance1 = UmlMetamodel.instance;
		val instance2 = UmlMetamodel.instance;
		Assert.assertEquals(instance1, instance2);
	}
}