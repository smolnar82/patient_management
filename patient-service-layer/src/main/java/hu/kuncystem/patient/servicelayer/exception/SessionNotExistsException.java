package hu.kuncystem.patient.servicelayer.exception;

/**
 * As this class is a runtime exception, there is no need for user code to catch
 * it or subclasses if any error is to be considered fatal. We can use this
 * exception if the session is not created.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 7.
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SessionNotExistsException extends RuntimeException {
    /**
     * Constructor for SessionNotExistsException.
     */
    public SessionNotExistsException() {
        super("The session is not created, yet! First, you have to run the create method!");
    }
}
