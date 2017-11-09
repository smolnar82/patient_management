package hu.kuncystem.patient.dao.user;

import java.util.List;

import javax.sql.DataSource;

import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserGroup;

/**
 * This interface defines the standard operations to be performed on a model object(s).
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public interface UserGroupDao {
	 /**
	 * This is the method to be used to initialize database resources ie. connection.
	 *
	 * @param ds The DataSource objects are the preferred means of getting a connection to a data source.
	 */
	public void setDataSource(DataSource ds);
	
	/**
	 * Insert new user group into the database.
	 *
	 * @param group Object.User is a simple POJO object.
	 * @return This is new row id.
	 */
	public long saveUserGroup(UserGroup group);

	/**
	 * Get a row from the database by id.
	 *
	 * @param id The unique value of a row in database.
	 * @return Object.UserGroup is a simple POJO object.
	 */
	public UserGroup getUserGroup(long id);

	/**
	 * This method inserts a user into a new group.
	 *
	 * @param group Object.UserGroup is a simple POJO object. This is a new group of user.
	 * @param user Object.User is a simple POJO object. This user who will insert into the group.
	 * @return It will return true for success otherwise it will return false.
	 */
	public long saveUserGroupRelation(UserGroup group, User user);

	/**
	 * Return all users who are in this group.
	 *
	 * @param user Object. UserGroup is a simple POJO object. This object contains the data of the group. Get a user list from this group.
	 * @return Object.List object which contains User objects.
	 */
	public List<User> getAllUserFromGroup(UserGroup group);

	/**
	 * This method returns all groups of a user.
	 *
	 * @param user Object. User is a simple POJO object. This object contains data of a user.
	 * @return Object.List object which contains UserGroup objects.
	 */
	public List<UserGroup> getAllUserGroupByUser(User user);
}
