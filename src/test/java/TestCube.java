import action.params.CubeParams;
import action.enums.CubeAction;
import action.factory.GeometryActionFactory;
import entity.CubeEntity;
import entity.Point3DEntity;
import exception.UnknownActionException;
import filework.ReaderFileWork;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TestCube {

    private final static String PATH = "D:\\epam\\projects\\Task1\\data\\File_1.txt";
    private final static GeometryActionFactory factory = GeometryActionFactory.newInstance();
    private final List<CubeEntity> cubes;
    private final static double[] volumes = new double[]{27.0,125.0,27.653197824};
    private final static double[] areas = new double[]{54.0,150.0,54.867456000000004};
    private final static Double[] volumeRatios = new Double[]{null,0.25,null};
    private final static boolean[] object = new boolean[]{true,true,true};
    private final static boolean[] baseOnPlane = new boolean[]{true,true,false};
    private final static Point3DEntity pointPLane = Point3DEntity.of(0.0,0.0,4.0);


    public TestCube() throws Exception {
        ReaderFileWork readerFileWork = new ReaderFileWork();
        cubes = readerFileWork.readingFromFile(PATH);
    }

    @Test
    public void testCubeArea() throws UnknownActionException {
        for (int i = 0; i < areas.length; i++) {
            CubeParams params = CubeParams.of(cubes.get(i),null);
            Assert.assertEquals(areas[i],factory.createAction(CubeAction.CUBE_AREA).execute(params));
        }
    }

    @Test
    public void testCubeVolume() throws UnknownActionException {
        for (int i = 0; i < volumes.length; i++) {
            CubeParams params = CubeParams.of(cubes.get(i),null);
            Assert.assertEquals(volumes[i],factory.createAction(CubeAction.CUBE_VOLUME).execute(params));
        }
    }

    @Test
    public void testCubeObject() throws UnknownActionException {
        for (int i = 0; i < object.length; i++) {
            CubeParams params = CubeParams.of(cubes.get(i),null);
            Assert.assertEquals(object[i],factory.createAction(CubeAction.CUBE_OBJECT).execute(params));
        }
    }

    @Test
    public void testCubeVolumeRatio() throws UnknownActionException {
        for (int i = 0; i < volumeRatios.length; i++) {
            CubeParams params = CubeParams.of(cubes.get(i),pointPLane);
            Assert.assertEquals(volumeRatios[i],factory.createAction(CubeAction.CUBE_VOLUME_RATIO).execute(params));
        }
    }

    @Test
    public void testCubeBaseOnPlane() throws UnknownActionException {
        for (int i = 0; i < baseOnPlane.length; i++) {
            CubeParams params = CubeParams.of(cubes.get(i),null);
            Assert.assertEquals(baseOnPlane[i],factory.createAction(CubeAction.CUBE_BASE_ON_PLANE).execute(params));
        }
    }


}
