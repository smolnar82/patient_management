package hu.kuncystem.patient.servicelayer.session;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.kuncystem.patient.pojo.session.Session;
import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.servicelayer.exception.SessionExistsException;
import hu.kuncystem.patient.servicelayer.exception.SessionNotExistsException;
import hu.kuncystem.patient.servicelayer.user.UserManager;
import hu.kuncystem.patient.servicelayer.utilities.Hash;

/**
 * Testing the SessionManagerTest methods
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2018. jan. 7.
 * 
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/beans_settings.xml" })
@ActiveProfiles("live")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessionManagerTest {

    private static User user;

    @Autowired
    @Qualifier("defaultUserManager")
    private UserManager userManager;

    @Autowired
    @Qualifier("defaultSessionManager")
    private SessionManager sessionManager;

    @Test
    public void stage1_schouldCreateSessionSuccessfullyWhenDidNotStart() {
        user = userManager.createUser("test_session", Hash.MD5("12345"), true);

        // destroy old session(if exists)
        try {
            sessionManager.destroy();
        } catch (SessionNotExistsException e) {
            // we haven't session(do something)
        }
        // create new session proccess
        sessionManager.createSession(user.getId(), "127.0.0.1", "TEST JUnit 4");
    }

    @Test
    public void stage2_schouldCreateSessionUnsuccessfullyBecauseSessionExists() {
        try {
            sessionManager.createSession(user.getId(), "127.0.0.1", "TEST JUnit 4");
            fail("It might have to throw a SessionExistsException exception!");
        } catch (SessionExistsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void stage3_checkSessionState() {
        assertTrue("The current session is disabled.", sessionManager.isEnabled());
    }

    @Test
    public void stage4_checkSessionData() {
        Session session = sessionManager.getSession();
        assertTrue("Session ip not match.", session.getIp().equals("127.0.0.1"));

        assertTrue("Session user id not match.", session.getUserId() == user.getId());
    }

    @Test
    public void stage5_schouldDestroySessionSuccessfullyWhenSessionExsist() {
        assertTrue("Destroy of session was failed.", sessionManager.destroy());
    }

    @Test
    public void stage6_schouldDestroySessionUnSuccessfullyBecauseSessionDidNotExsist() {
        try {
            if (sessionManager.destroy()) {
                fail("The session exists still!");
            } else {
                assertTrue(true);
            }
        } catch (SessionNotExistsException e) {
            assertTrue(true);
        }
    }
}
