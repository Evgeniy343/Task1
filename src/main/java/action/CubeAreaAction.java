package action;

import entity.CubeEntity;

public class CubeAreaAction {


    public static final int DEGREE = 2;
    public static final int NUMBER_OF_SURFACES = 6;

    public static double calculateSurfaceArea(CubeEntity cube) {
        return Math.pow(cube.getEdgeLength(),DEGREE) * NUMBER_OF_SURFACES;
    }
}
