package test;
/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Five Milestone
 * 
 * Description: This is the unit test for the appointment service class
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import main.java.model.AppointmentService;

class AppointmentServiceTest {

	// Test the add appointment method
	@SuppressWarnings("deprecation")
	@Test
	@Order(2)
	@DisplayName("Test adding a new appointment.")
	void testNewAppointment() {
		Date testDate = new Date();
		testDate.setYear(testDate.getYear() + 1);
		AppointmentService service = new AppointmentService();
		service.newAppointment(testDate, "New Appointment.");
		service.displayAppointmentList();
		assertNotNull(service.findAppointment("1"), "Appointment was not created.");
	}
	
	// Test the delete method
	@SuppressWarnings("deprecation")
	@Test
	@Order(1)
	@DisplayName("Test to Delete appointment.")
	void testDeleteAppointment() {
		Date testDate = new Date();
		testDate.setYear(testDate.getYear() + 1);
		AppointmentService service2 = new AppointmentService();
		service2.newAppointment(testDate, "Appointment to be deleted.");
		service2.displayAppointmentList();
		service2.deleteAppointment("0");
		//service2.displayAppointmentList();
		assertEquals(null,service2.findAppointment("0"), "The appointment was not deleted.");
	}
	
}
