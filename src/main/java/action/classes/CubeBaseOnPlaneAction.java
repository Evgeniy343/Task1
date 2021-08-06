package action.classes;

import action.CalculationParams;
import action.CalculationResults;
import action.interfaces.CubePoofAction;
import entity.CubeEntity;

public class CubeBaseOnPlaneAction implements CubePoofAction {

    public static final int FIRST_NODE_INDEX = 0;

    @Override
    public boolean prove(CubeEntity cube) {
        return (cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getX() == 0
                && cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getY() == 0)

                || (cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getX() == 0
                && cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getZ() == 0)

                || (cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getY() == 0
                && cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getZ() == 0);
    }

    @Override
    public CalculationResults execute(CalculationParams params) {
        return new CalculationResults(null,null,null,prove(params.getCube()),null);
    }
}
