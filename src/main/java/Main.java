import action.enums.CubeAction;
import action.factory.CubeActionFactory;
import filework.ReaderFileWork;

public class Main {
    private final static String PATH = "D:\\epam\\projects\\Task1\\data\\File_1.txt";
    public static void main(String[] args) throws Exception {
        ReaderFileWork reader = new ReaderFileWork();
        reader.readingFromFile(PATH);
        CubeActionFactory factory = new CubeActionFactory();
        factory.getCubeAction(CubeAction.CUBE_AREA);
    }
}
