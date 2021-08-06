package action.factory;

import action.enums.CubeAction;
import action.interfaces.CubeGeometryAction;
import exception.UnknownActionException;

public interface GeometryActionFactory {
    CubeGeometryAction createAction(CubeAction action) throws UnknownActionException;

    static GeometryActionFactory newInstance(){
        return new CubeActionFactory();
    }
}
