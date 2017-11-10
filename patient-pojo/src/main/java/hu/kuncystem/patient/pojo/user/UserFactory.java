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

	/**
	 * This class create new instance from User or Doctor Model class without exposing the creation logic to the client.
	 *
	 */
	public UserFactory() {
		
	}

	/**
	 * Create new model object from Doctor or Patient class. 
	 *
	 * @param type The type of object which we want to create. For the value we can use the static variables of class, too: UserFactory.DOCTOR or UserFactory.PATIENT
	 * @return An instance of Doctor or Patient model class
	 */
	public static User getUser(String type) {
		if(type.equalsIgnoreCase(PATIENT)){
			return new Patient();
		}else if(type.equalsIgnoreCase(DOCTOR)){
			return new Doctor();
		}
		return null;
	}

	/**
	 * Check the user is a patient.
	 *
	 * @param user Object.User model class is a simple POJO object.
	 * @return If the user is a patient then return true otherwise it will be false.
	 */
	public static boolean isPatient(User user) {
		return false;
		
	}

	/**
	 * Check the user is a doctor.
	 *
	 * @param user Object.User model class is a simple POJO object.
	 * @return If the user is a doctor then return true otherwise it will be false.
	 */
	public static boolean isDoctor(User user) {
		return false;
		
	}
}
