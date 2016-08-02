package edu.kit.ipd.sdq.vitruvius.dsls.response.jvmmodel.classgenerators

import org.eclipse.xtext.common.types.JvmGenericType
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Response
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmOperation
import static edu.kit.ipd.sdq.vitruvius.dsls.response.api.generator.ResponseLanguageGeneratorConstants.*;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Blackboard
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ConcreteModelElementChange
import static extension edu.kit.ipd.sdq.vitruvius.dsls.response.helper.EChangeHelper.*;
import org.eclipse.xtend2.lib.StringConcatenationClient
import static extension edu.kit.ipd.sdq.vitruvius.dsls.response.helper.EChangeHelper.*;
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.AtomicFeatureChange
import static extension edu.kit.ipd.sdq.vitruvius.dsls.response.helper.ResponseLanguageHelper.*;
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.PreconditionCodeBlock
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Trigger
import edu.kit.ipd.sdq.vitruvius.dsls.response.helper.ResponseClassNamesGenerator.ClassNameGenerator
import static extension edu.kit.ipd.sdq.vitruvius.dsls.response.helper.ResponseClassNamesGenerator.*;
import edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.AbstractResponseRealization
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EChange
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.FeatureEChange
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.root.RootEChange

class ResponseClassGenerator extends ClassGenerator {
	protected final Response response;
	protected final Class<? extends EChange> change;
	protected final boolean hasPreconditionBlock;
	private final ClassNameGenerator responseClassNameGenerator;
	private final ClassNameGenerator routineClassNameGenerator;
	
	new(Response response, TypesBuilderExtensionProvider typesBuilderExtensionProvider) {
		super(typesBuilderExtensionProvider);
		if (response?.trigger == null || response?.routine == null) {
			throw new IllegalArgumentException();
		}
		this.response = response;
		this.hasPreconditionBlock = response.trigger.precondition != null;
		this.change = response.trigger.generateEChangeInstanceClass();
		this.responseClassNameGenerator = response.responseClassNameGenerator;
		this.routineClassNameGenerator = response.routine.routineClassNameGenerator;
	}
		
	public override JvmGenericType generateClass() {
		generateMethodGetExpectedChangeType();
		generateMethodCheckPrecondition();
		generateMethodExecuteResponse();

		response.toClass(responseClassNameGenerator.qualifiedName) [
			visibility = JvmVisibility.DEFAULT;
			superTypes += typeRef(AbstractResponseRealization);
			addConstructor(it);
			members += generatedMethods;
		];
	}
	
	protected def void addConstructor(JvmGenericType clazz) {
		clazz.members += clazz.toConstructor [
			visibility = JvmVisibility.PUBLIC;
			val userInteractingParameter = generateUserInteractingParameter();
			parameters += userInteractingParameter
			body = '''super(«userInteractingParameter.name»);'''
		]
	}
	
	protected def generateMethodGetExpectedChangeType() {
		val methodName = "getExpectedChangeType";
		return getOrGenerateMethod(methodName, typeRef(Class, wildcardExtends(typeRef(EChange)))) [
			static = true;
			body = '''return «change».class;'''
		];
	}
	
	/**
	 * Generates method: applyChange
	 * 
	 * <p>Applies the given change to the specified response. Executes the response if all preconditions are fulfilled.
	 * 
	 * <p>Method parameters are:
	 * <li>1. change: the change event ({@link EChange})
	 * <li>2. blackboard: the {@link Blackboard} containing the {@link CorrespondenceInstance} 
	 * 
	 */
	protected def generateMethodExecuteResponse() {
		val methodName = "executeResponse";
		
		return getOrGenerateMethod(methodName, typeRef(Void.TYPE)) [
			visibility = JvmVisibility.PUBLIC;
			val changeParameter = generateUntypedChangeParameter();
			parameters += changeParameter;
			val typedChangeName = "typedChange";
			val typedChangeString = typedChangeString;
			body = '''
				«typedChangeString» «typedChangeName» = («typedChangeString»)«changeParameter.name»;
				«getMockOldValueCodeIfNecessary(response.trigger, typedChangeName)»
				«routineClassNameGenerator.qualifiedName» effect = new «routineClassNameGenerator.qualifiedName»(this.executionState, this, «typedChangeName»);
				effect.applyRoutine();'''
		];
	}
	
