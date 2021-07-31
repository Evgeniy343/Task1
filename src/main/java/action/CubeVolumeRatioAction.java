package action;

import entity.CubeEntity;
import entity.Point3DEntity;

public class CubeVolumeRatioAction {

    public static double volumeRatio(CubeEntity cube, Point3DEntity pointPlane) {
        if(pointPlane.getX() == 0 && pointPlane.getY() == 0){
            return (cube.getEdgeLength() - pointPlane.getZ())/ pointPlane.getZ();
        }
        if(pointPlane.getY() == 0 && pointPlane.getZ() == 0){
            return (cube.getEdgeLength() - pointPlane.getX())/ pointPlane.getX();
        }
        return (cube.getEdgeLength() - pointPlane.getY())/ pointPlane.getY();
    }
}
