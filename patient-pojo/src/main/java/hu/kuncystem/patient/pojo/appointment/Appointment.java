package hu.kuncystem.patient.pojo.appointment;

import java.util.Date;
import java.util.List;

import hu.kuncystem.patient.pojo.user.User;

/**
 * This object is a simple POJO containing get/set methods. This object is going
 * to work as a Model.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 7.
 * 
 * @version 1.0
 */

public class Appointment {
    // Identification of one appointment
    private long id;
    // Object.User who is a doctor
    private User doctor;
    // Object.User who is a patient
    private User patient;
    // Date of appointment
    private Date time;
    // The meeting details
    private String description;
    // Short tags of appointment
    private List<String> notes;
    // Identification of a user process
    private long session;

    /**
     * This class will pass information to appointment dao object to get the
     * data it needs.
     *
     */
    public Appointment() {
    }

    /**
     * This class will pass information to appointment dao object to get the
     * data it needs.
     *
     * @param id
     *            Identification of one appointment. If the value is -1 then it
     *            means that the set data will be a new data. This isn�t in
     *            database, yet.
     */
    public Appointment(long id) {
        setId(id);
    }

    /**
     * This class will pass information to appointment dao object to get the
     * data it needs.
     *
     * @param doctor
     *            Object.User is a simple POJO object. This object contains the
     *            data of the doctor.
     * @param patient
     *            Object.User is a simple POJO object. This object contains the
     *            data of the patient.
     * @param time
     *            Date of appointment when the user will meet her/his doctor.
     */
    public Appointment(User doctor, User patient, Date time) {
        setDoctor(doctor);
        setPatient(patient);
        setTime(time);
    }

    /**
     * Get information of appointment.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get Object.User which contains data of a doctor.
     */
    public User getDoctor() {
        return doctor;
    }

    /**
     * Get identification of one appointment.
     *
     * @return long unique row id.
     */
    public long getId() {
        return id;
    }

    /**
     * Get all short descriptions.
     */
    public List<String> getNotes() {
        return notes;
    }

    /**
     * Get Object.User which contains data of a patient.
     */
    public User getPatient() {
        return patient;
    }

    /**
     * Get current session id
     */
    public long getSidid() {
        return session;
    }

    /**
     * Get the date of appointment.
     */
    public Date getTimet() {
        return time;
    }

    /**
     * Long detail text. This text contains a lot of information for meeting.
     *
     * @param text
     *            The meeting details.
     */
    public void setDescripton(String text) {
        this.description = text;
    }

    /**
     * Set Object.User who is a doctor.
     *
     * @param doctor
     *            Object.User object.
     */
    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    /**
     * Set new identification.
     * 
     * @param id
     *            Identification of one appointment. If the value is -1 then it
     *            means that the set data will be a new data. This isn't in
     *            database, yet.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Add short descriptions to appointment.
     *
     * @param notes
     *            Object.List object. This list contains short texts. Typically,
     *            these are one-one words.
     */
    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    /**
     * Set Object.User who is a patient.
     *
     * @param patient
     *            Object.User object.
     */
    public void setPatient(User patient) {
        this.patient = patient;
    }

    /**
     * Set current user process id.
     *
     * @param id
     *            Current session id.
     */
    public void setSidid(long id) {
        this.session = id;
    }

    /**
     * Date of appointment when the user will meet her/his doctor.
     *
     * @param time
     *            Normal Date object.
     */
    public void setTime(Date time) {
        this.time = time;
    }
}
