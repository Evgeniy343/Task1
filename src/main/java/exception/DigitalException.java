package exception;

public class DigitalException extends Exception {

    public DigitalException(String message, char symbol) {
        super(message + " " + symbol);
    }
}
