package hu.kuncystem.patient.pojo.user;

public class UserGroupRelation {
	private long id;
	private UserGroup userGroup;
	private User user;
	
	public UserGroupRelation() {}

	public UserGroupRelation(long id) {
		setId(id);
	}

	public UserGroupRelation(User user, UserGroup group) {
		setUser(user);
		setUserGroup(group);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroupId) {
		this.userGroup = userGroupId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
