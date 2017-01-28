package be.doji.coding.exception;

import be.doji.coding.spring.SpringBeanFacade;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Doji on 28/01/2017.
 */
public final class ExceptionFactory {

    /**
     * Utility methods should not have a public or default constructor
     */
    private ExceptionFactory(){}

    public static <T extends Object, E extends Exception> E logAndThrowError(E exceptionToThrow, T callingClass, Level errorLevel)
            throws E {
        Logger LOG = Logger.getLogger(callingClass.getClass().getName());
        Throwable cause = exceptionToThrow.getCause();
        LOG.log(errorLevel, exceptionToThrow.getMessage() + (cause != null?" : " + cause.getMessage():""));
        throw exceptionToThrow;
    }
}
