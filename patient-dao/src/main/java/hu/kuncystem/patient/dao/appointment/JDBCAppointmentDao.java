package hu.kuncystem.patient.dao.appointment;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import hu.kuncystem.patient.pojo.appointment.Appointment;
import hu.kuncystem.patient.pojo.user.User;

/**
 * Create a JDBC dao object which defines standard operations on a data source. This data source belong to data of appointment.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public class JDBCAppointmentDao implements AppointmentDao {
	private DataSource dataSource;
	
	/* (non-Javadoc)
	 * @see hu.kuncystem.patient.dao.appointment.AppointmentDao#setDataSource(javax.sql.DataSource)
	 */
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
	}
	
	public long saveAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean updateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return false;
	}

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

}
