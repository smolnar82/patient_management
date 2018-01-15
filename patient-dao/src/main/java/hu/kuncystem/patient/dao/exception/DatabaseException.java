package hu.kuncystem.patient.dao.exception;

/**
 * As this class is a runtime exception, there is no need for user code to catch
 * it or subclasses if any error is to be considered fatal.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 6.
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DatabaseException extends RuntimeException {
    public final static String STRING_DATA_ACCESS_EXCEPTION = "The run of query was failed. Is the query string OK? QUERY: ";

    /**
     * Constructor for DataAccessException.
     * 
     * @param msg
     *            the detail message
     */
    public DatabaseException(String msg) {
        super(msg);
    }

    /**
     * Constructor for DataAccessException.
     * 
     * @param msg
     *            the detail message
     * @param cause
     *            the root cause (usually from using a underlying data access
     *            API such as JDBC)
     */
    public DatabaseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructor for DataAccessException.
     * 
     * @param cause
     *            the root cause (usually from using a underlying data access
     *            API such as JDBC)
     */
    public DatabaseException(Throwable cause) {
        super(cause);
    }
}
