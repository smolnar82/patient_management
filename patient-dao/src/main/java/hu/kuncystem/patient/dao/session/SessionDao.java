package hu.kuncystem.patient.dao.session;

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
	 * Insert new data of the session into the database.
	 *
	 * @param session Object.Session is a simple POJO object.
	 * @return This is a new Session POJO object.
	 */
	public Session saveSession(Session session);

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
