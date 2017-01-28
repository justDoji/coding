package be.doji.coding.exception;

/**
 * Created by Doji on 28/01/2017.
 */
public class BeanNotFoundException extends Exception {

    public BeanNotFoundException(String message) {
        super(message);
    }

    public BeanNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
