package hu.kuncystem.patient.dao.appointment;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import hu.kuncystem.patient.pojo.appointment.Appointment;
import hu.kuncystem.patient.pojo.user.User;

/**
 * This interface defines the standard operations to be performed on a model object(s).
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public interface AppointmentDao {
	 /**
	 * This is the method to be used to initialize database resources ie. connection.
	 *
	 * @param ds The DataSource objects are the preferred means of getting a connection to a data source.
	 */
	public void setDataSource(DataSource ds);
	 
	/**
	 * Insert new appointment into the database.
	 *
	 * @param appointment Object.Appointment is a simple POJO object.
	 * @return This is a new row id.
	 */
	public long saveAppointment(Appointment appointment);

	/**
	 * Update one appointment row in the database.
	 *
	 * @param appointment Object.Appointment is a simple POJO object. This object contains the data which we have to modify.
	 * @return It will return true for success otherwise it will return false.
	 */
	public boolean updateAppointment(Appointment appointment);

	/**
	 * Delete one appointment row from the database.
	 *
	 * @param appointment Object.Appointment is a simple POJO object. This object contains the data which we have to delete.
	 * @return It will return true for success otherwise it will return false.
	 */
	public boolean deleteAppointment(Appointment appointment);

	/**
	 * Get one row from the database.
	 *
	 * @param id The unique row identification of appointment
	 * @return
	 */
	public Appointment getAppointment(long id);

	/**
	 * Get more rows from database. These rows contain the appointment of the doctor between two dates.
	 *
	 * @param user Object.User is a simple POJO object. This object contains the data of user whose appointment is necessary.
	 * @param dateFrom Begin of filter date. If this is null then the begin date is open.
	 * @param dateTo End of filter date. If this is null then the end date is open.
	 * @return Object.List object that it is contain Appointment objects.
	 */
	public List<Appointment> getAppointments(User user, Date dateFrom, Date dateTo);
}
