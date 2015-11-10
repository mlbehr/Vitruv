/**
 */
package edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.util;

import edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.vitruvius.dsls.mapping.mappingLanguage.MappingLanguagePackage
 * @generated
 */
public class MappingLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MappingLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MappingLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case MappingLanguagePackage.MAPPING_FILE:
      {
        MappingFile mappingFile = (MappingFile)theEObject;
        T result = caseMappingFile(mappingFile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.MAPPING:
      {
        Mapping mapping = (Mapping)theEObject;
        T result = caseMapping(mapping);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.SIGNATURE:
      {
        Signature signature = (Signature)theEObject;
        T result = caseSignature(signature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.NAMED_ECLASS:
      {
        NamedEClass namedEClass = (NamedEClass)theEObject;
        T result = caseNamedEClass(namedEClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_BLOCK:
      {
        ConstraintBlock constraintBlock = (ConstraintBlock)theEObject;
        T result = caseConstraintBlock(constraintBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_EXPRESSION:
      {
        ConstraintExpression constraintExpression = (ConstraintExpression)theEObject;
        T result = caseConstraintExpression(constraintExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.SIGNATURE_CONSTRAINT_BLOCK:
      {
        SignatureConstraintBlock signatureConstraintBlock = (SignatureConstraintBlock)theEObject;
        T result = caseSignatureConstraintBlock(signatureConstraintBlock);
        if (result == null) result = caseConstraintBlock(signatureConstraintBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.BODY_CONSTRAINT_BLOCK:
      {
        BodyConstraintBlock bodyConstraintBlock = (BodyConstraintBlock)theEObject;
        T result = caseBodyConstraintBlock(bodyConstraintBlock);
        if (result == null) result = caseConstraintBlock(bodyConstraintBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.FEATURE_OF_CONTEXT_VARIABLE:
      {
        FeatureOfContextVariable featureOfContextVariable = (FeatureOfContextVariable)theEObject;
        T result = caseFeatureOfContextVariable(featureOfContextVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONTEXT_VARIABLE:
      {
        ContextVariable contextVariable = (ContextVariable)theEObject;
        T result = caseContextVariable(contextVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_LITERAL:
      {
        ConstraintLiteral constraintLiteral = (ConstraintLiteral)theEObject;
        T result = caseConstraintLiteral(constraintLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.VARIABLE_REF:
      {
        VariableRef variableRef = (VariableRef)theEObject;
        T result = caseVariableRef(variableRef);
        if (result == null) result = caseConstraintExpression(variableRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.IN_EXPRESSION:
      {
        InExpression inExpression = (InExpression)theEObject;
        T result = caseInExpression(inExpression);
        if (result == null) result = caseConstraintExpression(inExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.EQUALS_LITERAL_EXPRESSION:
      {
        EqualsLiteralExpression equalsLiteralExpression = (EqualsLiteralExpression)theEObject;
        T result = caseEqualsLiteralExpression(equalsLiteralExpression);
        if (result == null) result = caseConstraintExpression(equalsLiteralExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.ATTRIBUTE_EQUIVALENCE_EXPRESSION:
      {
        AttributeEquivalenceExpression attributeEquivalenceExpression = (AttributeEquivalenceExpression)theEObject;
        T result = caseAttributeEquivalenceExpression(attributeEquivalenceExpression);
        if (result == null) result = caseConstraintExpression(attributeEquivalenceExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_BOOLEAN_LITERAL:
      {
        ConstraintBooleanLiteral constraintBooleanLiteral = (ConstraintBooleanLiteral)theEObject;
        T result = caseConstraintBooleanLiteral(constraintBooleanLiteral);
        if (result == null) result = caseConstraintLiteral(constraintBooleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_NULL_LITERAL:
      {
        ConstraintNullLiteral constraintNullLiteral = (ConstraintNullLiteral)theEObject;
        T result = caseConstraintNullLiteral(constraintNullLiteral);
        if (result == null) result = caseConstraintLiteral(constraintNullLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_NUMBER_LITERAL:
      {
        ConstraintNumberLiteral constraintNumberLiteral = (ConstraintNumberLiteral)theEObject;
        T result = caseConstraintNumberLiteral(constraintNumberLiteral);
        if (result == null) result = caseConstraintLiteral(constraintNumberLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_STRING_LITERAL:
      {
        ConstraintStringLiteral constraintStringLiteral = (ConstraintStringLiteral)theEObject;
        T result = caseConstraintStringLiteral(constraintStringLiteral);
        if (result == null) result = caseConstraintLiteral(constraintStringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingFile(MappingFile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMapping(Mapping object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignature(Signature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named EClass</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named EClass</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedEClass(NamedEClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintBlock(ConstraintBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintExpression(ConstraintExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signature Constraint Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signature Constraint Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignatureConstraintBlock(SignatureConstraintBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Body Constraint Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Body Constraint Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBodyConstraintBlock(BodyConstraintBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Of Context Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Of Context Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureOfContextVariable(FeatureOfContextVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextVariable(ContextVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintLiteral(ConstraintLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableRef(VariableRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>In Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>In Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInExpression(InExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equals Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equals Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualsLiteralExpression(EqualsLiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Equivalence Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Equivalence Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeEquivalenceExpression(AttributeEquivalenceExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintBooleanLiteral(ConstraintBooleanLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Null Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Null Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintNullLiteral(ConstraintNullLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Number Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Number Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintNumberLiteral(ConstraintNumberLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintStringLiteral(ConstraintStringLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //MappingLanguageSwitch