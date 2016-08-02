package edu.kit.ipd.sdq.vitruvius.framework.design.metamodelmanager;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Metamodel;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.MetamodelManaging;

// TODO MK is this class really necessary or is MetaRepositoryImpl enough?
public class MetamodelManagerImpl implements MetamodelManaging {

    private final MetamodelManaging metamodelManaging;

    public MetamodelManagerImpl(final MetamodelManaging metamodelManaging) {
        this.metamodelManaging = metamodelManaging;
    }

    @Override
    public void addMetamodel(final Metamodel metamodel) {
        this.metamodelManaging.addMetamodel(metamodel);
    }

    @Override
    public Metamodel getMetamodel(final VURI uri) {
        return this.metamodelManaging.getMetamodel(uri);
    }

    @Override
    public Metamodel getMetamodel(final String fileExtension) {
        return this.metamodelManaging.getMetamodel(fileExtension);
    }

    @Override
    public Metamodel[] getAllMetamodels() {
        return this.metamodelManaging.getAllMetamodels();
    }

}