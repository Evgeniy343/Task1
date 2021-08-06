import action.CalculationParams;
import action.enums.CubeAction;
import action.factory.GeometryActionFactory;
import filework.ReaderFileWork;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static String PATH = "D:\\epam\\projects\\Task1\\data\\File_1.txt";
    private final static GeometryActionFactory factory = GeometryActionFactory.newInstance();
    private static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args) {
        ReaderFileWork reader = new ReaderFileWork();
        CalculationParams params;
        try {
            params = new CalculationParams(reader.readingFromFile(PATH),null);
            LOG.info(factory.createAction(CubeAction.CUBE_AREA).execute(params).getArea());
            LOG.error(factory.createAction(CubeAction.CUBE_VOLUME).execute(params).getVolume());
            LOG.error(factory.createAction(CubeAction.CUBE_BASE_ON_PLANE).execute(params).isBaseOnPlane());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
