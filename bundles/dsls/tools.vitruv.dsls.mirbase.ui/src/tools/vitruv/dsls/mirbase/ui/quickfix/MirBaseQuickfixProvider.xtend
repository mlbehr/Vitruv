/*
 * generated by Xtext 2.10.0-SNAPSHOT
 */
package tools.vitruv.dsls.mirbase.ui.quickfix

import tools.vitruv.dsls.mirbase.mirBase.MetamodelImport
import tools.vitruv.dsls.mirbase.validation.MirBaseValidator
import tools.vitruv.framework.util.bridges.EclipseBridge
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.ui.quickfix.XbaseQuickfixProvider

import static tools.vitruv.dsls.mirbase.validation.EclipsePluginHelper.*
import tools.vitruv.dsls.common.VitruviusDslsCommonConstants
import tools.vitruv.dsls.mirbase.mirBase.DomainReference
import tools.vitruv.framework.domains.VitruvDomainProvider

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#quick-fixes
 */
class MirBaseQuickfixProvider extends XbaseQuickfixProvider {
	@Fix(MirBaseValidator.METAMODEL_IMPORT_DEPENDENCY_MISSING)
	def addMetamodelDependencyToManifest(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add dependency.', 'Add the dependency.', null) [ element, context |
			val metamodelImport = element as MetamodelImport

			val contributorName = EclipseBridge.getNameOfContributorOfExtension(
				"org.eclipse.emf.ecore.generated_package", "uri", metamodelImport.package.nsURI)

			val project = getProject(metamodelImport.eResource)
			if (!hasDependency(project, contributorName)) {
				addDependency(project, contributorName)
			}
		]
	}
	
	@Fix(MirBaseValidator.DOMAIN_IMPORT_DEPENDENCY_MISSING)
	def addDomainDependencyToManifest(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add dependency.', 'Add the dependency.', null) [ element, context |
			val domainReference = element as DomainReference
			
			val domainProvider = VitruvDomainProvider.getDomainProviderFromExtensionPoint(domainReference.domain);
			val contributorName = EclipseBridge.getNameOfContributorOfExtension(
					VitruvDomainProvider.EXTENSION_POINT_ID,
					"class", domainProvider.class.name);
			val project = getProject(domainReference.eResource)
			if (!hasDependency(project, contributorName)) {
				addDependency(project, contributorName)
			}
		]
	}

	@Fix(MirBaseValidator.VITRUVIUS_DEPENDENCY_MISSING)
	def addVitruviusDependenciesToManifest(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add all Vitruvius depdendencies.', 'Add all Vitruvius depdendencies.', null) [ element, context |
			val project = getProject(element.eResource)
			for (String dependency : VitruviusDslsCommonConstants.VITRUVIUS_DEPENDENCIES) {
				println(dependency)
				if (!hasDependency(project, dependency)) {
					addDependency(project, dependency)
				}
			}
		]
	}
}
