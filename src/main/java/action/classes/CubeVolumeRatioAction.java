package action.classes;

import action.CalculationParams;
import action.CalculationResults;
import action.interfaces.CubeRatioAction;
import entity.CubeEntity;
import entity.Point3DEntity;

public class CubeVolumeRatioAction implements CubeRatioAction {

    public static final int FORTH_NODE_INDEX = 3;

    @Override
    public double ratio(CubeEntity cube, Point3DEntity pointPlane) {
        if(pointPlane.getX() == 0 && pointPlane.getY() == 0){
            return (cube.getNodesOfLowerBase().get(FORTH_NODE_INDEX).getZ() - pointPlane.getZ())/ pointPlane.getZ();
        }
        if(pointPlane.getY() == 0 && pointPlane.getZ() == 0){
            return (cube.getNodesOfLowerBase().get(FORTH_NODE_INDEX).getX() - pointPlane.getX())/ pointPlane.getX();
        }
        return (cube.getNodesOfLowerBase().get(FORTH_NODE_INDEX).getY() - pointPlane.getY())/ pointPlane.getY();
    }

    @Override
    public CalculationResults execute(CalculationParams params) {
        return new CalculationResults(ratio(params.getCube(),params.getPointPLane())
                ,null,null,null,null);
    }
}
