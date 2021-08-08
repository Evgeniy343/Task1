package com.epam.jwd.filework;
import com.epam.jwd.entity.CubeEntity;
import com.epam.jwd.entity.Point3DEntity;
import com.epam.jwd.exception.DigitalException;
import com.epam.jwd.exception.NegativeValueException;
import com.epam.jwd.exception.NotEnoughArgumentsException;
import com.epam.jwd.validation.CubeInitialDataValidation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class ReaderFileWork implements ReaderWork {

    private static final Logger LOG = LogManager.getLogger(ReaderFileWork.class);
    private static final String SPACE = " ";
    private static final int INDEX_COORDINATE_X = 0;
    private static final int INDEX_COORDINATE_Y = 1;
    private static final int INDEX_COORDINATE_Z = 2;
    public static final String UPPER_BASE = "UpperBase";
    public static final String LOWER_BASE = "LowerBase";
    public static final int NUMBER_OF_NODES = 4;
    public static final String READING_FROM_FILE_MESSAGE = "Reading from file";
    public static final String CUBE_NOT_CREATED_MESSAGE = "Cube not created";
    public static final String START_DATA_VALIDATION_MESSAGE = "Start data com.epam.jwd.validation";
    public static final String DATA_VALIDATION_COMPLETED_MESSAGE = "Data com.epam.jwd.validation completed";
    public static final String CUBE = "Cube";

    ReaderFileWork() {
    }

    @Override
    public List<CubeEntity> execute(String path) throws Exception {
        return readingFromFile(path);
    }

    public List<CubeEntity> readingFromFile(String path) throws Exception {
        List<CubeEntity> cubes = new ArrayList<>();
        List<Point3DEntity> upperBase = new ArrayList<>();
        List<Point3DEntity> lowerBase = new ArrayList<>();
        String line;
        File file = new File(path);
        try (CustomResourceFileWork resourceWork = CustomResourceFileWork.of(file)) {
            LOG.info(READING_FROM_FILE_MESSAGE);
            line = resourceWork.getBufferedReader().readLine();
            while (line != null) {
                upperBase.clear();
                lowerBase.clear();
                if (resourceWork.getBufferedReader().readLine().equals(UPPER_BASE)) {
                    while (!(line = resourceWork.getBufferedReader().readLine()).equals(LOWER_BASE)) {
                        fillBase(upperBase, line);
                    }
                }
                while ((line = resourceWork.getBufferedReader().readLine()) != null) {
                    if(line.equals(CUBE)){
                        break;
                    }
                    fillBase(lowerBase, line);
                }
                if(upperBase.size() == NUMBER_OF_NODES && lowerBase.size() == NUMBER_OF_NODES) {
                    cubes.add(CubeEntity.of(upperBase, lowerBase));
                }else {
                    LOG.info(CUBE_NOT_CREATED_MESSAGE);
                }
            }
        }
        return cubes;
    }

    private Point3DEntity Point(String[] coordinates){
        return Point3DEntity.of(Double.parseDouble(coordinates[INDEX_COORDINATE_X])
                ,Double.parseDouble(coordinates[INDEX_COORDINATE_Y])
                ,Double.parseDouble(coordinates[INDEX_COORDINATE_Z]));
    }

    private boolean isCorrectData(String[] coordinates) throws Exception {
        try {
            LOG.info(START_DATA_VALIDATION_MESSAGE);
            CubeInitialDataValidation.checkFileData(coordinates);
        }
        catch (DigitalException ex){
            LOG.error(ex.getMessage());
            return false;
        }
        catch(NegativeValueException ex){
            LOG.error(ex.getMessage() + "");
            return false;
        }
        catch(NotEnoughArgumentsException ex){
            LOG.error(ex.getMessage() + " ");
            return false;
        }
        LOG.info(DATA_VALIDATION_COMPLETED_MESSAGE);
        return true;
    }

    private void fillBase(List<Point3DEntity> base, String line) throws Exception {
        String[] coordinates = line.split(SPACE);
        if(isCorrectData(coordinates)){
            base.add(Point(coordinates));
        }
    }
}
