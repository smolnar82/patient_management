package hu.kuncystem.patient.pojo.user;

/**
 * This object is a simple POJO containing get/set methods. This object is going to work as a Model.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 7.
 *  
 * @version 1.0
 */
public class UserGroup {
	//Identification of one group.
	private long id;
	//group name
	private String name;
	//description of group
	private String note;

	/**
	 * This class will pass information to user group dao object to get the data it needs.
	 *
	 */
	public UserGroup() {}
	
	/**
	 * This class will pass information to user group dao object to get the data it needs.
	 *
	 * @param id ): This is a unique row id of the user group in database. If this id is -1 then this object doesn’t contain data of new user. 
	 * If the id is greater than -1 then this object contains data of an existing user.
	 */
	public UserGroup(long id) {
		setId(id);
	}

	/**
	 * This class will pass information to user group dao object to get the data it needs.
	 *
	 * @param name This is the group’s name.
	 */
	public UserGroup(String name) {
		setName(name);
	}

	/**
	 * Set new identification.
	 * 
	 * @param id Identification of one user group. If the value is -1 then it means that the set data will be a new data. This isn’t in database, yet.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Get identification of one user group.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set user group name
	 *
	 * @param name This is a group name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get group name
	 * */
	public String getName() {
		return name;
	}

	/**
	 * Set a description from the group.
	 *
	 * @param note Description of group.
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Get description of group.
	 * */
	public String getNote() {
		return note;
	}
}
