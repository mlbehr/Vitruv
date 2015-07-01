package edu.kit.ipd.sdq.vitruvius.framework.mir.scoping

import com.google.common.base.Predicate
import com.google.inject.Inject
import edu.kit.ipd.sdq.vitruvius.framework.mir.mIR.MIRPackage
import java.util.Collections
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider
import org.eclipse.xtext.scoping.impl.SimpleScope

class MIRGlobalScopeProvider extends AbstractGlobalScopeProvider {
	@Inject
	IQualifiedNameConverter qualifiedNameConverter
	
	IScope packageScope = null;
	
	override getScope(Resource resource, EReference reference) {
		super.getScope(resource, reference)
	}
	
	private def getPackageScope() {
		if (packageScope == null)
			packageScope = new SimpleScope(IScope.NULLSCOPE,
				EPackage.Registry.INSTANCE.keySet.map [
					from |
					val InternalEObject proxyPackage = EcoreFactory.eINSTANCE.createEPackage as InternalEObject;
					proxyPackage.eSetProxyURI(URI.createURI(from));
					return EObjectDescription.create(
						qualifiedNameConverter.toQualifiedName(from),
						proxyPackage, Collections.singletonMap("nsURI", "true")
					);
				])
		
		return packageScope
	}
	
	override getScope(Resource resource, EReference ref, Predicate<IEObjectDescription> filter) {
		if (ref == MIRPackage.eINSTANCE.import_Package) {
			return getPackageScope
		}
			
		super.getScope(resource, ref, filter)
	}
	
}