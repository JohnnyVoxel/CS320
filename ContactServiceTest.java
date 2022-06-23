package test;
/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Three Milestone
 * 
 * Description: This is the unit test for the contact service class
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import main.java.model.ContactService;

import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceTest {

	// Test the update methods
	@Test
	@DisplayName("Test to Update First Name.")
	@Order(1)
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		service.newContact("Shaun", "Ryan", "5551234567", "123 First Street");
		service.updateFirstName("0", "John");
		//service.displayContactList();
		assertEquals("John",service.findContact("0").getFirstName(), "First name was not updated.");
	}
	
	@Test
	@DisplayName("Test to Update Last Name.")
	@Order(2)
	void testUpdateLastName() {
		ContactService service = new ContactService();
		service.newContact("Shaun", "Ryan", "5551234567", "123 First Street");
		service.updateLastName("1", "Smith");
		//service.displayContactList();
		assertEquals("Smith",service.findContact("1").getLastName(), "Last name was not updated.");
	}
	
	@Test
	@DisplayName("Test to Update Phone Number.")
	@Order(3)
	void testUpdatePhone() {
		ContactService service = new ContactService();
		service.newContact("Shaun", "Ryan", "5551234567", "123 First Street");
		service.updatePhone("2", "1239876543");
		//service.displayContactList();
		assertEquals("1239876543",service.findContact("2").getPhone(), "Phone number was not updated.");
	}
	
	@Test
	@DisplayName("Test to Update Address.")
	@Order(4)
	void testUpdateAddress() {
		ContactService service = new ContactService();
		service.newContact("Shaun", "Ryan", "5551234567", "123 First Street");
		service.updateAddress("3", "221B Baker St");
		//service.displayContactList();
		assertEquals("221B Baker St",service.findContact("3").getAddress(), "Address was not updated.");
	}
	
	// Test the delete method
	@Test
	@DisplayName("Test to Delete Contact.")
	@Order(5)
	void testDeleteContact() {
		ContactService service = new ContactService();
		service.newContact("Shaun", "Ryan", "5551234567", "123 First Street");
		service.deleteContact("4");
		//service.displayContactList();
		assertEquals(null,service.findContact("4"), "The contact was not deleted.");
	}
}

