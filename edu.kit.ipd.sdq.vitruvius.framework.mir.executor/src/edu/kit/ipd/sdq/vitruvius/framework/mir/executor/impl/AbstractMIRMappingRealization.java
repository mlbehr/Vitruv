package edu.kit.ipd.sdq.vitruvius.framework.mir.executor.impl;

import static org.eclipse.xtext.xbase.lib.IterableExtensions.filter;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.toList;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Blackboard;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.CorrespondenceInstance;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.TransformationResult;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.ModelProviding;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.EChange;
import edu.kit.ipd.sdq.vitruvius.framework.meta.correspondence.datatypes.TUID;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.api.MappedCorrespondenceInstance;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.helpers.EclipseHelper;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.helpers.MIRMappingHelper;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.interfaces.MIRMappingRealization;

/**
 * {@link AbstractMIRMappingRealization} is extended by the code generated from
 * the intermediate language.
 * <p>
 * A mapping is instantiated for two model instances.
 * 
 * @author Dominik Werle
 *
 */
public abstract class AbstractMIRMappingRealization implements MIRMappingRealization {
	private final static Logger LOGGER = Logger.getLogger(AbstractMIRMappingRealization.class);

	/**
	 * Returns the {@link EClass} mapped by this mapping.
	 * 
	 * @return the {@link EClass} mapped by this mapping
	 */
	protected abstract EClass getMappedEClass();

	/**
	 * Check if the conditions of the mapping hold for the given {@link EObject}
	 * .
	 * 
	 * @param eObject
	 *            the object to check
	 * @return true if the mapping holds for the given object.
	 */
	protected abstract boolean checkConditions(EObject eObject, Blackboard blackboard);

	/**
	 * Ensure that the postconditions ("where") still hold for the mapping.
	 * <p>
	 * The given {@link EChange} can be used to select the conditions that have
	 * to be checked.
	 * 
	 * @param eObject
	 *            the {@link EObject} that has been changed
	 * @param target
	 *            the {@link EObject} that <code>eObject</code> is corresponding
	 *            to
	 * @param eChange
	 *            the change that was applied
	 * @return
	 */
	protected abstract void restorePostConditions(EObject eObject, EObject target, EChange change,
			Blackboard blackboard);

	/**
	 * Creates a corresponding object for <code>eObject</code> and a
	 * correspondence in the mapped meta model and registers it
	 * 
	 * @return the created objects
	 */
	protected abstract Collection<EObject> createCorresponding(EObject eObject, Blackboard blackboard);

	/**
	 * Deletes the corresponding object (and its children) and the
	 * correspondence.
	 * 
	 * @param eObject
	 * @param correspondenceInstance
	 */
	protected void deleteCorresponding(EObject eObject, EObject target, Blackboard blackboard) {
		// TODO: implement

		EcoreUtil.delete(target);
		throw new UnsupportedOperationException("Not implemented");

		// return result;
	}

	/**
	 * Returns {@link EObject EObjects} that are possibly affected by this
	 * change.
	 * 
	 * @param eChange
	 * @return
	 */
	protected Collection<EObject> getCandidates(EChange eChange) {
		final EClass mappedEClass = getMappedEClass();
		Collection<EObject> affectedObjects = MIRMappingHelper.getAllAffectedObjects(eChange);
		return toList(filter(affectedObjects, p -> p.eClass().equals(mappedEClass)));
	}

	// FIXME DW: protected? move to MappedCorrespondenceInstance?
	protected static MappedCorrespondenceInstance getMappedCorrespondenceInstanceFromBlackboard(Blackboard blackboard) {
		CorrespondenceInstance correspondenceInstance = blackboard.getCorrespondenceInstance();
		if (!(correspondenceInstance instanceof MappedCorrespondenceInstance)) {
			throw new IllegalArgumentException("The given correspondence instance " + correspondenceInstance
					+ " is not a " + MappedCorrespondenceInstance.class.getSimpleName());
		} else {
			return (MappedCorrespondenceInstance) correspondenceInstance;
		}
	}

	@Override
	public TransformationResult applyEChange(EChange eChange, Blackboard blackboard) {
		MappedCorrespondenceInstance correspondenceInstance = getMappedCorrespondenceInstanceFromBlackboard(blackboard);
		final ModelProviding modelProviding = blackboard.getModelProviding();
		
		/*
		 * TODO: change to create candidates (EObject, PotentialTransition(new,
		 * still, remove), Mapping) in AbstractMIRChange2CommandTransforming.
		 */
		Collection<EObject> candidates = getCandidates(eChange);

		for (EObject candidate : candidates) {
			LOGGER.trace("Checking candidate " + candidate.toString());

			boolean mappedBefore = correspondenceInstance.checkIfMappedBy(candidate, this);
			boolean mappedAfter = checkConditions(candidate, blackboard);

			EObject mappingTarget = null;
			final Collection<EObject> affectedEObjects = new HashSet<EObject>();
			affectedEObjects.add(candidate);

			if (mappedBefore) {
				mappingTarget = Objects.requireNonNull(correspondenceInstance.getMappingTarget(candidate, this));

				if (!mappedAfter) {
					deleteCorresponding(candidate, mappingTarget, blackboard);
				}
			}

			if (!mappedBefore && mappedAfter) {
				affectedEObjects.addAll(createCorresponding(candidate, blackboard));
				mappingTarget = Objects.requireNonNull(correspondenceInstance.getMappingTarget(candidate, this));
			}

			if (mappedAfter) {
				restorePostConditions(candidate, mappingTarget, eChange, blackboard);
			}

			handleNonContainedEObjects(affectedEObjects, blackboard);

			// FIXME DW do not save everything again, should be done in ChangeSynchronizingImpl
			final Iterator<Resource> resources = affectedEObjects.stream().map(it -> it.eResource()).distinct()
					.iterator();
			while (resources.hasNext()) {
				modelProviding.saveExistingModelInstanceOriginal(VURI.getInstance(resources.next()));
			}
		}
		
		throw new UnsupportedOperationException("implement return of TransformationResult");
	}

	/**
	 * Asks the user and creates new resources for EObjects in
	 * <code>affectedEObjects</code> that do not have a container.
	 * @param blackboard TODO
	 */
	private void handleNonContainedEObjects(Collection<EObject> affectedEObjects, Blackboard blackboard) {
		final ModelProviding modelProviding = blackboard.getModelProviding();
		for (final EObject eObject : affectedEObjects) {
			if (eObject.eResource() == null) {
				VURI resourceVURI = VURI.getInstance(EclipseHelper.askForNewResource(eObject));
				final TUID tuid = blackboard.getCorrespondenceInstance().calculateTUIDFromEObject(eObject);
				modelProviding.saveModelInstanceOriginalWithEObjectAsOnlyContent(resourceVURI, eObject, tuid);
			}
		}
	}
}
