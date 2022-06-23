package test;
/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Five Milestone
 * 
 * Description: This is the unit test for the appointment class
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.model.Appointment;

class AppointmentTest {

	// Tests for appointment ID
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Appointment ID cannot have more than 10 characters")
	void testAppointmentIdTooLong() {
		Date testDate = new Date();
		testDate.setYear(testDate.getYear() + 1);
		Appointment appointment = new Appointment(testDate, "Description");
		if(appointment.getAppointmentId().length() > 10) {
			fail("Appointment ID has more than 10 characters");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Appointment ID cannot be null")
	void testAppointmentIdNull() {
		Date testDate = new Date();
		testDate.setYear(testDate.getYear() + 1);
		Appointment appointment = new Appointment(testDate, "Description");
		if(appointment.getAppointmentId().length() == 0 || appointment.getAppointmentId() == null) {
			fail("Appointment ID can not be null");
		}
	}
	
	
	// Tests for appointment date
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Appointment Date can not be in the past")
	void testAppointmentDatePast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date testDate = new Date();
			testDate.setYear(testDate.getYear() - 1);
			new Appointment(testDate, "Description");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date testDate = new Date();
			testDate.setYear(testDate.getYear() + 1);
			Appointment test = new Appointment(testDate, "Description");
			testDate.setYear(testDate.getYear() -2);
			test.setDate(testDate);
			});
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Appointment Date cannot be null")
	void testAppointmentDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, "Description");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date testDate = new Date();
			testDate.setYear(testDate.getYear() + 1);
			Appointment test = new Appointment(testDate, "Description");
			test.setDate(null);
			});
	}
	
	
	// Tests for appointment description
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Appointment Description cannot have more than 50 characters")
	void testAppointmentDescriptionTooLong() {
		Date testDate = new Date();
		testDate.setYear(testDate.getYear() + 1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testDate, "Lorem ipsum dolor sit amet, consectetur adipiscings.");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment test = new Appointment(testDate, "Description.");
			test.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscings.");
			});
			
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Appointment Description cannot be null")
	void testAppointmentDescriptionNull() {
		Date testDate = new Date();
		testDate.setYear(testDate.getYear() + 1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(testDate, null);
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment test = new Appointment(testDate, "Description.");
			test.setDescription(null);
			});
	}

	
}
