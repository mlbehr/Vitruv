package edu.kit.ipd.sdq.vitruvius.tests.framework.changedescription2change.util;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AdditiveEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.AdditiveEReferenceChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EAtomicChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.EChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.SubtractiveEChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.SubtractiveEReferenceChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.compound.ECompoundChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.compound.ExplicitUnsetEFeature;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.compound.MoveEObject;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.compound.ReplaceInEList;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.EFeatureChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.InsertEAttributeValue;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.attribute.RemoveEAttributeValue;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.InsertInEList;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.PermuteEList;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.RemoveFromEList;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.list.UpdateSingleEListEntry;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.reference.InsertEReference;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.reference.RemoveEReference;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.reference.ReplaceSingleValuedEReference;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.feature.reference.UpdateEReference;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.root.InsertRootEObject;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.change.root.RemoveRootEObject;
import edu.kit.ipd.sdq.vitruvius.framework.util.bridges.CollectionBridge;
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.Pair;
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.Quadruple;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.Assert;

@SuppressWarnings("all")
public class ChangeAssertHelper {
  private ChangeAssertHelper() {
  }
  
  public static <T extends Object> T assertSingleChangeWithType(final List<?> changes, final Class<T> type) {
    CollectionBridge.claimOne(changes);
    Object _get = changes.get(0);
    return ChangeAssertHelper.<T>assertObjectInstanceOf(_get, type);
  }
  
  public static <T extends Object> T assertObjectInstanceOf(final Object object, final Class<T> type) {
    Class<?> _class = object.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("The object " + _simpleName);
    String _plus_1 = (_plus + " should be type of ");
    String _simpleName_1 = type.getSimpleName();
    String _plus_2 = (_plus_1 + _simpleName_1);
    boolean _isInstance = type.isInstance(object);
    Assert.assertTrue(_plus_2, _isInstance);
    return type.cast(object);
  }
  
  public static void assertOldAndNewValue(final EChange eChange, final Object oldValue, final Object newValue) {
    ChangeAssertHelper.assertOldValue(eChange, oldValue);
    ChangeAssertHelper.assertNewValue(eChange, newValue);
  }
  
  public static void assertOldValue(final EChange eChange, final Object oldValue) {
    Object _oldValue = ((SubtractiveEChange<?>) eChange).getOldValue();
    Assert.assertEquals("old value must be the same than the given old value", oldValue, _oldValue);
  }
  
  public static void assertNewValue(final EChange eChange, final Object newValue) {
    Object _newValue = ((AdditiveEChange<?>) eChange).getNewValue();
    Assert.assertEquals("new value must be the same than the given new value", newValue, _newValue);
  }
  
  public static void assertAffectedEObject(final EChange eChange, final EObject expectedAffectedEObject) {
    EObject _affectedEObject = ((EFeatureChange<?, ?>) eChange).getAffectedEObject();
    Assert.assertEquals("The actual affected EObject is a different one than the expected affected EObject", _affectedEObject, expectedAffectedEObject);
  }
  
  public static void assertAffectedEFeature(final EChange eChange, final EStructuralFeature expectedEFeature) {
    EStructuralFeature _affectedFeature = ((EFeatureChange<?, ?>) eChange).getAffectedFeature();
    Assert.assertEquals(
      "The actual affected EStructuralFeature is a different one than the expected EStructuralFeature", _affectedFeature, expectedEFeature);
  }
  
  public static EStructuralFeature getFeautreByName(final EObject eObject, final String name) {
    EClass _eClass = eObject.eClass();
    return _eClass.getEStructuralFeature(name);
  }
  
  public static void assertIndices(final PermuteEList permuteChange, final List<Integer> expectedIndices) {
    EList<Integer> _newIndicesForElementsAtOldIndices = permuteChange.getNewIndicesForElementsAtOldIndices();
    Assert.assertEquals("The new indices for elements at old indices is wrong", _newIndicesForElementsAtOldIndices, expectedIndices);
  }
  
  public static void assertPermuteListTest(final List<?> changes, final EObject rootElement, final List<Integer> expectedIndicesForElementsAtOldIndices, final String featureName, final Class<? extends PermuteEList> changeType) {
    ChangeAssertHelper.assertSingleChangeWithType(changes, changeType);
    Object _get = changes.get(0);
    final PermuteEList permuteEAttributeValues = changeType.cast(_get);
    ChangeAssertHelper.assertAffectedEObject(permuteEAttributeValues, rootElement);
    EStructuralFeature _feautreByName = ChangeAssertHelper.getFeautreByName(rootElement, featureName);
    ChangeAssertHelper.assertAffectedEFeature(permuteEAttributeValues, _feautreByName);
    ChangeAssertHelper.assertIndices(permuteEAttributeValues, expectedIndicesForElementsAtOldIndices);
  }
  
