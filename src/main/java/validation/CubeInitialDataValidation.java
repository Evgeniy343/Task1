package validation;

import exception.DigitalException;
import exception.NegativeValueException;
import exception.NotEnoughArgumentsException;

import java.nio.charset.StandardCharsets;

public class CubeInitialDataValidation {

    public static final NotEnoughArgumentsException MESSAGE_ABOUT_ARGUMENTS
            = new NotEnoughArgumentsException("Not enough arguments!");
    public static final String MESSAGE_ABOUT_CHARACTER = "Invalid character - ";
    public static final String MESSAGE_ABOUT_NEGATIVE = "Negative coordinate - ";
    public static final int MAX_COUNT_OF_POINT_COORDINATES = 3;
    public static final int ASCII_CODE_OF_NUMBER_0 = 48;
    public static final int ASCII_CODE_OF_NUMBER_9 = 57;
    public static final int ASCII_CODE_OF_SIGN_DOT = 46;
    public static final int ASCII_CODE_OF_SIGN_DASH = 45;


    public static void checkFileData(String[] coordinates) throws Exception {
        for (String coordinate : coordinates) {
            for (int i = 0; i < coordinate.length(); i++) {
                if(coordinates.length != MAX_COUNT_OF_POINT_COORDINATES){
                    throw MESSAGE_ABOUT_ARGUMENTS;
                }
                if(!isDigit(coordinate,i)){
                    throw new DigitalException(MESSAGE_ABOUT_CHARACTER,coordinate);
                }
                if(isNegative(coordinate,i)){
                    throw new NegativeValueException(MESSAGE_ABOUT_NEGATIVE,coordinate);
                }
            }
        }
    }

    private static boolean isDigit(String coordinate, int i) {
        byte[] bytes = coordinate.getBytes(StandardCharsets.US_ASCII);
        return (bytes[i] >= ASCII_CODE_OF_NUMBER_0 && bytes[i] <= ASCII_CODE_OF_NUMBER_9)
                || bytes[i] == ASCII_CODE_OF_SIGN_DOT || bytes[i] == ASCII_CODE_OF_SIGN_DASH;
    }

    private static boolean isNegative(String coordinate, int i){
        byte[] bytes = coordinate.getBytes(StandardCharsets.US_ASCII);
        return bytes[i] == ASCII_CODE_OF_SIGN_DASH;
    }
}
