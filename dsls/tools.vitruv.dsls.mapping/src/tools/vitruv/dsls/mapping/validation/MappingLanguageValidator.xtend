/*
 * generated by Xtext
 */
package tools.vitruv.dsls.mapping.validation

import org.eclipse.xtext.validation.Check
import tools.vitruv.dsls.mapping.mappingLanguage.MappingFile
import tools.vitruv.dsls.mapping.mappingLanguage.MappingLanguagePackage

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class MappingLanguageValidator extends AbstractMappingLanguageValidator {
	public static val NOT_EXACTLY_TWO_IMPORTS = 'notExactlyTwoImports'
	
	@Check
	def checkTwoImports(MappingFile mappingFile) {
		if (mappingFile.imports.size != 2) {
			error('Mapping must define exactly two imports.',
				MappingLanguagePackage.Literals.MAPPING_FILE__IMPORTS,
				NOT_EXACTLY_TWO_IMPORTS
			)
		} 
	}
}