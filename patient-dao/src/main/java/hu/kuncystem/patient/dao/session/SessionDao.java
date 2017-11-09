package hu.kuncystem.patient.dao.session;

import javax.sql.DataSource;

import hu.kuncystem.patient.pojo.session.Session;

/**
 * This interface defines the standard operations to be performed on a model object.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public interface SessionDao {
	 /**
	 * This is the method to be used to initialize database resources ie. connection.
	 *
	 * @param ds The DataSource objects are the preferred means of getting a connection to a data source.
	 */
	public void setDataSource(DataSource ds);
		
	/**
	 * Insert new data of the session into the database.
	 *
	 * @param session Object.Session is a simple POJO object.
	 * @return This is a new row id.
	 */
	public long saveSession(Session session);

	/**
	 * Update one row in the database.
	 *
	 * @param session Object.Session is a simple POJO object.
	 * @return will return true for success otherwise it will return false.
	 */
	public boolean updateSession(Session session);

	/**
	 * Get one row from the database.
	 *
	 * @param sessionId This is the unique identification of the row.
	 * @return Object.Session is a simple POJO object.
	 */
	public Session getSession(long sessionId);
}
