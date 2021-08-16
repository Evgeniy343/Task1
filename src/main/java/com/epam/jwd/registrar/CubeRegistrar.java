package com.epam.jwd.registrar;

import com.epam.jwd.action.context.GeometryContext;
import com.epam.jwd.action.factory.GeometryActionFactory;
import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.exception.UnknownActionException;
import com.epam.jwd.registrar.context.CubeContext;

import static com.epam.jwd.action.CubeAction.CUBE_AREA;
import static com.epam.jwd.action.CubeAction.CUBE_VOLUME;

public class CubeRegistrar implements GeometryRegistrar {

    private final static GeometryActionFactory factory = GeometryActionFactory.newInstance();
    private final CubeContext context;

    CubeRegistrar(int volume, Integer volumeRatio, int area){
        context = CubeContext.of(volume,volumeRatio,area);
    }

    public static CubeRegistrar of(int volume, Integer volumeRatio, int area){
        return new CubeRegistrar(volume,volumeRatio,area);
    }

    public CubeContext getContext() {
        return context;
    }

    @Override
    public void update(CubeEntity cube) {
        double volume = 0;
        double area = 0;
        try {
            area = (double)factory.createAction(CUBE_AREA).execute(GeometryContext.of(cube,null));
            volume = (double)factory.createAction(CUBE_VOLUME).execute(GeometryContext.of(cube,null));
        } catch (UnknownActionException e) {
            e.printStackTrace();
        }
        context.setArea(area);
        context.setVolume(volume);
    }
}
