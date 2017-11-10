package hu.kuncystem.patient.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import hu.kuncystem.patient.pojo.user.Patient;
import hu.kuncystem.patient.pojo.user.User;

/**
 * Create a JDBC dao object which defines standard operations on a data source. This data source belong to data of user.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
@Repository
public class JDBCUserDao implements UserDao {
	
	@Autowired
	private JdbcOperations jdbc;
	
	private static final String SQL_FIND_BY_ID = "SELECT * FROM users WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO users (user_name, passw, fullname, email) VALUES (?, ?, ?, ?);";
	
	public long saveUser(final User user) {
		KeyHolder holder = new GeneratedKeyHolder();
		
		int rows = jdbc.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT, new String[]{"id"});
				
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFullname());
				ps.setString(4, user.getEmail());
				
				return ps;
			}
		}, holder);
		//if the operations was successed
		if(rows == 1){
			return (Integer)holder.getKey();
		}
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
		return jdbc.queryForObject(SQL_FIND_BY_ID, new UserRowMapper(), id);
	}

	public User getUser(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class UserRowMapper implements RowMapper<User>{

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public User mapRow(ResultSet rs, int row) throws SQLException {
			User u = new Patient(rs.getString("user_name"), rs.getString("passw"), rs.getBoolean("active"));
			u.setId(rs.getInt("id"));
			u.setEmail(rs.getString("email"));
			u.setFullname(rs.getString("fullname"));
			
			return u;
		}
		
	}
}
