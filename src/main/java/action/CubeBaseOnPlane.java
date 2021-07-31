package action;

import entity.CubeEntity;

public class CubeBaseOnPlane {
    public static boolean isCubeBaseOnPlane(CubeEntity cube){
        return (cube.getNode().getX() == 0 && cube.getNode().getY() == 0)
                || (cube.getNode().getX() == 0 && cube.getNode().getZ() == 0)
                || (cube.getNode().getY() == 0 && cube.getNode().getZ() == 0);
    }
}
