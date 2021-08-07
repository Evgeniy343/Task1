package action.classes;

import action.params.CubeParams;
import action.interfaces.CubeGeometryAction;
import entity.CubeEntity;
import entity.Point3DEntity;
import exception.IntersectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeVolumeRatioAction implements CubeGeometryAction {

    private static final Logger LOG = LogManager.getLogger(CubeVolumeRatioAction.class);
    private static final String INFO_COLOR = "\u001b[34m";
    private static final String WARN_COLOR = "\u001b[33m";
    private static final int FORTH_NODE_INDEX = 3;
    private static final int FIRST_NODE_INDEX = 0;
    private static final String DOES_NOT_INTERSECTION_MESSAGE = "The plane does not intersect the cube";
    private static final String CALCULATES_CUBE_VOLUME_RATIO_MESSAGE = "Calculates the volume ratio of cubes";
    private static final String FINISH_CALCULATING_VOLUME_RATIO_OF_CUBES_MESSAGE
            = "The operation to calculate the volume ratio of cubes is completed";

    @Override
    public Object execute(CubeParams params) {
        Double ratio = null;
        try {
            ratio = ratio(params.getCube(),params.getPointPLane());
        } catch (IntersectionException e) {
            System.out.print(WARN_COLOR);
            LOG.warn(e.getMessage());
            System.out.print(INFO_COLOR);
        }
        LOG.info(FINISH_CALCULATING_VOLUME_RATIO_OF_CUBES_MESSAGE);
        return ratio;
    }

    private double ratio(CubeEntity cube, Point3DEntity pointPlane) throws IntersectionException {
        LOG.info(CALCULATES_CUBE_VOLUME_RATIO_MESSAGE);
        if(pointPlane.getX() == 0 && pointPlane.getY() == 0){
            if(cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getZ() > pointPlane.getZ()
                    || cube.getNodesOfUpperBase().get(FORTH_NODE_INDEX).getZ() < pointPlane.getZ()){
                throw new IntersectionException(DOES_NOT_INTERSECTION_MESSAGE);
            }
            return (cube.getNodesOfUpperBase().get(FORTH_NODE_INDEX).getZ() - pointPlane.getZ())/ pointPlane.getZ();
        }
        if(pointPlane.getY() == 0 && pointPlane.getZ() == 0){
            if(cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getX() > pointPlane.getX()
                    || cube.getNodesOfLowerBase().get(FORTH_NODE_INDEX).getX() < pointPlane.getX()){
                throw new IntersectionException(DOES_NOT_INTERSECTION_MESSAGE);
            }
            return (cube.getNodesOfUpperBase().get(FORTH_NODE_INDEX).getX() - pointPlane.getX())/ pointPlane.getX();
        }
        if(cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getX() > pointPlane.getX()
                || cube.getNodesOfLowerBase().get(FORTH_NODE_INDEX).getX() < pointPlane.getX()){
            throw new IntersectionException(DOES_NOT_INTERSECTION_MESSAGE);
        }
        return (cube.getNodesOfUpperBase().get(FORTH_NODE_INDEX).getY() - pointPlane.getY())/ pointPlane.getY();
    }
}
