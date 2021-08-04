package action.interfaces;

import entity.CubeEntity;

public interface CubePoofAction extends CubeGeometryAction {
    boolean check(CubeEntity cube);
}
