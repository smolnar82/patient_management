package ku.kuncystem.patient.dao.appointment;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hu.kuncystem.patient.dao.H2TestConfig;
import hu.kuncystem.patient.dao.appointment.AppointmentDao;
import hu.kuncystem.patient.dao.appointment.JDBCAppointmentDao;
import hu.kuncystem.patient.dao.session.JDBCSessionDao;
import hu.kuncystem.patient.dao.session.SessionDao;
import hu.kuncystem.patient.dao.user.JDBCUserDao;
import hu.kuncystem.patient.dao.user.UserDao;
import hu.kuncystem.patient.pojo.appointment.Appointment;
import hu.kuncystem.patient.pojo.session.Session;
import hu.kuncystem.patient.pojo.user.User;
import hu.kuncystem.patient.pojo.user.UserFactory;

/**
 * This is a class for appointment dao test
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. dec. 11.
 * 
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { H2TestConfig.class })
public class JDBCAppointmentDaoTest {

    @Autowired
    @Qualifier(value = "JDBCAppointmentDao")
    private AppointmentDao appointmentDao;

    @Autowired
    @Qualifier(value = "JDBCUserDao")
    private UserDao userDao;

    @Autowired
    @Qualifier(value = "JDBCSessionDao")
    private SessionDao sessionDao;

    private Appointment appointment;

    private User patient, doctor;

    private Session session;

    /**
     * Create new test session.
     */
    private void createSession() {
        assertThat(sessionDao, instanceOf(JDBCSessionDao.class));

        // create new session
        session = sessionDao.saveSession(session);
        assertNotNull(session);
        assertTrue("testSession:51 > new session create failed", session.getId() > 0);
    }

    /**
     * Create new users. We will test with these users.
     */
    private void createUserData() {
        assertThat(userDao, instanceOf(JDBCUserDao.class));

        // create new user(patient)
        patient = userDao.saveUser(patient);
        assertNotNull(patient);
        assertTrue("createUserData:84 > new user create failed", patient.getId() > 0);

        // create new user(doctor)
        doctor = userDao.saveUser(doctor);
        assertNotNull(doctor);
        assertTrue("createUserData:99 > new user create failed", doctor.getId() > 0);
    }

    @Before
    public void setup() {
        UserFactory userFactory = new UserFactory();

        // create new object of patient user
        patient = userFactory.getUser(UserFactory.PATIENT);
        patient.setUserName("patient1");
        patient.setPassword("asdf1234");
        patient.setFullname("Test Patient 1");
        patient.setActive(true);

        // create new object of patient user
        doctor = userFactory.getUser(UserFactory.DOCTOR);
        doctor.setUserName("doctor1");
        doctor.setPassword("asdf1234");
        doctor.setFullname("Test Doctor 1");
        doctor.setActive(true);

        // create new session
        session = new Session(1, "127.0.0.1");
        session.setDisabled(false);
        session.setUserAgent("TESTBook 3.2; Mozilla 4=34.2");
    }

    @Test
    @Transactional
    public void testAppointment() {
        assertThat(appointmentDao, instanceOf(JDBCAppointmentDao.class));

        // add new user for test
        this.createUserData();

        // create new session data
        this.createSession();

        // create new appointment pojo object
        Date date = null;
        Date date2 = null;
        try {
            date = new SimpleDateFormat(JDBCAppointmentDao.DATE_FORMAT).parse("2017-07-10 10:00:00");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        appointment = new Appointment(doctor, patient, date);
        appointment.setDescripton("This is a test schedule.");
        appointment.setNotes(Arrays.asList(new String[] { "note1", "note2", "note3" }));
        appointment.setSidid(session.getId());

        // save data into database
        appointment = appointmentDao.saveAppointment(appointment);
        assertNotNull(appointment);
        assertTrue("createAppointment:112 > new appointment create failed", appointment.getId() > 0);

        // get data from database
        long id = appointment.getId();
        appointment = null;
        appointment = appointmentDao.getAppointment(id);
        assertTrue("getAppointment:118 > select data error", appointment.getNotes().size() == 3);

        // get more data from database
        try {
            date = new SimpleDateFormat(JDBCAppointmentDao.DATE_FORMAT).parse("2017-07-01 10:00:00");
            date2 = new SimpleDateFormat(JDBCAppointmentDao.DATE_FORMAT).parse("2017-07-30 10:00:00");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Appointment> listAppointments = appointmentDao.getAppointments(doctor, date, date2);
        assertTrue("getAppointments:131 > list proccess error", listAppointments.size() > 0);

        // update an appointment
        assertTrue("updateAppointment:137 > update was unsuccessful", appointmentDao.updateAppointment(appointment));

        // delete data from database
        assertTrue("deleteAppointment:120 > row delete failed", appointmentDao.deleteAppointment(appointment));
    }
}