  public static void assertContainment(final UpdateEReference<?> updateEReference, final boolean expectedValue) {
    boolean _isContainment = updateEReference.isContainment();
    Assert.assertEquals((("The containment information of the change " + updateEReference) + " is wrong"), Boolean.valueOf(_isContainment), Boolean.valueOf(expectedValue));
  }
  
  public static void assertIsDelete(final SubtractiveEReferenceChange<?> subtractiveReference, final boolean expectedValue) {
    boolean _isIsDelete = subtractiveReference.isIsDelete();
    Assert.assertEquals((("Change " + subtractiveReference) + " shall not be a delete change"), Boolean.valueOf(_isIsDelete), Boolean.valueOf(expectedValue));
  }
  
  public static void assertIsCreate(final AdditiveEReferenceChange<?> additiveReference, final boolean expectedValue) {
    boolean _isIsCreate = additiveReference.isIsCreate();
    Assert.assertEquals((("Change " + additiveReference) + " shall not be a create change"), Boolean.valueOf(_isIsCreate), Boolean.valueOf(expectedValue));
  }
  
  public static void assertReplaceSingleValuedEReference(final List<?> changes, final Object expectedOldValue, final Object expectedNewValue, final String affectedEFeatureName, final EObject affectedEObject, final boolean isContainment, final boolean isCreate, final boolean isDelete) {
    final ReplaceSingleValuedEReference change = ChangeAssertHelper.<ReplaceSingleValuedEReference>assertSingleChangeWithType(changes, ReplaceSingleValuedEReference.class);
    ChangeAssertHelper.assertOldAndNewValue(change, expectedOldValue, expectedNewValue);
    EStructuralFeature _feautreByName = ChangeAssertHelper.getFeautreByName(affectedEObject, affectedEFeatureName);
    ChangeAssertHelper.assertAffectedEFeature(change, _feautreByName);
    ChangeAssertHelper.assertAffectedEObject(change, affectedEObject);
    ChangeAssertHelper.assertContainment(change, isContainment);
  }
  
  public static void assertIndex(final UpdateSingleEListEntry change, final int expectedIndex) {
    int _index = change.getIndex();
    Assert.assertEquals("The value is not at the correct index", _index, expectedIndex);
  }
  
  public static void assertSubtractiveChange(final List<?> changes, final EObject affectedEObject, final String affectedFeatureName, final Object oldValue, final int expectedOldIndex, final boolean isContainment, final boolean isDelete) {
    final RemoveEReference change = ChangeAssertHelper.<RemoveEReference>assertSingleChangeWithType(changes, RemoveEReference.class);
    EStructuralFeature _feautreByName = ChangeAssertHelper.getFeautreByName(affectedEObject, affectedFeatureName);
    ChangeAssertHelper.assertAffectedEFeature(change, _feautreByName);
    ChangeAssertHelper.assertAffectedEObject(change, affectedEObject);
    ChangeAssertHelper.assertOldValue(change, oldValue);
    if ((change instanceof RemoveFromEList)) {
      ChangeAssertHelper.assertIndex(change, expectedOldIndex);
    }
    ChangeAssertHelper.assertContainment(change, isContainment);
    ChangeAssertHelper.assertIsDelete(change, isDelete);
  }
  
  public static void assertRemoveEAttribute(final List<?> changes, final EObject affecteEObject, final String featureName, final Object oldValue, final int expectedOldIndex) {
    ChangeAssertHelper.<RemoveEAttributeValue>assertSingleChangeWithType(changes, RemoveEAttributeValue.class);
    Object _get = changes.get(0);
    final RemoveEAttributeValue<?, ?> removeEAttributeValue = ((RemoveEAttributeValue<?, ?>) _get);
    ChangeAssertHelper.assertAffectedEObject(removeEAttributeValue, affecteEObject);
    EStructuralFeature _feautreByName = ChangeAssertHelper.getFeautreByName(affecteEObject, featureName);
    ChangeAssertHelper.assertAffectedEFeature(removeEAttributeValue, _feautreByName);
    ChangeAssertHelper.assertOldValue(removeEAttributeValue, oldValue);
    ChangeAssertHelper.assertIndex(removeEAttributeValue, expectedOldIndex);
  }
  
  public static List<?> assertExplicitUnset(final List<?> changes) {
    final ExplicitUnsetEFeature unsetChange = ChangeAssertHelper.<ExplicitUnsetEFeature>assertSingleChangeWithType(changes, ExplicitUnsetEFeature.class);
    EList _atomicChanges = unsetChange.getAtomicChanges();
    EList _subtractiveChanges = unsetChange.getSubtractiveChanges();
    Assert.assertEquals("atomic changes should be the same than the subtractive changes", _atomicChanges, _subtractiveChanges);
    return unsetChange.getSubtractiveChanges();
  }
  
  public static void assertInsertRootEObject(final List<?> changes, final Object newValue, final boolean isCreate) {
    final InsertRootEObject insertRoot = ChangeAssertHelper.<InsertRootEObject>assertSingleChangeWithType(changes, InsertRootEObject.class);
    ChangeAssertHelper.assertNewValue(insertRoot, newValue);
    ChangeAssertHelper.assertIsCreate(insertRoot, isCreate);
  }
  
