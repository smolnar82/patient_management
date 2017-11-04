package hu.kuncystem.patient.pojo.appointment;

import java.util.Date;
import java.util.List;

import hu.kuncystem.patient.pojo.user.User;

public class Appointment {
	private long id;
	private User doctor;
	private User patient;
	private Date time;
	private String description;
	private List<String> notes;
	private long session;

	public Appointment() {}

	public Appointment(long id) {
		setId(id);
	}

	public Appointment(User doctor, User patient, Date time) {
		setDoctor(doctor);
		setPatient(patient);
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public User getPatient() {
		return patient;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTimet() {
		return time;
	}

	public void setDescripton(String text) {
		this.description = text;
	}

	public String getDescription() {
		return description;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setSidid(long id) {
		this.session = id;
	}

	public long getSidid() {
		return session;
	}
}
