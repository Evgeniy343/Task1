package com.epam.jwd.action.factory;

import com.epam.jwd.action.CubeAction;
import com.epam.jwd.action.CubeGeometryAction;
import com.epam.jwd.exception.UnknownActionException;

public interface GeometryActionFactory {
    CubeGeometryAction createAction(CubeAction action) throws UnknownActionException;

    static GeometryActionFactory newInstance() {
        return CubeActionFactory.getFactory();
    }
}
