package edu.kit.ipd.sdq.vitruvius.framework.contracts.util.datatypes;

import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.TransformationResult;
import edu.kit.ipd.sdq.vitruvius.framework.util.bridges.JavaBridge;

public abstract class VitruviusRecordingCommand extends RecordingCommand {

    protected static final Logger logger = Logger.getLogger(VitruviusRecordingCommand.class.getSimpleName());

    protected TransformationResult transformationResult;
    private RuntimeException runtimeException;

    public VitruviusRecordingCommand() {
        super(null);
        this.runtimeException = null;
    }

    public void setTransactionDomain(final TransactionalEditingDomain domain) {
        JavaBridge.setFieldInClass(RecordingCommand.class, "domain", this, domain);
    }

    @Override
    protected void preExecute() {
        this.runtimeException = null;
        super.preExecute();
    }

    public void setRuntimeException(final RuntimeException e) {
        this.runtimeException = e;
    }

    public void rethrowRuntimeExceptionIfExisting() {
        if (this.runtimeException != null) {
            throw (this.runtimeException);
        }
    }

    protected void storeAndRethrowException(final Throwable e) {
        RuntimeException r;
        if (e instanceof RuntimeException) {
            r = (RuntimeException) e;
        } else {
            // soften
            r = new RuntimeException(e);
        }
        setRuntimeException(r);
        // just log and rethrow
        throw (r);
    }
}