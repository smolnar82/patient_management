package hu.kuncystem.patient.pojo.user;

/**
 * This object is a simple POJO containing get/set methods. This object is going to work as a Model.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 7.
 *  
 * @version 1.0
 */
public class UserGroupRelation {
	//Identification of one group relation.
	private long id;
	//UserGroup POJO object
	private UserGroup userGroup;
	//User POJO object
	private User user;
	
	/**
	 * This class will pass information to user group relation dao object to get the data it needs.
	 *
	 */
	public UserGroupRelation() {}

	/**
	 * This class will pass information to user group relation dao object to get the data it needs.
	 *
	 * @param id This is an unique row id of the user group relation in database. If this id is -1 then this object doesn’t contain data of new user. 
	 * If the id is greater than -1 then this object contains data of an existing user.
	 */
	public UserGroupRelation(long id) {
		setId(id);
	}

	/**
	 * This class will pass information to user group relation dao object to get the data it needs.
	 *
	 * @param user This is a user POJO object.
	 * @param group This is a user group POJO object.
	 */
	public UserGroupRelation(User user, UserGroup group) {
		setUser(user);
		setUserGroup(group);
	}

	/**
	 * Get identification of one user group.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set new identification.
	 * 
	 * @param id Identification of one user group relation. If the value is -1 then it means that the set data will be a new data. This isn’t in database, yet.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get UserGroup POJO object
	 * */
	public UserGroup getUserGroup() {
		return userGroup;
	}

	/**
	 * Add user group for the relation.
	 *
	 * @param userGroup UserGroup POJO object
	 */
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	/**
	 * Get User POJO object
	 * */
	public User getUser() {
		return user;
	}

	/**
	 * Add user for the relation.
	 *
	 * @param userGroup User POJO object
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
