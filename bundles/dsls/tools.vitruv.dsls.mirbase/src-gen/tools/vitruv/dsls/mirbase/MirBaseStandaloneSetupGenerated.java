/*
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.mirbase;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import tools.vitruv.dsls.mirbase.mirBase.MirBasePackage;

@SuppressWarnings("all")
public class MirBaseStandaloneSetupGenerated implements ISetup {

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		XbaseStandaloneSetup.doSetup();

		Injector injector = createInjector();
		register(injector);
		return injector;
	}
	
	public Injector createInjector() {
		return Guice.createInjector(new MirBaseRuntimeModule());
	}
	
	public void register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.kit.edu/ipd/sdq/vitruvius/dsls/mirbase/MirBase")) {
			EPackage.Registry.INSTANCE.put("http://www.kit.edu/ipd/sdq/vitruvius/dsls/mirbase/MirBase", MirBasePackage.eINSTANCE);
		}
		IResourceFactory resourceFactory = injector.getInstance(IResourceFactory.class);
		IResourceServiceProvider serviceProvider = injector.getInstance(IResourceServiceProvider.class);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("mirbase", resourceFactory);
		IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("mirbase", serviceProvider);
	}
}
