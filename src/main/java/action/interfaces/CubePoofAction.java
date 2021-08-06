package action.interfaces;

import entity.CubeEntity;

public interface CubePoofAction extends CubeGeometryAction {
    boolean prove(CubeEntity cube);
}
