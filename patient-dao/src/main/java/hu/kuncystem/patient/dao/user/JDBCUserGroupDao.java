package hu.kuncystem.patient.dao.user;

import java.util.List;

import javax.sql.DataSource;

import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserGroup;

/**
 * Create a JDBC dao object which defines standard operations on a data source. This data source belong to data of user group.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public class JDBCUserGroupDao implements UserGroupDao {
	private DataSource dataSource;
	   
	/* (non-Javadoc)
	 * @see hu.kuncystem.patient.dao.session.SessionDao#setDataSource(javax.sql.DataSource)
	 */
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
	}
	public long saveUserGroup(UserGroup group) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserGroup getUserGroup(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public long saveUserGroupRelation(UserGroup group, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<User> getAllUserFromGroup(UserGroup group) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserGroup> getAllUserGroupByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
