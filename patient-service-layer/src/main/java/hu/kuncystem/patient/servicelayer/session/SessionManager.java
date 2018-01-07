package hu.kuncystem.patient.servicelayer.session;

import hu.kuncystem.patient.pojo.session.Session;

/**
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 * 
 * @version 1.0
 */
public interface SessionManager {
    /**
     * Create new session data in the database
     *
     * @param userId
     *            This is the unique user id. This id identifies one row in the
     *            User table.
     * @param ip
     *            Ip address of user.
     * @return It will return simple Session POJO object which contains the new
     *         database id.
     */
    public Session createSession(long userId, String ip);

    /**
     * Create new session data in the database
     *
     * @param userId
     *            This is the unique user id. This id identifies one row in the
     *            User table.
     * @param ip
     *            Ip address of user.
     * @param userAgent
     *            This is other user's data. This string has to contain data
     *            from the user pc or the browser.
     * @return It will return simple Session POJO object which contains the new
     *         database id.
     */
    public Session createSession(long userId, String ip, String userAgent);

    /**
     * This method disable the current session.
     *
     * @return It will return true for success otherwise it will return false.
     */
    public boolean destroy();

    /**
     * Get current the data of session.
     *
     * @return Object.Session is a simple POJO object.
     */
    public Session getSession();

    /**
     * This method checks that the current session is active or not. If there
     * isn�t session then this method return false.
     *
     * @return It will return true for success otherwise it will return false.
     */
    public boolean isEnabled();

}
