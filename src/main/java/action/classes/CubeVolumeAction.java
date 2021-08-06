package action.classes;

import action.CalculationParams;
import action.CalculationResults;
import action.interfaces.CubeCalculateAction;
import entity.CubeEntity;

public class CubeVolumeAction implements CubeCalculateAction {

    public static final int DEGREE = 3;

    @Override
    public double calculate(CubeEntity cube) {
        return Math.pow(cube.getEdgeLength(), DEGREE);
    }

    @Override
    public CalculationResults execute(CalculationParams params) {
        return new CalculationResults(null,null,calculate(params.getCube())
                ,null,null);
    }
}
