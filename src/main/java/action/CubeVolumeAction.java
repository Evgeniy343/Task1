package action;

import entity.CubeEntity;

public class CubeVolumeAction {

    public static final int DEGREE = 3;

    public static double calculateVolume(CubeEntity cube) {
        return Math.pow(cube.getEdgeLength(), DEGREE);
    }
}
