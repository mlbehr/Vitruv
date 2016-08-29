/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.change.echange.feature.attribute;

import edu.kit.ipd.sdq.vitruvius.framework.change.echange.AdditiveEChange;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Attribute EChange</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.vitruvius.framework.change.echange.feature.attribute.AdditiveAttributeEChange#getNewValue <em>New Value</em>}</li>
 * </ul>
 *
 * @see edu.kit.ipd.sdq.vitruvius.framework.change.echange.feature.attribute.AttributePackage#getAdditiveAttributeEChange()
 * @model abstract="true" TBounds="org.eclipse.emf.ecore.EJavaObject"
 * @generated
 */
public interface AdditiveAttributeEChange<A extends EObject, T extends Object> extends AdditiveEChange<T>, UpdateAttributeEChange<A> {
    /**
	 * Returns the value of the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>New Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' attribute.
	 * @see #setNewValue(Object)
	 * @see edu.kit.ipd.sdq.vitruvius.framework.change.echange.feature.attribute.AttributePackage#getAdditiveAttributeEChange_NewValue()
	 * @model required="true"
	 * @generated
	 */
    T getNewValue();

    /**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.vitruvius.framework.change.echange.feature.attribute.AdditiveAttributeEChange#getNewValue <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' attribute.
	 * @see #getNewValue()
	 * @generated
	 */
    void setNewValue(T value);

} // AdditiveAttributeEChange
