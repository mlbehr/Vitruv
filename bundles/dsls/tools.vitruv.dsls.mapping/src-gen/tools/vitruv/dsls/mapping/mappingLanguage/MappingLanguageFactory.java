/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.mapping.mappingLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tools.vitruv.dsls.mapping.mappingLanguage.MappingLanguagePackage
 * @generated
 */
public interface MappingLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MappingLanguageFactory eINSTANCE = tools.vitruv.dsls.mapping.mappingLanguage.impl.MappingLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Mapping File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping File</em>'.
   * @generated
   */
  MappingFile createMappingFile();

  /**
   * Returns a new object of class '<em>Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping</em>'.
   * @generated
   */
  Mapping createMapping();

  /**
   * Returns a new object of class '<em>Signature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signature</em>'.
   * @generated
   */
  Signature createSignature();

  /**
   * Returns a new object of class '<em>Required Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Required Mapping</em>'.
   * @generated
   */
  RequiredMapping createRequiredMapping();

  /**
   * Returns a new object of class '<em>Constraint Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Block</em>'.
   * @generated
   */
  ConstraintBlock createConstraintBlock();

  /**
   * Returns a new object of class '<em>Constraint Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Expression</em>'.
   * @generated
   */
  ConstraintExpression createConstraintExpression();

  /**
   * Returns a new object of class '<em>Signature Constraint Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signature Constraint Block</em>'.
   * @generated
   */
  SignatureConstraintBlock createSignatureConstraintBlock();

  /**
   * Returns a new object of class '<em>Body Constraint Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Body Constraint Block</em>'.
   * @generated
   */
  BodyConstraintBlock createBodyConstraintBlock();

  /**
   * Returns a new object of class '<em>Feature Of Context Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Of Context Variable</em>'.
   * @generated
   */
  FeatureOfContextVariable createFeatureOfContextVariable();

  /**
   * Returns a new object of class '<em>Context Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Context Variable</em>'.
   * @generated
   */
  ContextVariable createContextVariable();

  /**
   * Returns a new object of class '<em>Required Mapping Path Base</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Required Mapping Path Base</em>'.
   * @generated
   */
  RequiredMappingPathBase createRequiredMappingPathBase();

  /**
   * Returns a new object of class '<em>Required Mapping Path Tail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Required Mapping Path Tail</em>'.
   * @generated
   */
  RequiredMappingPathTail createRequiredMappingPathTail();

  /**
   * Returns a new object of class '<em>Constraint Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Literal</em>'.
   * @generated
   */
  ConstraintLiteral createConstraintLiteral();

  /**
   * Returns a new object of class '<em>Xbase Signature Constraint Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xbase Signature Constraint Expression</em>'.
   * @generated
   */
  XbaseSignatureConstraintExpression createXbaseSignatureConstraintExpression();

  /**
   * Returns a new object of class '<em>Xbase Body Constraint Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xbase Body Constraint Expression</em>'.
   * @generated
   */
  XbaseBodyConstraintExpression createXbaseBodyConstraintExpression();

  /**
   * Returns a new object of class '<em>Variable Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Ref</em>'.
   * @generated
   */
  VariableRef createVariableRef();

  /**
   * Returns a new object of class '<em>In Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>In Expression</em>'.
   * @generated
   */
  InExpression createInExpression();

  /**
   * Returns a new object of class '<em>Not Null Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not Null Expression</em>'.
   * @generated
   */
  NotNullExpression createNotNullExpression();

  /**
   * Returns a new object of class '<em>Default Contain Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Default Contain Expression</em>'.
   * @generated
   */
  DefaultContainExpression createDefaultContainExpression();

  /**
   * Returns a new object of class '<em>Equals Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equals Literal Expression</em>'.
   * @generated
   */
  EqualsLiteralExpression createEqualsLiteralExpression();

  /**
   * Returns a new object of class '<em>Attribute Equivalence Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Equivalence Expression</em>'.
   * @generated
   */
  AttributeEquivalenceExpression createAttributeEquivalenceExpression();

  /**
   * Returns a new object of class '<em>Constraint Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Boolean Literal</em>'.
   * @generated
   */
  ConstraintBooleanLiteral createConstraintBooleanLiteral();

  /**
   * Returns a new object of class '<em>Constraint Null Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Null Literal</em>'.
   * @generated
   */
  ConstraintNullLiteral createConstraintNullLiteral();

  /**
   * Returns a new object of class '<em>Constraint Number Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Number Literal</em>'.
   * @generated
   */
  ConstraintNumberLiteral createConstraintNumberLiteral();

  /**
   * Returns a new object of class '<em>Constraint String Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint String Literal</em>'.
   * @generated
   */
  ConstraintStringLiteral createConstraintStringLiteral();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MappingLanguagePackage getMappingLanguagePackage();

} //MappingLanguageFactory
