package action.classes;

import action.params.CubeParams;
import action.interfaces.CubeGeometryAction;
import entity.CubeEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeVolumeAction implements CubeGeometryAction {

    private static final Logger LOG = LogManager.getLogger(CubeVolumeAction.class);
    private static final String CALCULATES_CUBE_VOLUME_MESSAGE = "Calculates the volume of the cube";
    private static final int DEGREE = 3;
    private static final String FINISH_CALCULATING_VOLUME_OF_CUBE_MESSAGE
            = "The operation to calculate the volume of the cube is completed";

    @Override
    public Object execute(CubeParams params) {
        double volume = calculate(params.getCube());
        LOG.info(FINISH_CALCULATING_VOLUME_OF_CUBE_MESSAGE);
        return volume;
    }

    private double calculate(CubeEntity cube) {
        LOG.info(CALCULATES_CUBE_VOLUME_MESSAGE);
        return Math.pow(cube.getEdgeLength(), DEGREE);
    }
}
