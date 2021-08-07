package action.factory;

import action.enums.CubeAction;
import action.classes.*;
import action.interfaces.CubeGeometryAction;
import exception.UnknownActionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeActionFactory implements GeometryActionFactory{

    private static final Logger LOG = LogManager.getLogger(CubeActionFactory.class);
    public static final UnknownActionException ACTION_NOT_FOUND_MESSAGE
            = new UnknownActionException("This action was not found!");
    public static final String CREATE_ACTION_MESSAGE = "Create geometry action";

    CubeActionFactory() {
    }

    public CubeGeometryAction createAction(CubeAction action) throws UnknownActionException {
        LOG.info(CREATE_ACTION_MESSAGE);
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
                throw ACTION_NOT_FOUND_MESSAGE;
        }
        return cubeAction;
    }
}
