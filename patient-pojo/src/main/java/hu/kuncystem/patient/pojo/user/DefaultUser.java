package hu.kuncystem.patient.pojo.user;

/**
 * This object is a simple POJO containing get/set methods. This object is going to work as a Model.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 12.
 *  
 * @version 1.0
 */
public class DefaultUser implements User {
	//user's unique id in the database
	private long id;
	//user's alias name
	private String userName;
	//user's password
	private String password;
	//user's full name (first name and surname)
	private String fullname;
	//user's valid email
	private String email;
	//user's state, active or not
	private boolean active;
	
	/**
	 * This class will pass information to user dao object to get the data it needs.
	 *
	 */
	public DefaultUser(){}
	
	/**
	 * This class will pass information to user dao object to get the data it needs.
	 *
	 * @param id Unique row id of user in database. If this id is -1 then this object doesn't contain data of new user. 
	 * If the id is greater than -1 then this object contains data of an existing user.
	 */
	public DefaultUser(long id){
		setId(id);
	}
	
	/**
	 * This class will pass information to user dao object to get the data it needs.
	 *
	 * @param userName This is the user's name.
	 * @param password This is the user's password which have to be encoded format.
	 * @param active This is a flag that the user�s state is enable or disable.
	 */
	public DefaultUser(String userName, String password, boolean active){
		setUserName(userName);
		setPassword(password);
		setActive(active);
	}
	public long getId() {
		
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String psw) {
		this.password = psw;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String name) {
		this.fullname = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}

	@SuppressWarnings("rawtypes")
	public Class getType() {
		return DefaultUser.class;
	}
}
