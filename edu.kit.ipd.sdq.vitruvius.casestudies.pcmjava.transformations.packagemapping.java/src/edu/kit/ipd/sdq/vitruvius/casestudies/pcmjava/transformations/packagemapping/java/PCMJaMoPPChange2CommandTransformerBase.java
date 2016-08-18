package edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.transformations.packagemapping.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.eclipse.emf.common.command.Command;

import edu.kit.ipd.sdq.vitruvius.casestudies.java.util.JaMoPPNamespace;
import edu.kit.ipd.sdq.vitruvius.casestudies.pcm.util.PCMNamespace;
import edu.kit.ipd.sdq.vitruvius.casestudies.pcmjava.preprocessors.java2pcm.Java2PcmPackagePreprocessor;
import edu.kit.ipd.sdq.vitruvius.codeintegration.change2command.IntegrationChange2CommandResult;
import edu.kit.ipd.sdq.vitruvius.codeintegration.change2command.IntegrationChange2CommandTransformer;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.change.CompositeChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.change.ConcreteChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Blackboard;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.TransformationResult;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VitruviusChange;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.Change2CommandTransforming;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.UserInteracting;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.util.bridges.EMFCommandBridge;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.util.datatypes.VitruviusTransformationRecordingCommand;
import edu.kit.ipd.sdq.vitruvius.framework.model.monitor.userinteractor.UserInteractor;
import edu.kit.ipd.sdq.vitruvius.framework.run.transformationexecuter.DefaultEObjectMappingTransformation;
import edu.kit.ipd.sdq.vitruvius.framework.run.transformationexecuter.TransformationExecuter;
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.Pair;

public abstract class PCMJaMoPPChange2CommandTransformerBase implements Change2CommandTransforming {

    // private static final Logger logger =
    // Logger.getLogger(PCMJaMoPPChange2CommandTransformerBase.class.getSimpleName());

    protected final TransformationExecuter transformationExecuter;

    private final List<Pair<VURI, VURI>> pairList;

    protected UserInteracting userInteracting;
    
    private IntegrationChange2CommandTransformer integrationTransformer;

    public PCMJaMoPPChange2CommandTransformerBase() {
        this.transformationExecuter = new TransformationExecuter();
        this.initializeTransformationExecuter();
        final VURI pcmVURI = VURI.getInstance(PCMNamespace.PCM_METAMODEL_NAMESPACE);
        final VURI jaMoPPVURI = VURI.getInstance(JaMoPPNamespace.JAMOPP_METAMODEL_NAMESPACE);
        final Pair<VURI, VURI> pcm2JaMoPP = new Pair<VURI, VURI>(pcmVURI, jaMoPPVURI);
        final Pair<VURI, VURI> jamopp2PCM = new Pair<VURI, VURI>(jaMoPPVURI, pcmVURI);
        this.pairList = new ArrayList<Pair<VURI, VURI>>();
        this.pairList.add(jamopp2PCM);
        this.pairList.add(pcm2JaMoPP);
    }

    protected void initializeTransformationExecuter() {
        this.userInteracting = new UserInteractor();
        this.integrationTransformer = new IntegrationChange2CommandTransformer(this.userInteracting);
        
        // Mapping for EObjects in order to avoid runtime exceptions
        this.transformationExecuter.addMapping(new DefaultEObjectMappingTransformation());

        // set userInteractor
        this.transformationExecuter.setUserInteracting(this.userInteracting);
    }

    /**
     * Executes the Java2PCM and PCM2Java transformations.
     */
    @Override
    public void transformChanges2Commands(final Blackboard blackboard) {
        final List<VitruviusChange> changesForTransformation = blackboard.getAndArchiveChangesForTransformation();
        final List<Command> commands = new ArrayList<Command>();
        if (this.hasChangeRefinerForChanges(changesForTransformation)) {
            commands.add(this.executeChangeRefiner(changesForTransformation, blackboard));
        } else {
            for (final VitruviusChange change : changesForTransformation) {
                if (change instanceof ConcreteChange) {
                	ConcreteChange emfModelChange = (ConcreteChange) change;
                	// Special behavior for changes to integrated elements
                	IntegrationChange2CommandResult integrationTransformResult = integrationTransformer.compute(emfModelChange.getEChanges().get(0), blackboard);
                	if (integrationTransformResult.isIntegrationChange()) {
                		commands.addAll(integrationTransformResult.getCommands());
                	} else {
                		commands.add(this.transformChange2Command(emfModelChange, blackboard));
                	}
                } else if (change instanceof CompositeChange) {
                    commands.addAll(this.transformCompositeChange((CompositeChange) change, blackboard));
                }
            }
        }
        blackboard.pushCommands(commands);
    }

    @Override
    public List<Pair<VURI, VURI>> getTransformableMetamodels() {
        return this.pairList;
    }

    private VitruviusTransformationRecordingCommand transformChange2Command(final ConcreteChange emfModelChange,
            final Blackboard blackboard) {
    	Java2PcmPackagePreprocessor packagePreprocessor = new Java2PcmPackagePreprocessor();
    	if (packagePreprocessor.doesProcess(emfModelChange)) {
    		packagePreprocessor.processChange(emfModelChange, null, blackboard);
    	}
        //this.handlePackageInEChange(emfModelChange);
        this.transformationExecuter.setBlackboard(blackboard);

        final VitruviusTransformationRecordingCommand command = EMFCommandBridge
                .createVitruviusTransformationRecordingCommand(new Callable<TransformationResult>() {
                    @Override
                    public TransformationResult call() {
                        final TransformationResult transformationResult = PCMJaMoPPChange2CommandTransformerBase.this.transformationExecuter
                                .executeTransformationForChange(emfModelChange.getEChanges().get(0));
                        return transformationResult;
                    }
                });

        return command;
    }

    private List<Command> transformCompositeChange(final CompositeChange compositeChange, final Blackboard blackboard) {
        final List<Command> commands = new ArrayList<Command>();
        for (final VitruviusChange change : compositeChange.getChanges()) {
            // handle CompositeChanges in CompositeChanges
            if (change instanceof CompositeChange) {
                commands.addAll(this.transformCompositeChange((CompositeChange) change, blackboard));
                continue;
            } else if (change instanceof ConcreteChange) {
                commands.add(this.transformChange2Command((ConcreteChange) change, blackboard));
            }
        }
        return commands;
    }

    protected boolean hasChangeRefinerForChanges(final List<VitruviusChange> changesForTransformation) {
        return false;
    }

    protected abstract Command executeChangeRefiner(
            final List<VitruviusChange> changesForTransformation, final Blackboard blackboard);

    @Override
    public void setUserInteracting(final UserInteracting userInteracting) {
        this.userInteracting = userInteracting;
        this.transformationExecuter.setUserInteracting(userInteracting);
    }
}