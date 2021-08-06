package action.interfaces;

import entity.CubeEntity;

public interface CubeCalculateAction extends CubeGeometryAction {
    double calculate(CubeEntity cube);
}
