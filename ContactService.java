package main.java.model;
/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Three Milestone
 * 
 * Description: This is the contact service class
 */

import java.util.ArrayList;

public class ContactService {
	
	private ArrayList<Contact> contactList = new ArrayList<Contact>();  // Holds the added contacts
	
	
	// Adds a contact to the contactList array
	public void newContact(String firstName, String lastName, String phone, String address) {
		Contact contact = new Contact(firstName, lastName, phone, address);
		contactList.add(contact);
	}
	
	// Methods to update contact fields
	// Requires the contactId of the contact to update
	public void updateFirstName(String contactId, String firstName) {
		findContact(contactId).setFirstName(firstName);
	}
	public void updateLastName(String contactId, String lastName) {
		findContact(contactId).setLastName(lastName);
	}
	public void updatePhone(String contactId, String phone) {
		findContact(contactId).setPhone(phone);
	}
	public void updateAddress(String contactId, String address) {
		findContact(contactId).setAddress(address);
	}
	
	// Delete a contact from the list with the specified contactId
	public void deleteContact(String contactId) {
		contactList.remove(findContact(contactId));
	}
	
	// Finds a contact within the array by contactId
	public Contact findContact(String contactId) {
		int index = 0;
		while (index < contactList.size()) {
			if (contactId.equals(contactList.get(index).getContactId())) {
				return contactList.get(index);
			}
		}
		return null;
	}
}
