package test;
/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Four Milestone
 * 
 * Description: This is the unit test for the task class
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.model.Task;

import org.junit.jupiter.api.DisplayName;

class TaskTest {

	@Test
	@DisplayName("Test creation of legal task")
	void testOneTask() {
		Task task = new Task("Name", "Description");
		assertTrue(task.getName().equals("Name"));
		assertTrue(task.getDescription().equals("Description"));
	}
	
	// Tests for values being longer than constraints
	@Test
	@DisplayName("Task ID cannot have more than 10 characters")
	void testTaskIdTooLong() {
		Task task = new Task("Name", "Description");
		if(task.getTaskId().length() > 10) {
			fail("Task ID has more than 10 characters");
		}
	}
	
	@Test
	@DisplayName("Task Name cannot have more than 20 characters")
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Lorem ipsum dolor sit", "Description");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task test = new Task("Name", "Description");
			test.setName("This Long Name Is Too Long");
			});
	}
	
	@Test
	@DisplayName("Task Description cannot have more than 50 characters")
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Name", "Lorem ipsum dolor sit amet, consectetur adipiscingd");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task test = new Task("Name", "Description");
			test.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscingd");
			});
	}
	
	// Tests for values being NULL
	@Test
	@DisplayName("Task Name cannot be null")
	void testTaskNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Description");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task test = new Task("Name", "Description");
			test.setName(null);
			});
		
	}
	
	@Test
	@DisplayName("Task Description cannot be null")
	void testTaskDescriptionIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("Name", null);
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task test = new Task("Name", "Description");
			test.setDescription(null);
			});
	}
}
