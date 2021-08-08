package com.epam.jwd.action.classes;

import com.epam.jwd.action.params.CubeParams;
import com.epam.jwd.action.interfaces.CubeGeometryAction;
import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.entity.Point3DEntity;
import com.epam.jwd.exception.IntersectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeVolumeRatioAction implements CubeGeometryAction {

    private static final Logger LOG = LogManager.getLogger(CubeVolumeRatioAction.class);
    private static final int THIRD_NODE_INDEX = 2;
    private static final int FIRST_NODE_INDEX = 0;
    private static final String DOES_NOT_INTERSECTION_MESSAGE = "The plane does not intersect the cube";
    private static final String CALCULATES_CUBE_VOLUME_RATIO_MESSAGE = "Calculates the volume ratio of cubes";
    private static final String FINISH_CALCULATING_VOLUME_RATIO_OF_CUBES_MESSAGE
            = "The operation to calculate the volume ratio of cubes is completed";
    public static final String RESULT_MESSAGE = "Volume ratio of cubes - ";

    @Override
    public Object execute(CubeParams params) {
        Double ratio = null;
        try {
            ratio = ratio(params.getCube(),params.getPointPLane());
        } catch (IntersectionException e) {
            LOG.warn(e.getMessage());
        }
        LOG.info(RESULT_MESSAGE + ratio);
        LOG.info(FINISH_CALCULATING_VOLUME_RATIO_OF_CUBES_MESSAGE);
        return ratio;
    }

    private double ratio(CubeEntity cube, Point3DEntity pointPlane) throws IntersectionException {
        LOG.info(CALCULATES_CUBE_VOLUME_RATIO_MESSAGE);
        if(pointPlane.getX() == 0 && pointPlane.getY() == 0){
            if(cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getZ() > pointPlane.getZ()
                    || cube.getNodesOfUpperBase().get(THIRD_NODE_INDEX).getZ() < pointPlane.getZ()){
                throw new IntersectionException(DOES_NOT_INTERSECTION_MESSAGE);
            }
            return (cube.getNodesOfUpperBase().get(THIRD_NODE_INDEX).getZ() - pointPlane.getZ())/ pointPlane.getZ();
        }
        if(pointPlane.getY() == 0 && pointPlane.getZ() == 0){
            if(cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getX() > pointPlane.getX()
                    || cube.getNodesOfUpperBase().get(THIRD_NODE_INDEX).getX() < pointPlane.getX()){
                throw new IntersectionException(DOES_NOT_INTERSECTION_MESSAGE);
            }
            return (cube.getNodesOfUpperBase().get(THIRD_NODE_INDEX).getX() - pointPlane.getX())/ pointPlane.getX();
        }
        if(cube.getNodesOfLowerBase().get(FIRST_NODE_INDEX).getY() > pointPlane.getY()
                || cube.getNodesOfUpperBase().get(THIRD_NODE_INDEX).getY() < pointPlane.getY()){
            throw new IntersectionException(DOES_NOT_INTERSECTION_MESSAGE);
        }
        return (cube.getNodesOfUpperBase().get(THIRD_NODE_INDEX).getY() - pointPlane.getY())/ pointPlane.getY();
    }
}
