package com.epam.jwd.action.factory;

import com.epam.jwd.action.enums.CubeAction;
import com.epam.jwd.action.interfaces.CubeGeometryAction;
import com.epam.jwd.exception.UnknownActionException;

public interface GeometryActionFactory {
    CubeGeometryAction createAction(CubeAction action) throws UnknownActionException;

    static GeometryActionFactory newInstance(){
        return new CubeActionFactory();
    }
}
