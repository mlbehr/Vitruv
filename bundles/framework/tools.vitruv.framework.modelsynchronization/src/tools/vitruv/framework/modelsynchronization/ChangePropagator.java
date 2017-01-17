package tools.vitruv.framework.modelsynchronization;

import java.util.List;

import tools.vitruv.framework.change.description.VitruviusChange;

public interface ChangePropagator {
    /**
     * Resort changes and igores undos/redos.
     *
     * @param change
     *            list of changes
     * @return TODO
     */
    List<List<VitruviusChange>> propagateChange(VitruviusChange change);

    void addChangePropagationListener(ChangePropagationListener propagationListener);

    void removeChangePropagationListener(ChangePropagationListener propagationListener);
}