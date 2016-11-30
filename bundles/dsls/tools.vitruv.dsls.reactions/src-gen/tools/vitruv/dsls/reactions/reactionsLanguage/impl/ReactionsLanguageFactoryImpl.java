/**
 * generated by Xtext 2.10.0
 */
package tools.vitruv.dsls.reactions.reactionsLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tools.vitruv.dsls.reactions.reactionsLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReactionsLanguageFactoryImpl extends EFactoryImpl implements ReactionsLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReactionsLanguageFactory init()
  {
    try
    {
      ReactionsLanguageFactory theReactionsLanguageFactory = (ReactionsLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(ReactionsLanguagePackage.eNS_URI);
      if (theReactionsLanguageFactory != null)
      {
        return theReactionsLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ReactionsLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionsLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ReactionsLanguagePackage.REACTIONS_FILE: return createReactionsFile();
      case ReactionsLanguagePackage.REACTIONS_SEGMENT: return createReactionsSegment();
      case ReactionsLanguagePackage.REACTION: return createReaction();
      case ReactionsLanguagePackage.REACTION_ROUTINE_CALL: return createReactionRoutineCall();
      case ReactionsLanguagePackage.INVARIANT_VIOLATION_EVENT: return createInvariantViolationEvent();
      case ReactionsLanguagePackage.TRIGGER: return createTrigger();
      case ReactionsLanguagePackage.MODEL_CHANGE: return createModelChange();
      case ReactionsLanguagePackage.CONCRETE_MODEL_ELEMENT_CHANGE: return createConcreteModelElementChange();
      case ReactionsLanguagePackage.ATOMIC_CONCRETE_MODEL_ELEMENT_CHANGE: return createAtomicConcreteModelElementChange();
      case ReactionsLanguagePackage.ATOMIC_ROOT_OBJECT_CHANGE: return createAtomicRootObjectChange();
      case ReactionsLanguagePackage.ATOMIC_FEATURE_CHANGE: return createAtomicFeatureChange();
      case ReactionsLanguagePackage.ATOMIC_MULTI_VALUED_FEATURE_CHANGE: return createAtomicMultiValuedFeatureChange();
      case ReactionsLanguagePackage.ATOMIC_SINGLE_VALUED_FEATURE_CHANGE: return createAtomicSingleValuedFeatureChange();
      case ReactionsLanguagePackage.ARBITRARY_MODEL_ELEMENT_CHANGE: return createArbitraryModelElementChange();
      case ReactionsLanguagePackage.ROUTINE: return createRoutine();
      case ReactionsLanguagePackage.ROUTINE_INPUT: return createRoutineInput();
      case ReactionsLanguagePackage.MATCHER: return createMatcher();
      case ReactionsLanguagePackage.MATCHER_STATEMENT: return createMatcherStatement();
      case ReactionsLanguagePackage.RETRIEVE_MODEL_ELEMENT: return createRetrieveModelElement();
      case ReactionsLanguagePackage.MATCHER_CHECK_STATEMENT: return createMatcherCheckStatement();
      case ReactionsLanguagePackage.ACTION: return createAction();
      case ReactionsLanguagePackage.ROUTINE_CALL_STATEMENT: return createRoutineCallStatement();
      case ReactionsLanguagePackage.ACTION_STATEMENT: return createActionStatement();
      case ReactionsLanguagePackage.CREATE_MODEL_ELEMENT: return createCreateModelElement();
      case ReactionsLanguagePackage.DELETE_MODEL_ELEMENT: return createDeleteModelElement();
      case ReactionsLanguagePackage.UPDATE_MODEL_ELEMENT: return createUpdateModelElement();
      case ReactionsLanguagePackage.CREATE_CORRESPONDENCE: return createCreateCorrespondence();
      case ReactionsLanguagePackage.REMOVE_CORRESPONDENCE: return createRemoveCorrespondence();
      case ReactionsLanguagePackage.CODE_BLOCK: return createCodeBlock();
      case ReactionsLanguagePackage.EXECUTE_ACTION_BLOCK: return createExecuteActionBlock();
      case ReactionsLanguagePackage.ROUTINE_CALL_BLOCK: return createRoutineCallBlock();
      case ReactionsLanguagePackage.TAGGABLE: return createTaggable();
      case ReactionsLanguagePackage.EXISTING_ELEMENT_REFERENCE: return createExistingElementReference();
      case ReactionsLanguagePackage.TAG_CODE_BLOCK: return createTagCodeBlock();
      case ReactionsLanguagePackage.PRECONDITION_CODE_BLOCK: return createPreconditionCodeBlock();
      case ReactionsLanguagePackage.CORRESPONDING_OBJECT_CODE_BLOCK: return createCorrespondingObjectCodeBlock();
      case ReactionsLanguagePackage.EXECUTION_CODE_BLOCK: return createExecutionCodeBlock();
      case ReactionsLanguagePackage.RETURN_STATEMENT: return createReturnStatement();
      case ReactionsLanguagePackage.INSERT_ROOT_CHANGE: return createInsertRootChange();
      case ReactionsLanguagePackage.REMOVE_ROOT_CHANGE: return createRemoveRootChange();
      case ReactionsLanguagePackage.MULTI_VALUED_FEATURE_INSERT_CHANGE: return createMultiValuedFeatureInsertChange();
      case ReactionsLanguagePackage.MULTI_VALUED_FEATURE_REMOVE_CHANGE: return createMultiValuedFeatureRemoveChange();
      case ReactionsLanguagePackage.MULTI_VALUED_FEATURE_PERMUTE_CHANGE: return createMultiValuedFeaturePermuteChange();
      case ReactionsLanguagePackage.SINGLE_VALUED_FEATURE_REPLACE: return createSingleValuedFeatureReplace();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionsFile createReactionsFile()
  {
    ReactionsFileImpl reactionsFile = new ReactionsFileImpl();
    return reactionsFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionsSegment createReactionsSegment()
  {
    ReactionsSegmentImpl reactionsSegment = new ReactionsSegmentImpl();
    return reactionsSegment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reaction createReaction()
  {
    ReactionImpl reaction = new ReactionImpl();
    return reaction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionRoutineCall createReactionRoutineCall()
  {
    ReactionRoutineCallImpl reactionRoutineCall = new ReactionRoutineCallImpl();
    return reactionRoutineCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvariantViolationEvent createInvariantViolationEvent()
  {
    InvariantViolationEventImpl invariantViolationEvent = new InvariantViolationEventImpl();
    return invariantViolationEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger createTrigger()
  {
    TriggerImpl trigger = new TriggerImpl();
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelChange createModelChange()
  {
    ModelChangeImpl modelChange = new ModelChangeImpl();
    return modelChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcreteModelElementChange createConcreteModelElementChange()
  {
    ConcreteModelElementChangeImpl concreteModelElementChange = new ConcreteModelElementChangeImpl();
    return concreteModelElementChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomicConcreteModelElementChange createAtomicConcreteModelElementChange()
  {
    AtomicConcreteModelElementChangeImpl atomicConcreteModelElementChange = new AtomicConcreteModelElementChangeImpl();
    return atomicConcreteModelElementChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomicRootObjectChange createAtomicRootObjectChange()
  {
    AtomicRootObjectChangeImpl atomicRootObjectChange = new AtomicRootObjectChangeImpl();
    return atomicRootObjectChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomicFeatureChange createAtomicFeatureChange()
  {
    AtomicFeatureChangeImpl atomicFeatureChange = new AtomicFeatureChangeImpl();
    return atomicFeatureChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomicMultiValuedFeatureChange createAtomicMultiValuedFeatureChange()
  {
    AtomicMultiValuedFeatureChangeImpl atomicMultiValuedFeatureChange = new AtomicMultiValuedFeatureChangeImpl();
    return atomicMultiValuedFeatureChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomicSingleValuedFeatureChange createAtomicSingleValuedFeatureChange()
  {
    AtomicSingleValuedFeatureChangeImpl atomicSingleValuedFeatureChange = new AtomicSingleValuedFeatureChangeImpl();
    return atomicSingleValuedFeatureChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArbitraryModelElementChange createArbitraryModelElementChange()
  {
    ArbitraryModelElementChangeImpl arbitraryModelElementChange = new ArbitraryModelElementChangeImpl();
    return arbitraryModelElementChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Routine createRoutine()
  {
    RoutineImpl routine = new RoutineImpl();
    return routine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoutineInput createRoutineInput()
  {
    RoutineInputImpl routineInput = new RoutineInputImpl();
    return routineInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Matcher createMatcher()
  {
    MatcherImpl matcher = new MatcherImpl();
    return matcher;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatcherStatement createMatcherStatement()
  {
    MatcherStatementImpl matcherStatement = new MatcherStatementImpl();
    return matcherStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RetrieveModelElement createRetrieveModelElement()
  {
    RetrieveModelElementImpl retrieveModelElement = new RetrieveModelElementImpl();
    return retrieveModelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MatcherCheckStatement createMatcherCheckStatement()
  {
    MatcherCheckStatementImpl matcherCheckStatement = new MatcherCheckStatementImpl();
    return matcherCheckStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action createAction()
  {
    ActionImpl action = new ActionImpl();
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoutineCallStatement createRoutineCallStatement()
  {
    RoutineCallStatementImpl routineCallStatement = new RoutineCallStatementImpl();
    return routineCallStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionStatement createActionStatement()
  {
    ActionStatementImpl actionStatement = new ActionStatementImpl();
    return actionStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CreateModelElement createCreateModelElement()
  {
    CreateModelElementImpl createModelElement = new CreateModelElementImpl();
    return createModelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeleteModelElement createDeleteModelElement()
  {
    DeleteModelElementImpl deleteModelElement = new DeleteModelElementImpl();
    return deleteModelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UpdateModelElement createUpdateModelElement()
  {
    UpdateModelElementImpl updateModelElement = new UpdateModelElementImpl();
    return updateModelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CreateCorrespondence createCreateCorrespondence()
  {
    CreateCorrespondenceImpl createCorrespondence = new CreateCorrespondenceImpl();
    return createCorrespondence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RemoveCorrespondence createRemoveCorrespondence()
  {
    RemoveCorrespondenceImpl removeCorrespondence = new RemoveCorrespondenceImpl();
    return removeCorrespondence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CodeBlock createCodeBlock()
  {
    CodeBlockImpl codeBlock = new CodeBlockImpl();
    return codeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecuteActionBlock createExecuteActionBlock()
  {
    ExecuteActionBlockImpl executeActionBlock = new ExecuteActionBlockImpl();
    return executeActionBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoutineCallBlock createRoutineCallBlock()
  {
    RoutineCallBlockImpl routineCallBlock = new RoutineCallBlockImpl();
    return routineCallBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Taggable createTaggable()
  {
    TaggableImpl taggable = new TaggableImpl();
    return taggable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExistingElementReference createExistingElementReference()
  {
    ExistingElementReferenceImpl existingElementReference = new ExistingElementReferenceImpl();
    return existingElementReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TagCodeBlock createTagCodeBlock()
  {
    TagCodeBlockImpl tagCodeBlock = new TagCodeBlockImpl();
    return tagCodeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreconditionCodeBlock createPreconditionCodeBlock()
  {
    PreconditionCodeBlockImpl preconditionCodeBlock = new PreconditionCodeBlockImpl();
    return preconditionCodeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CorrespondingObjectCodeBlock createCorrespondingObjectCodeBlock()
  {
    CorrespondingObjectCodeBlockImpl correspondingObjectCodeBlock = new CorrespondingObjectCodeBlockImpl();
    return correspondingObjectCodeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecutionCodeBlock createExecutionCodeBlock()
  {
    ExecutionCodeBlockImpl executionCodeBlock = new ExecutionCodeBlockImpl();
    return executionCodeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnStatement createReturnStatement()
  {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    return returnStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InsertRootChange createInsertRootChange()
  {
    InsertRootChangeImpl insertRootChange = new InsertRootChangeImpl();
    return insertRootChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RemoveRootChange createRemoveRootChange()
  {
    RemoveRootChangeImpl removeRootChange = new RemoveRootChangeImpl();
    return removeRootChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiValuedFeatureInsertChange createMultiValuedFeatureInsertChange()
  {
    MultiValuedFeatureInsertChangeImpl multiValuedFeatureInsertChange = new MultiValuedFeatureInsertChangeImpl();
    return multiValuedFeatureInsertChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiValuedFeatureRemoveChange createMultiValuedFeatureRemoveChange()
  {
    MultiValuedFeatureRemoveChangeImpl multiValuedFeatureRemoveChange = new MultiValuedFeatureRemoveChangeImpl();
    return multiValuedFeatureRemoveChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiValuedFeaturePermuteChange createMultiValuedFeaturePermuteChange()
  {
    MultiValuedFeaturePermuteChangeImpl multiValuedFeaturePermuteChange = new MultiValuedFeaturePermuteChangeImpl();
    return multiValuedFeaturePermuteChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleValuedFeatureReplace createSingleValuedFeatureReplace()
  {
    SingleValuedFeatureReplaceImpl singleValuedFeatureReplace = new SingleValuedFeatureReplaceImpl();
    return singleValuedFeatureReplace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionsLanguagePackage getReactionsLanguagePackage()
  {
    return (ReactionsLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ReactionsLanguagePackage getPackage()
  {
    return ReactionsLanguagePackage.eINSTANCE;
  }

} //ReactionsLanguageFactoryImpl