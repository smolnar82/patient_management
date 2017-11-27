package hu.kuncystem.patient.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
@Repository
public class JDBCUserGroupDao implements UserGroupDao {
	
	@Autowired
	private JdbcOperations jdbc;
	
	private static final String SQL_INSERT = "INSERT INTO user_group_relation (user_group_id, users_id) VALUES (?,?);";
	private static final String SQL_FIND_GROUP_BY_ID = "SELECT * FROM user_group WHERE id = ?";
	
	public long saveUserGroup(UserGroup group) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserGroup getUserGroup(long id) {
		return jdbc.queryForObject(SQL_FIND_GROUP_BY_ID, new UserGroupRowMapper(), id);
	}

	public boolean saveUserGroupRelation(final UserGroup group, final User user) {
		int rows = jdbc.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
				
				ps.setLong(1, group.getId());
				ps.setLong(2, user.getId());
				
				return ps;
			}
		});
		//if the operations was successed
		if(rows == 1){
			return true;
		}
		return false;
	}

	public List<User> getAllUserFromGroup(UserGroup group) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserGroup> getAllUserGroupByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	private class UserGroupRowMapper implements RowMapper<UserGroup>{

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public UserGroup mapRow(ResultSet rs, int row) throws SQLException {
			UserGroup group = new UserGroup(rs.getLong("id"));
			group.setName(rs.getString("name"));
			group.setNote(rs.getString("note"));
			
			return group;
		}
		
	}
}
