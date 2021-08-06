package action;

import entity.CubeEntity;
import entity.Point3DEntity;

public class CalculationParams {
    private final CubeEntity cube;
    private final Point3DEntity pointPLane;

    public CalculationParams(CubeEntity cube, Point3DEntity pointPlane){
        this.cube = cube;
        this.pointPLane = pointPlane;
    }

    public CubeEntity getCube() {
        return cube;
    }

    public Point3DEntity getPointPLane() {
        return pointPLane;
    }
}
