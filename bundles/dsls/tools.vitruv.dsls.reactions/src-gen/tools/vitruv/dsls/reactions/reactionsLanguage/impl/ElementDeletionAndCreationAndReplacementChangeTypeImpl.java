/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.reactions.reactionsLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.vitruv.dsls.reactions.reactionsLanguage.ElementCreationChangeType;
import tools.vitruv.dsls.reactions.reactionsLanguage.ElementDeletionAndCreationAndReplacementChangeType;
import tools.vitruv.dsls.reactions.reactionsLanguage.ElementDeletionChangeType;
import tools.vitruv.dsls.reactions.reactionsLanguage.ElementReplacementChangeType;
import tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Deletion And Creation And Replacement Change Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.impl.ElementDeletionAndCreationAndReplacementChangeTypeImpl#getDeleteChange <em>Delete Change</em>}</li>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.impl.ElementDeletionAndCreationAndReplacementChangeTypeImpl#getCreateChange <em>Create Change</em>}</li>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.impl.ElementDeletionAndCreationAndReplacementChangeTypeImpl#getReplacedChange <em>Replaced Change</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementDeletionAndCreationAndReplacementChangeTypeImpl extends ElementCompoundChangeTypeImpl implements ElementDeletionAndCreationAndReplacementChangeType
{
  /**
   * The cached value of the '{@link #getDeleteChange() <em>Delete Change</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeleteChange()
   * @generated
   * @ordered
   */
  protected ElementDeletionChangeType deleteChange;

  /**
   * The cached value of the '{@link #getCreateChange() <em>Create Change</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCreateChange()
   * @generated
   * @ordered
   */
  protected ElementCreationChangeType createChange;

  /**
   * The cached value of the '{@link #getReplacedChange() <em>Replaced Change</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReplacedChange()
   * @generated
   * @ordered
   */
  protected ElementReplacementChangeType replacedChange;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementDeletionAndCreationAndReplacementChangeTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReactionsLanguagePackage.Literals.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementDeletionChangeType getDeleteChange()
  {
    return deleteChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDeleteChange(ElementDeletionChangeType newDeleteChange, NotificationChain msgs)
  {
    ElementDeletionChangeType oldDeleteChange = deleteChange;
    deleteChange = newDeleteChange;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__DELETE_CHANGE, oldDeleteChange, newDeleteChange);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDeleteChange(ElementDeletionChangeType newDeleteChange)
  {
    if (newDeleteChange != deleteChange)
    {
      NotificationChain msgs = null;
      if (deleteChange != null)
        msgs = ((InternalEObject)deleteChange).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__DELETE_CHANGE, null, msgs);
      if (newDeleteChange != null)
        msgs = ((InternalEObject)newDeleteChange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__DELETE_CHANGE, null, msgs);
      msgs = basicSetDeleteChange(newDeleteChange, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__DELETE_CHANGE, newDeleteChange, newDeleteChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementCreationChangeType getCreateChange()
  {
    return createChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCreateChange(ElementCreationChangeType newCreateChange, NotificationChain msgs)
  {
    ElementCreationChangeType oldCreateChange = createChange;
    createChange = newCreateChange;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__CREATE_CHANGE, oldCreateChange, newCreateChange);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCreateChange(ElementCreationChangeType newCreateChange)
  {
    if (newCreateChange != createChange)
    {
      NotificationChain msgs = null;
      if (createChange != null)
        msgs = ((InternalEObject)createChange).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__CREATE_CHANGE, null, msgs);
      if (newCreateChange != null)
        msgs = ((InternalEObject)newCreateChange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__CREATE_CHANGE, null, msgs);
      msgs = basicSetCreateChange(newCreateChange, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__CREATE_CHANGE, newCreateChange, newCreateChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementReplacementChangeType getReplacedChange()
  {
    return replacedChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReplacedChange(ElementReplacementChangeType newReplacedChange, NotificationChain msgs)
  {
    ElementReplacementChangeType oldReplacedChange = replacedChange;
    replacedChange = newReplacedChange;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__REPLACED_CHANGE, oldReplacedChange, newReplacedChange);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReplacedChange(ElementReplacementChangeType newReplacedChange)
  {
    if (newReplacedChange != replacedChange)
    {
      NotificationChain msgs = null;
      if (replacedChange != null)
        msgs = ((InternalEObject)replacedChange).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__REPLACED_CHANGE, null, msgs);
      if (newReplacedChange != null)
        msgs = ((InternalEObject)newReplacedChange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__REPLACED_CHANGE, null, msgs);
      msgs = basicSetReplacedChange(newReplacedChange, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__REPLACED_CHANGE, newReplacedChange, newReplacedChange));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__DELETE_CHANGE:
        return basicSetDeleteChange(null, msgs);
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__CREATE_CHANGE:
        return basicSetCreateChange(null, msgs);
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__REPLACED_CHANGE:
        return basicSetReplacedChange(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__DELETE_CHANGE:
        return getDeleteChange();
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__CREATE_CHANGE:
        return getCreateChange();
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__REPLACED_CHANGE:
        return getReplacedChange();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__DELETE_CHANGE:
        setDeleteChange((ElementDeletionChangeType)newValue);
        return;
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__CREATE_CHANGE:
        setCreateChange((ElementCreationChangeType)newValue);
        return;
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__REPLACED_CHANGE:
        setReplacedChange((ElementReplacementChangeType)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__DELETE_CHANGE:
        setDeleteChange((ElementDeletionChangeType)null);
        return;
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__CREATE_CHANGE:
        setCreateChange((ElementCreationChangeType)null);
        return;
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__REPLACED_CHANGE:
        setReplacedChange((ElementReplacementChangeType)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__DELETE_CHANGE:
        return deleteChange != null;
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__CREATE_CHANGE:
        return createChange != null;
      case ReactionsLanguagePackage.ELEMENT_DELETION_AND_CREATION_AND_REPLACEMENT_CHANGE_TYPE__REPLACED_CHANGE:
        return replacedChange != null;
    }
    return super.eIsSet(featureID);
  }

} //ElementDeletionAndCreationAndReplacementChangeTypeImpl