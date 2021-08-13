package com.epam.jwd.action;

import com.epam.jwd.action.context.GeometryContext;
import com.epam.jwd.entity.CubeEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeAreaAction implements CubeGeometryAction {

    private static final Logger LOG = LogManager.getLogger(CubeAreaAction.class);
    private static final int DEGREE = 2;
    private static final int NUMBER_OF_CUBE_SURFACES = 6;
    private static final String CALCULATES_CUBE_AREA_MESSAGE = "Calculates the area of the cube";
    private static final String FINISH_CALCULATING_AREA_OF_CUBE_MESSAGE
            = "The operation to calculate the area of the cube is completed";
    private static final String RESULT_MESSAGE = "Cube Area - ";

    @Override
    public Object execute(GeometryContext context) {
        double area = calculate(context.getCube());
        LOG.info(RESULT_MESSAGE + area);
        LOG.info(FINISH_CALCULATING_AREA_OF_CUBE_MESSAGE);
        return area;
    }

    private double calculate(CubeEntity cube) {
        LOG.info(CALCULATES_CUBE_AREA_MESSAGE);
        return Math.pow(cube.getEdgeLength(), DEGREE) * NUMBER_OF_CUBE_SURFACES;
    }

}
