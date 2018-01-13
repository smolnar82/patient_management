package hu.kuncystem.patient.servicelayer.exception;

/**
 * As this class is a runtime exception, there is no need for user code to catch
 * it or subclasses if any error is to be considered fatal. We can use this
 * exception if an appointment is not exists.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 8.
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AppointmentNotExistsException extends RuntimeException {

    /**
     * Constructor for AppointmentNotExistsException.
     * 
     */
    public AppointmentNotExistsException() {
        super("The appointment doesn't exists!");
    }
}
