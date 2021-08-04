package action.classes;

import action.interfaces.CubeCalculateAction;
import entity.CubeEntity;

public class CubeVolumeAction implements CubeCalculateAction {

    public static final int DEGREE = 3;

    @Override
    public double execute(CubeEntity cube) {
        return Math.pow(cube.getEdgeLength(), DEGREE);
    }
}
