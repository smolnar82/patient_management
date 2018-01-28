package hu.kuncystem.patient.servicelayer.session;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import hu.kuncystem.patient.dao.exception.DatabaseException;
import hu.kuncystem.patient.dao.session.SessionDao;
import hu.kuncystem.patient.pojo.session.Session;
import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserFactory;
import hu.kuncystem.patient.servicelayer.exception.SessionDataChangeException;
import hu.kuncystem.patient.servicelayer.exception.SessionExistsException;
import hu.kuncystem.patient.servicelayer.exception.SessionNotExistsException;

/**
 * This class use the singleton pattern desing that we handle the session datas.
 * 
 * This class provides a way to access its only object which can be accessed
 * directly without need to instantiate the object of the class.
 * 
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 * 
 * @version 1.0
 */
@Service("defaultSessionManager")
@Scope("singleton")
public class DefaultSessionManager implements SessionManager {
    @Autowired
    @Qualifier(value = "JDBCSessionDao")
    private SessionDao sessionDao;

    // current session data
    private Session currentSession = null;

    /**
     * This class manages all of the data of the session. We can reach some
     * operation functions through the class. We can create and check the data
     * of the session, too.
     *
     */
    private DefaultSessionManager() {
    }

    public Session createSession(long userId, String ip) throws SessionExistsException {
        return this.createSession(userId, ip, null);
    }

    public Session createSession(long userId, String ip, String userAgent)
            throws SessionExistsException, SessionDataChangeException {
        if (currentSession == null) { // if the session doesn't exists, yet
            currentSession = new Session(userId, ip);
            currentSession.setUserAgent(userAgent);
            currentSession.setDisabled(false);

            try {
                // create new session in the database
                currentSession = sessionDao.saveSession(currentSession);
            } catch (DatabaseException e) { // it happend database error
                throw new SessionDataChangeException(e);
            }
        } else { // the session already exists
            throw new SessionExistsException();
        }
        return currentSession;
    }

    public boolean destroy() throws SessionDataChangeException, SessionNotExistsException {
        boolean ok = false;
        // we can destroy this session if this exists
        if (currentSession != null) {
            try {
                // disable in the database
                currentSession.setDisabled(true);
                ok = sessionDao.updateSession(currentSession);
                if (ok) {
                    currentSession = null;
                }

            } catch (DatabaseException e) { // catch the database error
                throw new SessionDataChangeException(e);
            }

            // if the destroy process was unsuccessful then we have to reset
            // this flag
            if (!ok && currentSession.isDisabled()) {
                currentSession.setDisabled(false);
            }

        } else { // the session doesn't exists yet
            throw new SessionNotExistsException();
        }

        return ok;

    }

    public boolean destroyAllActiveSession(long userId) {
        // create default user object
        UserFactory factory = new UserFactory();
        User user = factory.getUser(UserFactory.DEFAULT);
        user.setId(userId);

        // get active user sessions(if there are)
        List<Session> sessionList = sessionDao.getSession(user, true);
        if (sessionList.size() > 0) {
            for (Session session : sessionList) {
                session.setDisabled(true);
            }
            // disabled all active user session
            try {
                boolean ok = sessionDao.updateSession(sessionList);
                if (ok) {
                    currentSession = null;
                }
                return ok;
            } catch (DatabaseException e) {
                return false;
            }
        }
        return true;
    }

    public Session getSession() throws SessionNotExistsException {
        if (currentSession != null) {
            return currentSession;
        } else {
            throw new SessionNotExistsException();
        }

    }

    public boolean isEnabled() {
        if (currentSession != null) {
            return !currentSession.isDisabled();
        } else {
            return false;
        }
    }
}
