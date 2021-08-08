package com.epam.jwd.exception;

public class DigitalException extends Exception {

    public DigitalException(String message, String symbol) {
        super(message + " " + symbol);
    }
}
