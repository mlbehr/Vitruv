/**
 */
package edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.impl;

import edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.CorrespondencePackage;
import edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.PartialEFeatureCorrespondence;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partial EFeature Correspondence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PartialEFeatureCorrespondenceImpl<TValue extends Object> extends EObjectImpl implements PartialEFeatureCorrespondence<TValue> {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PartialEFeatureCorrespondenceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CorrespondencePackage.Literals.PARTIAL_EFEATURE_CORRESPONDENCE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract TValue getValueA();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void setValueA(TValue valueA);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract TValue getValueB();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void setValueB(TValue valueB);

} //PartialEFeatureCorrespondenceImpl