	/* TODO HK (Change MM): Fix this after the new change MM is implemented:
		 * Delete objects (except root one) are removed from the model and now contained in the ChangeDescription,
		 * so correspondences cannot be resolved
		 */
	private def dispatch StringConcatenationClient getMockOldValueCodeIfNecessary(Trigger trigger, String typedChangeName) ''''''
	private def dispatch StringConcatenationClient getMockOldValueCodeIfNecessary(AtomicFeatureChange trigger, String typedChangeName) {
		val affectedElementClass = trigger.changedFeature.feature.EType
		if (change.methods.exists[it.name == "setOldValue"] && EObject.isAssignableFrom(affectedElementClass.instanceClass)) {
			'''
			final «affectedElementClass.instanceClass.name» oldValue = «typedChangeName».getOldValue();
			if (oldValue != null) {
				«typedChangeName».setOldValue(new «basicResponsesPackageQualifiedName + ".mocks." + affectedElementClass.instanceClass.name + "ContainerMock"»(oldValue, «typedChangeName».getAffectedEObject()));
			}'''
		}
	}
			
	private def StringConcatenationClient getTypedChangeString() '''
		«val trigger = response.trigger
		»«change»«IF trigger instanceof ConcreteModelElementChange»<«FOR typeParam : getGenericTypeParametersOfChange(trigger) SEPARATOR ', '»«typeParam»«ENDFOR»>«ENDIF»'''
		
		
	protected def generateMethodCheckPrecondition() {
		val methodName = PRECONDITION_METHOD_NAME;
		val preconditionMethods = getPreconditionMethods();
		// FIXME HK Use method in MM
		val changeType = if (FeatureEChange.isAssignableFrom(change)) {
				typeRef(change, wildcard, wildcard);
			} else if (RootEChange.isAssignableFrom(change)) {
				typeRef(change, wildcard);
			} else {
				typeRef(change);
			}
		return getOrGenerateMethod(methodName, typeRef(Boolean.TYPE)) [
			val changeParameter = generateUntypedChangeParameter(response);
			val typedChangeClass = change;
			visibility = JvmVisibility.PUBLIC;
			parameters += changeParameter
			body = '''
				if (!(«changeParameter.name» instanceof «changeType»)) {
					return false;
				}
				«typedChangeClass» typedChange = («typedChangeClass»)«changeParameter.name»;
				«FOR operation : preconditionMethods»
					if (!«operation.simpleName»(typedChange)) {
						return false;
					}
				«ENDFOR»
				getLogger().debug("Passed precondition check of response " + this.getClass().getName());
				return true;
				'''
		];
	}

	protected def JvmOperation generateMethodCheckUserDefinedPrecondition(PreconditionCodeBlock preconditionBlock) {
		val methodName = TRIGGER_PRECONDITION_METHOD_NAME;
		
		return preconditionBlock.getOrGenerateMethod(methodName, typeRef(Boolean.TYPE)) [
			visibility = JvmVisibility.PRIVATE;
			parameters += preconditionBlock.generateChangeParameter(response.trigger);
			body = preconditionBlock.code;
		];		
	}
	
	protected def Iterable<JvmOperation> getPreconditionMethods() {
		val methods = <JvmOperation>newArrayList();
		if (response.trigger instanceof ConcreteModelElementChange) {
			methods += generateMethodCheckChangedObject();
		}
		if (hasPreconditionBlock) {
			methods += generateMethodCheckUserDefinedPrecondition(response.trigger.precondition);	
		}
		return methods;
	}
	
	/**
	 * Generates method: checkChangedObject : boolean
	 * 
	 * <p>Checks if the currently changed object equals the one specified in the response.
	 * 
	 * <p>Methods parameters are:
	 * 	<li>1. change: the change event ({@link EChange})</li>
	 */
	protected def generateMethodCheckChangedObject() {
		val methodName = "checkChangeProperties";
		
		if (!(response.trigger instanceof ConcreteModelElementChange)) {
			throw new IllegalStateException();
		}
		
		val changeEvent = response.trigger;
		val changedElement = response.trigger.changedModelElementClass;
		return getOrGenerateMethod(methodName, typeRef(Boolean.TYPE)) [
			visibility = JvmVisibility.PRIVATE;
			val changeParameter = generateChangeParameter(response.trigger);
			parameters += changeParameter;
//			val typedChangeName = "typedChange";
//			val typedChangeClassGenericString = if (!change.equals(EChange)) "<?>" else ""
			body = '''
«««				«change»«typedChangeClassGenericString» «typedChangeName» = («change»«typedChangeClassGenericString»)«changeParameter.name»;
				«EObject» changedElement = «changeParameter.name».get«changeEvent.EChangeFeatureNameOfChangedObject.toFirstUpper»();
				// Check model element type
				if (!(changedElement instanceof «changedElement.instanceClass»)) {
					return false;
				}
				
				«IF changeEvent instanceof AtomicFeatureChange»
					// Check feature
					if (!«changeParameter.name».getAffectedFeature().getName().equals("«changeEvent.changedFeature.feature.name»")) {
						return false;
					}
				«ENDIF»
				return true;
			'''
		];
	}
}