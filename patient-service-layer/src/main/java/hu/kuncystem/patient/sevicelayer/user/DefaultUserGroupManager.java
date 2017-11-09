package hu.kuncystem.patient.sevicelayer.user;

import java.util.List;

import hu.kuncystem.patient.dao.user.UserGroupDao;
import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserGroup;

/**
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public class DefaultUserGroupManager implements UserGroupManager {
	/**
	 * This is a marker which indicates that we want to record new row
	 */
	public static final int NEW_ROW = -1;
	
	//provides access to the data of user group
	private final UserGroupDao dao;
	
	/**
	 * This class manages all of the data of a group. We can reach some operation functions through the class. We can create, update or delete one data of the group, too.
	 *
	 */
	public DefaultUserGroupManager() {
		this.dao = null;
	}

	public long createGroup(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long createGroup(String name, String note) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserGroup getGroup(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public long saveRelation(long userId, long groupId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<UserGroup> getGroupOfUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUsersFromGroup(long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

}
