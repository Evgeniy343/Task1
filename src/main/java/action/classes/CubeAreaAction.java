package action.classes;

import action.params.CubeParams;
import action.interfaces.CubeGeometryAction;
import entity.CubeEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeAreaAction implements CubeGeometryAction {

    private static final Logger LOG = LogManager.getLogger(CubeAreaAction.class);
    private static final int DEGREE = 2;
    private static final int NUMBER_OF_CUBE_SURFACES = 6;
    private static final String CALCULATES_CUBE_AREA_MESSAGE = "Calculates the area of the cube";
    private static final String FINISH_CALCULATING_AREA_OF_CUBE_MESSAGE
            = "The operation to calculate the area of the cube is completed";

    @Override
    public Object execute(CubeParams params) {
        double area = calculate(params.getCube());
        LOG.info(FINISH_CALCULATING_AREA_OF_CUBE_MESSAGE);
        return area;
    }

    private double calculate(CubeEntity cube) {
        LOG.info(CALCULATES_CUBE_AREA_MESSAGE);
        return Math.pow(cube.getEdgeLength(),DEGREE) * NUMBER_OF_CUBE_SURFACES;
    }

}
