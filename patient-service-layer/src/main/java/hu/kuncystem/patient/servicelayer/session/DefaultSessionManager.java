package hu.kuncystem.patient.servicelayer.session;

import hu.kuncystem.patient.dao.session.SessionDao;
import hu.kuncystem.patient.pojo.session.Session;

/**
 * This class use the singleton pattern desing that we handle the session datas. 
 * 
 * This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
 * 
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public class DefaultSessionManager implements SessionManager {
	//current instance
	private static SessionManager instance;
	
	//provides access to the data of session
	private final SessionDao dao;
	
	//current session data
	private Session currentSession;
	
	/**
	 * This class manages all of the data of the session. We can reach some operation functions through the class. We can create and check the data of the session, too.
	 *
	 */
	private DefaultSessionManager() {
		this.dao = null;
	}
	
	/**
	 * This method create a new instance if it is necessary and/or it will return the current instance.
	 * 
	 * @return
	 */
	public static SessionManager getInstance(){
		return instance;
	}
	
	public boolean createSession(long userId, String ip) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createSession(long userId, String ip, String userAgent) {
		// TODO Auto-generated method stub
		return false;
	}

	public Session getSession() {
		return currentSession;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean destroy() {
		// TODO Auto-generated method stub
		return false;
	}

}
