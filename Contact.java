package main.java.model;
/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Three Milestone
 * 
 * Description: This is the contact class
 */
import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	private static AtomicLong idGenerator = new AtomicLong();
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	private static final int FIRST_NAME_MAX = 10;
	private static final int LAST_NAME_MAX = 10;
	private static final int PHONE_REQ = 10;
	private static final int ADDRESS_MAX = 30;
	
	public Contact(String firstName, String lastName, String phone, String address) {
		// Contact ID
		this.contactId = String.valueOf(idGenerator.getAndIncrement());
		
		// First Name
		if (firstName == null || firstName.length() == 0) {
			throw new IllegalArgumentException("First name can not be null.");
		}
		else if (firstName.length() > FIRST_NAME_MAX) {
			throw new IllegalArgumentException("First name can not have more than 10 characters.");
		}
		else {
			this.firstName = firstName;
		}
		
		// Last Name
		if (lastName == null || lastName.length() == 0) {
			throw new IllegalArgumentException("Last name can not be null.");
		}
		else if (lastName.length() > LAST_NAME_MAX) {
			throw new IllegalArgumentException("Last name can not have more than 10 characters.");
		}
		else {
			this.lastName = lastName;
		}
		
		// Phone Number
		if (phone == null || phone.length() != PHONE_REQ) {
			throw new IllegalArgumentException("Phone number must be ten digits.");
		}
		else {
			this.phone = phone;
		}
		
		// Address
		if (address == null || address.length() == 0) {
			throw new IllegalArgumentException("Address can not be null.");
		}
		else if (address.length() > ADDRESS_MAX) {
			throw new IllegalArgumentException("Address can not have more than 30 characters.");
		}
		else {
			this.address = address;
		}
	}
	
	// Get methods
	public String getContactId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	// Set methods
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() == 0) {
			throw new IllegalArgumentException("First name can not be null.");
		}
		else if (firstName.length() > FIRST_NAME_MAX) {
			throw new IllegalArgumentException("First name can not have more than 10 characters.");
		}
		else {
			this.firstName = firstName;
		}
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() == 0) {
			throw new IllegalArgumentException("Last name can not be null.");
		}
		else if (lastName.length() > LAST_NAME_MAX) {
			throw new IllegalArgumentException("Last name can not have more than 10 characters.");
		}
		else {
			this.lastName = lastName;
		}
	}
	public void setPhone(String phone) {
		if (phone == null || phone.length() == 0 || phone.length() != PHONE_REQ) {
			throw new IllegalArgumentException("Phone number not 10 digits.");
		}
		else {
			this.phone = phone;
		}
	}
	public void setAddress(String address) {
		if (address == null || address.length() == 0) {
			throw new IllegalArgumentException("Address can not be null.");
		}
		else if (address.length() > ADDRESS_MAX) {
			throw new IllegalArgumentException("Address can have more than 30 characters.");
		}
		else {
			this.address = address;
		}
	}
}
