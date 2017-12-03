package hu.kuncystem.patient.pojo.user;

/**
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 * 
 * @version 1.0
 */
public class UserFactory {
    public static final String DOCTOR = "DOCTOR";

    public static final String PATIENT = "PATIENT";

    public static final String DEFAULT = "";

    /**
     * Create new model object from Doctor or Patient class.
     *
     * @param type
     *            The type of object which we want to create. For the value we
     *            can use the static variables of class, too: UserFactory.DOCTOR
     *            or UserFactory.PATIENT
     * @return An instance of Doctor or Patient model class
     */
    public User getUser(String type) {
        if (type == null) {
            return null;
        } else {
            if (type.equalsIgnoreCase(PATIENT)) {
                return new Patient();
            } else if (type.equalsIgnoreCase(DOCTOR)) {
                return new Doctor();
            } else {
                return new DefaultUser();
            }
        }
    }

    /**
     * Check the user is a doctor.
     *
     * @param user
     *            Object.User model class is a simple POJO object.
     * @return If the user is a doctor then return true otherwise it will be
     *         false.
     */
    public boolean isDoctor(User user) {
        return user.getType().getSimpleName().toUpperCase().equalsIgnoreCase(DOCTOR);

    }

    /**
     * Check the user is a patient.
     *
     * @param user
     *            Object.User model class is a simple POJO object.
     * @return If the user is a patient then return true otherwise it will be
     *         false.
     */
    public boolean isPatient(User user) {
        return user.getType().getSimpleName().toUpperCase().equalsIgnoreCase(PATIENT);

    }
}
