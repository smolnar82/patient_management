package hu.kuncystem.patient.servicelayer.exception;

/**
 * As this class is a runtime exception, there is no need for user code to catch
 * it or subclasses if any error is to be considered fatal. We can use this
 * exception if the operations of database were unsuccessful.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 7.
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SessionDataChangeException extends RuntimeException {
    private final static String STRING_CHANGE_ERROR = "SessionManager couldn't change data in the database!";

    /**
     * Constructor for SessionDataChangeException.
     * 
     */
    public SessionDataChangeException() {
        super(STRING_CHANGE_ERROR);
    }

    /**
     * Constructor for SessionDataChangeException.
     * 
     * @param cause
     *            the root cause (usually from using a underlying data access
     *            API such as JDBC)
     */
    public SessionDataChangeException(Throwable cause) {
        super(STRING_CHANGE_ERROR + " | " + cause.getMessage(), cause);
    }
}
