package action.classes;

import action.interfaces.CubeCalculateAction;
import entity.CubeEntity;

public class CubeAreaAction implements CubeCalculateAction {

    public static final int DEGREE = 2;
    public static final int NUMBER_OF_CUBE_SURFACES = 6;

    @Override
    public double execute(CubeEntity cube) {
        return Math.pow(cube.getEdgeLength(),DEGREE) * NUMBER_OF_CUBE_SURFACES;
    }
}
