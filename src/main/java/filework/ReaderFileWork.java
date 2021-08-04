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


public class ReaderFileWork {

    private static final Logger LOG = LogManager.getLogger(ReaderFileWork.class);

    private static final String SPACE = " ";
    private static final int INDEX_COORDINATE_X = 0;
    private static final int INDEX_COORDINATE_Y = 1;
    private static final int INDEX_COORDINATE_Z = 2;
    public static final String UPPER_BASE = "UpperBase";
    public static final String LOWER_BASE = "LowerBase";

    public CubeEntity readingFromFile(String path) throws Exception{
        List<Point3DEntity> upperBase = new ArrayList<>();
        List<Point3DEntity> lowerBase = new ArrayList<>();

        File file = new File(path);

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        String line;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String[] coordinates;
            if(bufferedReader.readLine().equals(UPPER_BASE)){
                while (!(line = bufferedReader.readLine()).equals(LOWER_BASE)){
                    coordinates = line.split(SPACE);
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
                    upperBase.add(Point(coordinates));
                }
            }
            while ((line = bufferedReader.readLine()) != null){
                coordinates = line.split(SPACE);
                lowerBase.add(Point(coordinates));
            }
        } catch (IOException ignore){
        } finally {
            try {
                if (fileReader != null && bufferedReader != null) {
                    fileReader.close();
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return CubeEntity.of(upperBase,lowerBase);
    }

    private Point3DEntity Point(String[] coordinates){
        return Point3DEntity.of(Double.parseDouble(coordinates[INDEX_COORDINATE_X])
                ,Double.parseDouble(coordinates[INDEX_COORDINATE_Y])
                ,Double.parseDouble(coordinates[INDEX_COORDINATE_Z]));
    }
}
