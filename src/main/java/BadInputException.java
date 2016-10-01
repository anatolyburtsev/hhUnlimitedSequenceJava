/**
 * Created by onotole on 9/26/16.
 */
public class BadInputException extends Exception {

    public BadInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadInputException(String message) {
        super(message);
    }
}
