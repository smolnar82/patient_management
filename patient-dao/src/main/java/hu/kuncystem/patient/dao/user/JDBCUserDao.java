package hu.kuncystem.patient.dao.user;

import javax.sql.DataSource;

import hu.kuncystem.patient.pojo.user.User;

/**
 * Create a JDBC dao object which defines standard operations on a data source. This data source belong to data of user.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public class JDBCUserDao implements UserDao {
	private DataSource dataSource;
	   
	/* (non-Javadoc)
	 * @see hu.kuncystem.patient.dao.session.SessionDao#setDataSource(javax.sql.DataSource)
	 */
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
	}
	
	public long saveUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(User user) {
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
