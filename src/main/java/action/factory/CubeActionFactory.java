package action.factory;

import action.enums.CubeAction;
import action.classes.*;
import action.interfaces.CubeGeometryAction;
import exception.UnknownActionException;

public class CubeActionFactory {
    public CubeGeometryAction getCubeAction(CubeAction action) throws Exception {
        CubeGeometryAction cubeAction;
        switch (action){
            case CUBE_AREA:
                cubeAction = new CubeAreaAction();
                break;
            case CUBE_OBJECT:
                cubeAction = new CubeObjectAction();
                break;
            case CUBE_VOLUME:
                cubeAction = new CubeVolumeAction();
                break;
            case CUBE_VOLUME_RATIO:
                cubeAction = new CubeVolumeRatioAction();
                break;
            case CUBE_BASE_ON_PLANE:
                cubeAction = new CubeBaseOnPlaneAction();
                break;
            default:
                throw new UnknownActionException("This action was not found!");
        }
        return cubeAction;
    }
}
