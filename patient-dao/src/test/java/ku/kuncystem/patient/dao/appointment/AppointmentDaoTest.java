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
@ContextConfiguration(classes = { H2Config.class })
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentDaoTest {

    private static Appointment appointment;

    private static User patient, doctor;

    private static Session session;

    @BeforeClass
    public static void setup() {
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

        // create new appointment
        Date date = null;
        try {
            date = new SimpleDateFormat(JDBCAppointmentDao.DATE_FORMAT).parse("2017-07-10 10:00:00");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        appointment = new Appointment(doctor, patient, date);
        appointment.setDescripton("This is a test schedule.");
        appointment.setNotes(Arrays.asList(new String[] { "note1", "note2", "note3" }));
    }

    @Autowired
    @Qualifier(value = "JDBCAppointmentDao")
    private AppointmentDao appointmentDao;

    @Autowired
    @Qualifier(value = "JDBCUserDao")
    private UserDao userDao;

    @Autowired
    @Qualifier(value = "JDBCSessionDao")
    private SessionDao sessionDao;

    @Test
    public void stage1_checkTheJDBCVariable() {
        assertThat(userDao, instanceOf(JDBCUserDao.class));
        assertThat(sessionDao, instanceOf(JDBCSessionDao.class));
        assertThat(appointmentDao, instanceOf(JDBCAppointmentDao.class));
    }

    @Test
    public void stage2_schouldCreateNewUsersWhenUsersDidNotExists() {
        // create new user(patient)
        patient = userDao.saveUser(patient);
        assertNotNull(patient);
        assertTrue("new user create failed", patient.getId() > 0);

        // create new user(doctor)
        doctor = userDao.saveUser(doctor);
        assertNotNull(doctor);
        assertTrue("new user create failed", doctor.getId() > 0);
    }

    @Test
    public void stage3_schouldCreateSession() {
        session = sessionDao.saveSession(session);
        assertNotNull(session);
        assertTrue("new session create failed", session.getId() > 0);
    }

    @Test
    public void stage4_schouldCreateNewAppointment() {
        appointment.setSidid(session.getId());
        appointment = appointmentDao.saveAppointment(appointment);
        assertNotNull(appointment);
        assertTrue("new appointment create failed", appointment.getId() > 0);
    }

    @Test
    public void stage5_schouldGetAppointmentWhenExists() {
        appointment = appointmentDao.getAppointment(appointment.getId());
        assertTrue("select data error", appointment.getNotes().size() == 3);
    }

    @Test
    public void stage6_schouldGetAppointmentsListWhenExistsByDate() {
        Date date = null;
        Date date2 = null;
        try {
            date = new SimpleDateFormat(JDBCAppointmentDao.DATE_FORMAT).parse("2017-07-01 10:00:00");
            date2 = new SimpleDateFormat(JDBCAppointmentDao.DATE_FORMAT).parse("2017-07-30 10:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Appointment> listAppointments = appointmentDao.getAppointments(doctor, date, date2);
        assertTrue("list proccess error", listAppointments.size() > 0);
    }

    @Test
    public void stage7_schouldUpdateAppointmentSuccessfullyWhenAppointmentExsitsById() {
        assertTrue("update was unsuccessful", appointmentDao.updateAppointment(appointment));
    }

    @Test
    public void stage8_schouldDeleteSuccessfullyWhenAppointmentExsist() {
        assertTrue("deleteAppointment:120 > row delete failed", appointmentDao.deleteAppointment(appointment));
    }
}
