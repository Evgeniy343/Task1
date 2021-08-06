package action.interfaces;

import entity.CubeEntity;
import entity.Point3DEntity;

public interface CubeRatioAction extends CubeGeometryAction {
    double ratio(CubeEntity cube, Point3DEntity pointPlane);
}
