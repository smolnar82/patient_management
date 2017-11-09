package hu.kuncystem.patient.servicelayer.appointment;

import java.util.Date;
import java.util.List;

import hu.kuncystem.patient.dao.appointment.AppointmentDao;
import hu.kuncystem.patient.pojo.appointment.Appointment;
import hu.kuncystem.patient.servicelayer.session.SessionManager;

/**
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 *  
 * @version 1.0
 */
public class DefaultScheduleManager implements ScheduleManager {
	/**
	 * This is a marker which indicates that we want to record new row
	 */
	public static final int NEW_ROW = -1;
	
	//provides access to the data of appointment
	private final AppointmentDao dao;

	//provides access to the data of session
	private final SessionManager sessionManager;

	//Identification of one appointment which we want to handle. If the value is -1 then it means that the set data will be a new data in the data source.
	private final long rowId;

	/**
	 * This class manages scheduling processes. Through the object we can add new appointment, change and check the appointment time that can be inserted under different conditions.
	 *
	 */
	public DefaultScheduleManager() {
		this.dao = null;
		this.sessionManager = null;
		this.rowId = NEW_ROW;
	}
	/**
	 * This class manages scheduling processes. Through the object we can add new appointment, change and check the appointment time that can be inserted under different conditions.
	 *
	 * @param rowId Identification of one appointment. If the value is -1 then it means that the set data will be a new data. This isn�t in database, yet.
	 */
	public DefaultScheduleManager(long rowId) {
		this.dao = null;
		this.sessionManager = null;
		this.rowId = rowId;
	}
	
	public long save(long doctorId, long patientId, Date appointment, String description, List<String> notes) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean reScheduleAppointment(long userId, Date srcDate, Date targetDate) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Current appointment delete from the data source. If we use this method then we have to create this instance with DefaultScheduleManager(long rowId) constructor.
	 * Otherwise, this method won't work.
	 * 
	 * @return It will return true for success otherwise it will return false.
	 */
	public boolean remove() {
		return remove(rowId);
	}
	
	public boolean remove(long scheduleId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Appointment> getAppointments(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Appointment> getAppointments(long userId, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Check the appointment date that the date is free for user.
	 *
	 * @param userId The user of id whose data we want to be queried.
	 * @param appointment This is a date which we want to control.
	 * @return It will return true then the date is free for user otherwise it will return false.
	 */
	private boolean isEnableAppointment(long userId, Date appointment) {
		return false;
	}

}