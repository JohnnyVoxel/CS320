package test;
/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Four Milestone
 * 
 * Description: This is the unit test for the task service class
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import main.java.model.TaskService;

import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class TaskServiceTest {

	// Test the add task method
	@Test
	@DisplayName("Test adding a new task.")
	@Order(1)
	void testNewTask() {
		TaskService service = new TaskService();
		service.newTask("Task Name", "Description of task.");
		//service.displayTaskList();
		assertNotNull(service.findTask("0"), "Task was not created.");
	}
	
	// Test the update method for task name
	@Test
	@DisplayName("Test to Update Task Name.")
	@Order(2)
	void testUpdateName() {
		TaskService service = new TaskService();
		service.newTask("Task Name", "Description of task.");
		service.updateName("1", "New Name for Task");
		//service.displayTaskList();
		assertEquals("New Name for Task",service.findTask("1").getName(), "Task name was not updated.");
	}
	
	// Test the update method for task description
	@Test
	@DisplayName("Test to Update Task Description.")
	@Order(3)
	void testUpdateDescription() {
		TaskService service = new TaskService();
		service.newTask("Task Name", "Description of the task.");
		service.updateDescription("2", "Some other description.");
		//service.displayTaskList();
		assertEquals("Some other description.",service.findTask("2").getDescription(), "Task Description was not updated.");
	}
	
	// Test the delete method
	@Test
	@DisplayName("Test to Delete task.")
	@Order(4)
	void testDeleteTask() {
		TaskService service = new TaskService();
		service.newTask("New Task", "Description of new task.");
		service.deleteTask("3");
		//service.displayTaskList();
		assertEquals(null,service.findTask("3"), "The task was not deleted.");
	}
}

