package action.params;

import entity.CubeEntity;
import entity.Point3DEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeParams {
    public static final String PARAMS_INITIALIZED_MESSAGE = "Parameters for working with actions on the cube are initialized";
    private final CubeEntity cube;
    private final Point3DEntity pointPLane;

    private static final Logger LOG = LogManager.getLogger(CubeParams.class);

    CubeParams(CubeEntity cube, Point3DEntity pointPlane){
        this.cube = cube;
        this.pointPLane = pointPlane;
    }

    public static CubeParams of(CubeEntity cube, Point3DEntity pointPlane){
        CubeParams params = new CubeParams(cube,pointPlane);
        LOG.info(PARAMS_INITIALIZED_MESSAGE);
        return params;
    }

    public CubeEntity getCube() {
        return cube;
    }

    public Point3DEntity getPointPLane() {
        return pointPLane;
    }
}
