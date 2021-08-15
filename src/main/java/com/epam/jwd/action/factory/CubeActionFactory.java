package com.epam.jwd.action.factory;

import com.epam.jwd.action.*;
import com.epam.jwd.exception.UnknownActionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeActionFactory implements GeometryActionFactory {
    private static CubeActionFactory factory;
    private static final Logger LOG = LogManager.getLogger(CubeActionFactory.class);
    private static final UnknownActionException ACTION_NOT_FOUND_MESSAGE
            = new UnknownActionException("This com.epam.jwd.action was not found!");
    private static final String CREATE_ACTION_MESSAGE = "Create geometry com.epam.jwd.action";

    CubeActionFactory(){
    }

    @Override
    public CubeGeometryAction createAction(CubeAction action) throws UnknownActionException {
        LOG.info(CREATE_ACTION_MESSAGE);
        CubeGeometryAction cubeAction;
        switch (action) {
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

    protected static CubeActionFactory getFactory(){
        if(factory == null){
            factory = new CubeActionFactory();
        }
        return factory;
    }
}
