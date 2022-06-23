/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Four Milestone
 * 
 * Description: This is the task class
 */
package main.java.model;
import java.util.concurrent.atomic.AtomicLong;

public class Task {
	private static AtomicLong idGenerator = new AtomicLong();
	private final String taskId;
	private String name;
	private String description;
	
	private static final int NAME_MAX = 20;
	private static final int DESCRIPTION_MAX = 50;
	
	public Task(String name, String description) {
		// Task ID
		this.taskId = String.valueOf(idGenerator.getAndIncrement());
		
		// Name
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Task name can not be null.");
		}
		else if (name.length() > NAME_MAX) {
			//this.name = name.substring(0, NAME_MAX);
			throw new IllegalArgumentException("Task name can not be longer than " + NAME_MAX + " characters.");
		}
		else {
			this.name = name;
		}
		
		// Description
		if (description == null || description.length() == 0) {
			throw new IllegalArgumentException("Task description can not be null.");
		}
		else if (description.length() > DESCRIPTION_MAX) {
			throw new IllegalArgumentException("Task description can not be longer than " + DESCRIPTION_MAX + " characters.");
		}
		else {
			this.description = description;
		}
	}
	
	// Get methods
	public String getTaskId() {
		return taskId;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	// Set methods
	public void setName(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Task name can not be null.");
		}
		else if (name.length() > NAME_MAX) {
			throw new IllegalArgumentException("Task name can not be longer than " + NAME_MAX + " characters.");
		}
		else {
			this.name = name;
		}
	}
	public void setDescription(String description) {
		if (description == null || description.length() == 0) {
			throw new IllegalArgumentException("Task description can not be null.");
		}
		else if (description.length() > DESCRIPTION_MAX) {
			throw new IllegalArgumentException("Task description can not be longer than " + DESCRIPTION_MAX + " characters.");
		}
		else {
			this.description = description;
		}
	}
}
