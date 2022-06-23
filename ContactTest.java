package test;
/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Three Milestone
 * 
 * Description: This is the unit test for the contact class
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

class ContactTest {

	// Tests for values being longer than constraints
	@Test
	@DisplayName("Contact ID cannot have more than 10 characters")
	void testContactIdWithMoreThanTenCharacters() {
		
		Contact contact = new Contact("FirstName", "LastName", "1234567890", "Address");
		if(contact.getContactId().length() > 10) {
			fail("Contact ID has more than 10 characters");
		}
	}
	
	@Test
	@DisplayName("Contact First Name cannot have more than 10 characters")
	void testContactFirstNameWithMoreThanTenCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstNameLong", "LastName", "1234567890", "Address");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact test = new Contact("FirstName", "LastName", "1234567890", "Address");
			test.setFirstName("FirstNameLong");
			});
	}
	
	@Test
	@DisplayName("Contact Last Name cannot have more than 10 characters")
	void testContactLastNameWithMoreThanTenCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastNameLong", "1234567890", "Address");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact test = new Contact("FirstName", "LastName", "1234567890", "Address");
			test.setLastName("LastNameLong");
			});
	}
	
	@Test
	@DisplayName("Contact Phone Number must have exactly 10 characters")
	void testContactPhoneWithoutTenCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", "12345678901", "Address");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact test = new Contact("FirstName", "LastName", "1234567890", "Address");
			test.setPhone("12345678901");
			});
	}
	
	@Test
	@DisplayName("Contact Address cannot have more than 30 characters")
	void testContactAddressWithMoreThanThirtyCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", "1234567890", "Lorem ipsum dolor sit amet cons");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact test = new Contact("FirstName", "LastName", "1234567890", "Address");
			test.setAddress("Lorem ipsum dolor sit amet cons");
			});
	}
	
	// Tests for values being NULL
	@Test
	@DisplayName("Contact First Name cannot be null")
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "LastName", "1234567890", "Address");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact test = new Contact("FirstName", "LastName", "1234567890", "Address");
			test.setFirstName(null);
			});
	}
	
	@Test
	@DisplayName("Contact Last Name cannot be null")
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", null, "1234567890", "Address");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact test = new Contact("FirstName", "LastName", "1234567890", "Address");
			test.setLastName(null);
			});
	}
	
	@Test
	@DisplayName("Contact Phone Number cannot be null")
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", null, "Address");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact test = new Contact("FirstName", "LastName", "1234567890", "Address");
			test.setPhone(null);
			});
	}
	
	@Test
	@DisplayName("Contact Address cannot be null")
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FirstName", "LastName", "1234567890", null);
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact test = new Contact("FirstName", "LastName", "1234567890", "Address");
			test.setAddress(null);
			});
	}

}
