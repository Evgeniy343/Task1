package com.epam.jwd;

import com.epam.jwd.action.params.CubeParams;
import com.epam.jwd.action.enums.CubeAction;
import com.epam.jwd.action.factory.GeometryActionFactory;
import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.entity.Point3DEntity;
import com.epam.jwd.exception.UnknownActionException;
import com.epam.jwd.filework.ReaderWork;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.jwd.results.TestResults;
import java.util.List;

public class TestCube {

    private final static String PATH = "D:\\epam\\projects\\Task1\\data\\TestCubes.txt";
    private final static GeometryActionFactory factory = GeometryActionFactory.newInstance();
    private final static Double[] CUBE_AREAS = new Double[]{54.0, 150.0, 54.867456000000004
            , 148.02653399999997, 624.7296960000001};
    private final static Double[] CUBE_VOLUMES = new Double[]{27.0, 125.0, 27.653197824
            , 122.54129906299997, 1062.456969664};
    private final static Double[] CUBE_VOLUME_RATIOS = new Double[]{0.25, 0.9867999999999999, 0.7140000000000001};
    private final static Double[] POINT_COORDINATE_X = new Double[]{0.0, 0.0, 4.0, 0.0, 0.0};
    private final static Double[] POINT_COORDINATE_Y = new Double[]{0.0, 4.0, 0.0, 0.0, 12.0};
    private final static Double[] POINT_COORDINATE_Z = new Double[]{4.0, 0.0, 0.0, 2.5, 0.0};
    public static final String DATA_PROVIDER = "data-provider";
    private final List<CubeEntity> cubes;


    public TestCube() throws Exception {
        ReaderWork readerFileWork = ReaderWork.newInstance();
        cubes = readerFileWork.execute(PATH);
    }

    @DataProvider(name = DATA_PROVIDER)
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {CubeParams.of(cubes.get(0), Point3DEntity.of(POINT_COORDINATE_X[0],
                        POINT_COORDINATE_Y[0], POINT_COORDINATE_Z[0])),
                        TestResults.of(new Double[]{CUBE_AREAS[0], CUBE_VOLUMES[0], null}
                        ,true, true)
                },
                {CubeParams.of(cubes.get(1), Point3DEntity.of(POINT_COORDINATE_X[1],
                        POINT_COORDINATE_Y[1], POINT_COORDINATE_Z[1])),
                        TestResults.of(new Double[]{CUBE_AREAS[1], CUBE_VOLUMES[1], CUBE_VOLUME_RATIOS[0]}
                                ,true, true)
                },
                {CubeParams.of(cubes.get(2), Point3DEntity.of(POINT_COORDINATE_X[2],
                        POINT_COORDINATE_Y[2], POINT_COORDINATE_Z[2])),
                        TestResults.of(new Double[]{CUBE_AREAS[2], CUBE_VOLUMES[2], null}
                        , false, true)
                },
                {
                        CubeParams.of(cubes.get(3), Point3DEntity.of(POINT_COORDINATE_X[3],
                                POINT_COORDINATE_Y[3], POINT_COORDINATE_Z[3])),
                        TestResults.of(new Double[]{CUBE_AREAS[3], CUBE_VOLUMES[3], CUBE_VOLUME_RATIOS[1]}
                                , true, true)
                },
                {
                        CubeParams.of(cubes.get(4), Point3DEntity.of(POINT_COORDINATE_X[4],
                                POINT_COORDINATE_Y[4], POINT_COORDINATE_Z[4])),
                        TestResults.of(new Double[]{CUBE_AREAS[4], CUBE_VOLUMES[4], CUBE_VOLUME_RATIOS[2]}
                                , false, true)
                }
        };
    }


    @Test(dataProvider = DATA_PROVIDER)
    public void testCubeArea(CubeParams params, TestResults results) throws UnknownActionException {
        Assert.assertEquals(results.getCalculations()[0], factory.createAction(CubeAction.CUBE_AREA).execute(params));
    }

    @Test(dataProvider = DATA_PROVIDER)
    public void testCubeVolume(CubeParams params, TestResults results) throws UnknownActionException {
        Assert.assertEquals(results.getCalculations()[1], factory.createAction(CubeAction.CUBE_VOLUME).execute(params));
    }

    @Test(dataProvider = DATA_PROVIDER)
    public void testCubeObject(CubeParams params, TestResults results) throws UnknownActionException {
        Assert.assertEquals(results.isCube(), factory.createAction(CubeAction.CUBE_OBJECT).execute(params));
    }

    @Test(dataProvider = DATA_PROVIDER)
    public void testCubeVolumeRatio(CubeParams params, TestResults results) throws UnknownActionException {
        Assert.assertEquals(results.getCalculations()[2]
                , factory.createAction(CubeAction.CUBE_VOLUME_RATIO).execute(params));
    }

    @Test(dataProvider = DATA_PROVIDER)
    public void testCubeBaseOnPlane(CubeParams params, TestResults results) throws UnknownActionException {
        Assert.assertEquals(results.isBaseOnPlane()
                , factory.createAction(CubeAction.CUBE_BASE_ON_PLANE).execute(params));
    }


}
