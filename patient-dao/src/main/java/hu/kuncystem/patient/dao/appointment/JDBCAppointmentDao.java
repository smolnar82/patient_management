package hu.kuncystem.patient.dao.appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import hu.kuncystem.patient.pojo.appointment.Appointment;
import hu.kuncystem.patient.pojo.user.User;

/**
 * Create a JDBC dao object which defines standard operations on a data source.
 * This data source belong to data of appointment.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 * 
 * @version 1.0
 */
@Repository
public class JDBCAppointmentDao implements AppointmentDao {

    private static final String SQL_INSERT_APPOINTMENT = "INSERT INTO "
            + "appointment_table (doctor_id, patient_id, appointment, description, sid) " + "VALUES (?, ?, ?, ?, ?);";

    private static final String SQL_INSERT_APPOINTMENT_NOTES = "INSERT INTO "
            + "appointment_notes (appointment_id, note, sid) " + "VALUES (?, ?, ?);";

    @Autowired
    private JdbcOperations jdbc;

    public boolean deleteAppointment(Appointment appointment) {
        // TODO Auto-generated method stub
        return false;
    }

    public Appointment getAppointment(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Appointment> getAppointments(User user, Date dateFrom, Date dateTo) {
        // TODO Auto-generated method stub
        return null;
    }

    public Appointment saveAppointment(final Appointment appointment) {
        KeyHolder holder = new GeneratedKeyHolder();
        int rows = 0;
        try {
            rows = jdbc.update(new PreparedStatementCreator() {

                public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                    PreparedStatement ps = conn.prepareStatement(SQL_INSERT_APPOINTMENT, new String[] { "id" });

                    ps.setLong(1, appointment.getDoctor().getId());
                    ps.setLong(2, appointment.getPatient().getId());
                    ps.setString(3, new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(appointment.getTimet()));
                    ps.setString(4, appointment.getDescription());
                    ps.setLong(5, appointment.getSidid());

                    return ps;
                }
            }, holder);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        if (rows > 0) {
            appointment.setId(holder.getKey().longValue());

            if (!this.saveAppointmentNote(appointment.getId(), appointment.getNotes(), appointment.getSidid())) {
                return null;
            } else {
                return appointment;
            }
        }
        return null;
    }

    private boolean saveAppointmentNote(final long id, final List<String> notes, final long sid) {

        try {
            jdbc.batchUpdate(SQL_INSERT_APPOINTMENT_NOTES, new BatchPreparedStatementSetter() {

                public int getBatchSize() {
                    return notes.size();
                }

                public void setValues(PreparedStatement ps, int i) throws SQLException {

                    ps.setLong(1, id);
                    ps.setString(2, notes.get(i));
                    ps.setLong(3, sid);
                }
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateAppointment(Appointment appointment) {
        // TODO Auto-generated method stub
        return false;
    }

}
