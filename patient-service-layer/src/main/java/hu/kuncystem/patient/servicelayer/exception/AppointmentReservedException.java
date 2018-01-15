package hu.kuncystem.patient.servicelayer.exception;

/**
 * As this class is a runtime exception, there is no need for user code to catch
 * it or subclasses if any error is to be considered fatal. We can use this
 * exception if an appointment is not enabled because is reserved.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 7.
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AppointmentReservedException extends RuntimeException {

    /**
     * Constructor for AppointmentReservedException.
     * 
     */
    public AppointmentReservedException() {
        super("The date of appoinment is not free!");
    }
}
