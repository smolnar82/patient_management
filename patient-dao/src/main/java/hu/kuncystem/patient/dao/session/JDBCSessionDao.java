package hu.kuncystem.patient.dao.session;

import javax.sql.DataSource;

import hu.kuncystem.patient.pojo.session.Session;

/**
 * Create a JDBC dao object which defines standard operations on a data source. This data source belong to data of session.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public class JDBCSessionDao implements SessionDao {
	private DataSource dataSource;
	   
	/* (non-Javadoc)
	 * @see hu.kuncystem.patient.dao.session.SessionDao#setDataSource(javax.sql.DataSource)
	 */
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
	}
	
	public long saveSession(Session session) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean updateSession(Session session) {
		// TODO Auto-generated method stub
		return false;
	}

	public Session getSession(long sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
