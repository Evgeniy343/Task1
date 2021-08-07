package action.classes;

import action.params.CubeParams;
import action.interfaces.CubeGeometryAction;
import entity.CubeEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeBaseOnPlaneAction implements CubeGeometryAction {

    private static final Logger LOG = LogManager.getLogger(CubeBaseOnPlaneAction.class);
    private static final int FIRST_NODE_INDEX = 0;
    private static final String CHECKING_CUBE_BASE_ON_PLANE_MESSAGE
            = "Checking whether its base belongs to the coordinate plane";
    private static final String FINISH_CHECKING_BASE_ON_PLANE_MESSAGE
            = "The operation to check the base of cube on plane is completed";

    @Override
    public Object execute(CubeParams params) {
        boolean isBaseOnPlane = prove(params.getCube());
        LOG.info(FINISH_CHECKING_BASE_ON_PLANE_MESSAGE);
        return isBaseOnPlane;
    }

    private boolean prove(CubeEntity cube) {
        LOG.info(CHECKING_CUBE_BASE_ON_PLANE_MESSAGE);
        return (cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getX() == 0
                && cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getY() == 0)

                || (cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getX() == 0
                && cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getZ() == 0)

                || (cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getY() == 0
                && cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getZ() == 0);
    }
}
