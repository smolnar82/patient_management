package hu.kuncystem.patient.dao.session;

import hu.kuncystem.patient.dao.exception.DatabaseException;
import hu.kuncystem.patient.pojo.session.Session;

/**
 * This interface defines the standard operations to be performed on a model
 * object.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 * 
 * @version 1.0
 */
public interface SessionDao {
    /**
     * Get one row from the database.
     *
     * @param sessionId
     *            This is the unique identification of the row.
     * @return Object.Session is a simple POJO object.
     * @throws DatabaseException
     *             if the query fails
     */
    public Session getSession(long sessionId) throws DatabaseException;

    /**
     * Insert new data of the session into the database.
     *
     * @param session
     *            Object.Session is a simple POJO object.
     * @return This is a new Session POJO object.
     * @throws DatabaseException
     *             if there is any problem issuing the update
     */
    public Session saveSession(Session session) throws DatabaseException;

    /**
     * Update one row in the database.
     *
     * @param session
     *            Object.Session is a simple POJO object.
     * @return will return true for success otherwise it will return false.
     * @throws DatabaseException
     *             if there is any problem issuing the update
     */
    public boolean updateSession(Session session) throws DatabaseException;
}
