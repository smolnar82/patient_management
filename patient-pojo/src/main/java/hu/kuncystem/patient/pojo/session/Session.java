package hu.kuncystem.patient.pojo.session;

/**
 * This object is a simple POJO containing get/set methods. This object is going
 * to work as a Model.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 7.
 * 
 * @version 1.0
 */
public class Session {
    // Identification of one session.
    private long id;
    // Object.User -> id
    private long userId;
    // Normal ip address
    private String ip;
    // Data of browser or pc
    private String userAgent;
    // This session is enabled or disabled
    private boolean disable;

    /**
     * This class will pass information to session dao object to get the data it
     * needs.
     *
     */
    public Session() {
    }

    /**
     * This class will pass information to session dao object to get the data it
     * needs.
     *
     * @param id
     *            Identification of one session.
     */
    public Session(long id) {
        setId(id);
    }

    /**
     * This class will pass information to session dao object to get the data it
     * needs.
     *
     * @param userId
     *            This is the unique user id. This id identifies one row in the
     *            User table.
     * @param ip
     *            Ip address of user.
     */
    public Session(long userId, String ip) {
        setUserId(userId);
        setIp(ip);
    }

    /**
     * Get identification of one session.
     *
     * @return long unique row id.
     */
    public long getId() {
        return id;
    }

    /**
     * Get current session ip.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Get data of browser or pc
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Get user's id who belongs to session.
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Check the session that it is enabled or not.
     */
    public boolean isDisabled() {
        return disable;
    }

    /**
     * Set that the session is enabled or not.
     *
     * @param disabled
     *            true: session is enabled, false: session is disabled
     */
    public void setDisabled(boolean disabled) {
        this.disable = disabled;
    }

    /**
     * Set new identification.
     * 
     * @param id
     *            Identification of one session. If the value is -1 then it
     *            means that the set data will be a new data. This isn�t in
     *            database, yet.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * This ip is current ip which belongs to user's pc.
     *
     * @param ip
     *            Ip address of user
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Add user's data from the pc or the web browser. This string have to
     * contains more information which identifies the workstation.
     *
     * @param userAgent
     *            Data of browser or pc
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * Set user's unique id. This user will be doctor or patient, too.
     *
     * @param userId
     *            This is the unique user id. This id identifies one row in the
     *            User table.
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