  public static void assertRemoveRootEObject(final List<?> changes, final Object oldValue, final boolean isDelete) {
    final RemoveRootEObject removeRoot = ChangeAssertHelper.<RemoveRootEObject>assertSingleChangeWithType(changes, RemoveRootEObject.class);
    ChangeAssertHelper.assertOldValue(removeRoot, oldValue);
    ChangeAssertHelper.assertIsDelete(removeRoot, isDelete);
  }
  
  public static Quadruple<SubtractiveEReferenceChange<?>, UpdateEReference<?>, AdditiveEReferenceChange<?>, UpdateEReference<?>> assertMoveEObject(final List<?> changes, final int atomicChanges) {
    final MoveEObject moveEObject = ChangeAssertHelper.<MoveEObject>assertSingleChangeWithType(changes, MoveEObject.class);
    ChangeAssertHelper.assertAtomicChanges(moveEObject, atomicChanges);
    final SubtractiveEReferenceChange subtractiveReferenceChange = moveEObject.getSubtractWhatChange();
    final UpdateEReference removeUpdateEReferenceChange = moveEObject.getSubtractWhereChange();
    final AdditiveEReferenceChange addEReferenceChange = moveEObject.getAddWhatChange();
    final UpdateEReference addUpdateEReferenceChange = moveEObject.getAddWhereChange();
    return new Quadruple<SubtractiveEReferenceChange<?>, UpdateEReference<?>, AdditiveEReferenceChange<?>, UpdateEReference<?>>(subtractiveReferenceChange, removeUpdateEReferenceChange, addEReferenceChange, addUpdateEReferenceChange);
  }
  
  public static Pair<RemoveFromEList, InsertInEList> assertReplaceInEList(final List<?> changes, final int atomicChanges) {
    final ReplaceInEList replaceInEList = ChangeAssertHelper.<ReplaceInEList>assertSingleChangeWithType(changes, ReplaceInEList.class);
    ChangeAssertHelper.assertAtomicChanges(replaceInEList, atomicChanges);
    final EAtomicChange removeChange = ((EAtomicChange)replaceInEList.getRemoveChange());
    final EAtomicChange insertInEList = ((EAtomicChange)replaceInEList.getInsertChange());
    return new Pair<RemoveFromEList, InsertInEList>(((RemoveFromEList)removeChange), ((InsertInEList)insertInEList));
  }
  
  public static void assertAtomicChanges(final ECompoundChange eCompoundChange, final int atomicChanges) {
    EList<EAtomicChange> _atomicChanges = eCompoundChange.getAtomicChanges();
    int _size = _atomicChanges.size();
    Assert.assertEquals((("Expected exactly " + Integer.valueOf(atomicChanges)) + " changes in move EObject"), _size, atomicChanges);
  }
  
  public static void assertInsertEReference(final List<?> changes, final EObject affectedEObject, final String featureName, final Object expectedNewValue, final int expectedIndex, final boolean isContainment, final boolean isCreate) {
    final InsertEReference insertEReference = ChangeAssertHelper.<InsertEReference>assertSingleChangeWithType(changes, InsertEReference.class);
    ChangeAssertHelper.assertAffectedEObject(insertEReference, affectedEObject);
    EStructuralFeature _feautreByName = ChangeAssertHelper.getFeautreByName(affectedEObject, featureName);
    ChangeAssertHelper.assertAffectedEFeature(insertEReference, _feautreByName);
    ChangeAssertHelper.assertNewValue(insertEReference, expectedNewValue);
    ChangeAssertHelper.assertIndex(insertEReference, expectedIndex);
    ChangeAssertHelper.assertContainment(insertEReference, isContainment);
    ChangeAssertHelper.assertIsCreate(insertEReference, isCreate);
  }
  
  public static void assertInsertEAttribute(final List<?> changes, final EObject affectedEObject, final String featureName, final Object expectedValue, final int expectedIndex) {
    ChangeAssertHelper.<InsertEAttributeValue>assertSingleChangeWithType(changes, InsertEAttributeValue.class);
    Object _get = changes.get(0);
    final InsertEAttributeValue<?, ?> insertEAttributValue = ((InsertEAttributeValue<?, ?>) _get);
    EObject _affectedEObject = insertEAttributValue.getAffectedEObject();
    ChangeAssertHelper.assertAffectedEObject(insertEAttributValue, _affectedEObject);
    ChangeAssertHelper.assertNewValue(insertEAttributValue, expectedValue);
    ChangeAssertHelper.assertIndex(insertEAttributValue, expectedIndex);
    EStructuralFeature _feautreByName = ChangeAssertHelper.getFeautreByName(affectedEObject, featureName);
    ChangeAssertHelper.assertAffectedEFeature(insertEAttributValue, _feautreByName);
  }
}