package main.java.model;
/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Five Milestone
 * 
 * Description: This is the appointment service class
 */

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	
	private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();  // Holds the added appointments
	
	
	// Adds an appointment to the appointmentList array
	public void newAppointment(Date date, String description) {
		Appointment appointment = new Appointment(date, description);
		appointmentList.add(appointment);
	}
	
	public void displayAppointmentList() {
		for(int i = 0; i < appointmentList.size(); i++) {
			System.out.println("\t Appointment ID: " + appointmentList.get(i).getAppointmentId());
			System.out.println("\t Date: " + appointmentList.get(i).getDate());
			System.out.println("\t Description: " + appointmentList.get(i).getDescription());
		}
	}
	
	// Delete an appointment from the list with the specified appointmentId
	public void deleteAppointment(String appointmentId) {
		appointmentList.remove(findAppointment(appointmentId));
	}
	
	// Finds an appointment within the array by appointmentId
	public Appointment findAppointment(String appointmentId) {
		int index = 0;
		while (index < appointmentList.size()) {
			if (appointmentId.equals(appointmentList.get(index).getAppointmentId())) {
				return appointmentList.get(index);
			}
			index+=1;
		}
		return null;
	}
}
