/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Five Milestone
 * 
 * Description: This is the appointment class
 */

package main.java.model;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;

public class Appointment {
	private static AtomicLong idGenerator = new AtomicLong();
	private final String appointmentId;
	private String description;
	private Date appointmentDate;
	
	private static final int DESCRIPTION_MAX = 50;
	
	public Appointment(Date appointmentDate, String description) {
		// Appointment ID
		this.appointmentId = String.valueOf(idGenerator.getAndIncrement());
		
		// Date
		Date currentDate = new Date();
		if (appointmentDate == null) {
			throw new IllegalArgumentException("Appointment date can not be null.");
		}
		else if (appointmentDate.before(currentDate)) {
			throw new IllegalArgumentException("Appointment date can not be in the past.");
		}
		else {
			this.appointmentDate = appointmentDate;
		}
		
		// Description
		if (description == null || description.length() == 0) {
			throw new IllegalArgumentException("Appointment description can not be null.");
		}
		else if (description.length() > DESCRIPTION_MAX) {
			//this.description = description.substring(0, DESCRIPTION_MAX);
			throw new IllegalArgumentException("Appointment description can not be longer than " + DESCRIPTION_MAX + " characters.");
		}
		else {
			this.description = description;
		}
	}
	
	// Get methods
	public String getAppointmentId() {
		return appointmentId;
	}
	public Date getDate() {
		return appointmentDate;
	}
	public String getDescription() {
		return description;
	}
	
	// Set methods
	public void setDate(Date date) {
		Date currentDate = new Date();
		if (date == null) {
			throw new IllegalArgumentException("Appointment date can not be null.");
		}
		else if (date.before(currentDate)) {
			throw new IllegalArgumentException("Appointment date can not be in the past.");
		}
		else {
			this.appointmentDate = date;
		}
	}
	public void setDescription(String description) {
		if (description == null || description.length() == 0) {
			throw new IllegalArgumentException("Appointment description can not be null.");
		}
		else if (description.length() > DESCRIPTION_MAX) {
			throw new IllegalArgumentException("Appointment description can not have more than 50 characters.");
		}
		else {
			this.description = description;
		}
	}
}
