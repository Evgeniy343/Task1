package com.epam.jwd.exception;

public class NegativeValueException extends Exception {

    public NegativeValueException(String message, String symbol) {
        super(message + " " + symbol);
    }
}
