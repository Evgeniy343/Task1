package com.epam.jwd.action.classes;

import com.epam.jwd.action.params.CubeParams;
import com.epam.jwd.action.interfaces.CubeGeometryAction;
import com.epam.jwd.entity.CubeEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeVolumeAction implements CubeGeometryAction {

    private static final Logger LOG = LogManager.getLogger(CubeVolumeAction.class);
    private static final String CALCULATES_CUBE_VOLUME_MESSAGE = "Calculates the volume of the cube";
    private static final int DEGREE = 3;
    private static final String FINISH_CALCULATING_VOLUME_OF_CUBE_MESSAGE
            = "The operation to calculate the volume of the cube is completed";
    public static final String RESULT_MESSAGE = "Cube volume - ";

    @Override
    public Object execute(CubeParams params) {
        double volume = calculate(params.getCube());
        LOG.info(RESULT_MESSAGE + volume);
        LOG.info(FINISH_CALCULATING_VOLUME_OF_CUBE_MESSAGE);
        return volume;
    }

    private double calculate(CubeEntity cube) {
        LOG.info(CALCULATES_CUBE_VOLUME_MESSAGE);
        return Math.pow(cube.getEdgeLength(), DEGREE);
    }
}
