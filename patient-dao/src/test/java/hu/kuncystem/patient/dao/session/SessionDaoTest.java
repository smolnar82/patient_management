package hu.kuncystem.patient.dao.session;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.kuncystem.patient.dao.H2Config;
import hu.kuncystem.patient.pojo.session.Session;

/**
 * This is a class for session dao test
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 28.
 * 
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { H2Config.class })
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessionDaoTest {

    private static Session session;

    @BeforeClass
    public static void setup() {
        session = new Session(1, "127.0.0.1");
        session.setDisabled(false);
        session.setUserAgent("TESTBook 3.2; Mozilla 4=34.2");
    }

    @Autowired
    @Qualifier(value = "JDBCSessionDao")
    private SessionDao sessionDao;

    @Test
    public void stage1_schouldSuccessfullyWhenSessionDaoVariableContainJDBCSessionDaoObject() {
        assertThat(sessionDao, instanceOf(JDBCSessionDao.class));
    }

    @Test
    public void stage2_schouldCreateSessionSuccessfully() {
        session = sessionDao.saveSession(session);
        assertNotNull(session);
        assertTrue("new session create failed", session.getId() > 0);
    }

    @Test
    public void stage3_schouldUpdateSessionDataWhenSessionExsitsById() {
        session.setUserAgent("XXXXTESTBook 3.2; Mozilla 4=34.11");
        assertTrue(sessionDao.updateSession(session));
    }

    @Test
    public void stage4_schouldGetSessionDataWhenSessionExsitsById() {
        session = sessionDao.getSession(session.getId());
        assertEquals("127.0.0.1", session.getIp());
    }
}
