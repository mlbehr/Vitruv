package tools.vitruv.applications.asemsysml.reactions.sysml2asem.util;

import tools.vitruv.applications.asemsysml.ASEMSysMLHelper;
import tools.vitruv.domains.asem.AsemNamespace;

/**
 * A helper class containing methods which are useful for the transformation using reactions.
 * 
 * @author Benjamin Rupp
 */
public class ASEMSysMLReactionHelper {

    /**
     * Get the project model path for the ASEM model which corresponds to a SysML Block.
     * 
     * @param blockName
     *            Name of the corresponding SysML block.
     * @return Project model path of the ASEM model.
     */
    public static String getASEMProjectModelPath(final String blockName) {

        String modelName = ASEMSysMLHelper.getASEMModelName(blockName);
        String projectModelPath = ASEMSysMLHelper.getProjectModelPath(modelName, AsemNamespace.FILE_EXTENSION);

        return projectModelPath;

    }

}