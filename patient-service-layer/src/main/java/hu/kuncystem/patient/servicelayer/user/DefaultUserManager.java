package hu.kuncystem.patient.servicelayer.user;

import hu.kuncystem.patient.dao.user.UserDao;
import hu.kuncystem.patient.pojo.user.User;

/**
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public class DefaultUserManager implements UserManager {
	/**
	 * This is a marker which indicates that we want to record new row
	 */
	public static final int NEW_ROW = -1;
	
	//provides access to the data of user
	private final UserDao dao;
	
	/**
	 * This class manages all of the user’s data. We can reach some operation functions through the class. We can create, update or delete one user’s data, too.
	 *
	 */
	public DefaultUserManager(){
		this.dao = null;
	}
	
	public long createUser(String name, String password, boolean active) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long createUser(String name, String password, boolean active, String fullname, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean updateUser(long userId, String name, String password, boolean active, String fullname,
			String email) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeUser(long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
