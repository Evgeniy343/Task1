package filework;
import entity.CubeEntity;
import entity.Point3DEntity;
import exception.DigitalException;
import exception.NegativeValueException;
import exception.NotEnoughArgumentsException;
import validation.CubeInitialDataValidation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class ReaderFileWork implements ReaderWork{

    private static final Logger LOG = LogManager.getLogger(ReaderFileWork.class);

    private static final String SPACE = " ";
    private static final int INDEX_COORDINATE_X = 0;
    private static final int INDEX_COORDINATE_Y = 1;
    private static final int INDEX_COORDINATE_Z = 2;
    public static final String UPPER_BASE = "UpperBase";
    public static final String LOWER_BASE = "LowerBase";

    public CubeEntity readingFromFile(String path) throws Exception {
        List<Point3DEntity> upperBase = new ArrayList<>();
        List<Point3DEntity> lowerBase = new ArrayList<>();
        String line;
        File file = new File(path);
        try (CustomResourceWork resourceWork = new CustomResourceWork(file)){
            if(resourceWork.getBufferedReader().readLine().equals(UPPER_BASE)){
                while (!(line = resourceWork.getBufferedReader().readLine()).equals(LOWER_BASE)){
                    fillBase(upperBase, line);
                }
            }
            while ((line = resourceWork.getBufferedReader().readLine()) != null){
                fillBase(lowerBase,line);
            }
        }
        return CubeEntity.of(upperBase,lowerBase);
    }

    private Point3DEntity Point(String[] coordinates){
        return Point3DEntity.of(Double.parseDouble(coordinates[INDEX_COORDINATE_X])
                ,Double.parseDouble(coordinates[INDEX_COORDINATE_Y])
                ,Double.parseDouble(coordinates[INDEX_COORDINATE_Z]));
    }

    private void catchExceptions(String[] coordinates) throws Exception {
        try {
            CubeInitialDataValidation.checkFileData(coordinates);
        }
        catch (DigitalException ex){
            LOG.error(ex.getMessage());
        }
        catch(NegativeValueException ex){
            LOG.error(ex.getMessage() + "");
        }
        catch(NotEnoughArgumentsException ex){
            LOG.error(ex.getMessage() + " ");
        }
    }

    private void fillBase(List<Point3DEntity> base, String line) throws Exception {
        String[] coordinates = line.split(SPACE);
        catchExceptions(coordinates);
        base.add(Point(coordinates));
    }


}
