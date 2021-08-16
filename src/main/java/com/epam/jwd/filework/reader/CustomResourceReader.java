package com.epam.jwd.filework.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CustomResourceReader implements AutoCloseable {

    private static final Logger LOG = LogManager.getLogger(CustomResourceReader.class);
    public static final String FILE_READING_COMPLETED_MESSAGE = "File reading completed";
    private final FileReader fileReader;
    private final BufferedReader bufferedReader;

    CustomResourceReader(File file) throws FileNotFoundException {
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
    }

    public static CustomResourceReader of(File file) throws FileNotFoundException {
        return new CustomResourceReader(file);
    }


    @Override
    public void close() throws Exception {
        fileReader.close();
        bufferedReader.close();
        LOG.info(FILE_READING_COMPLETED_MESSAGE);
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}
