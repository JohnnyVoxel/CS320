/*
 * Shaun Ryan
 * CS-320
 * 22EW5
 * Dr. Cross
 * Module Four Milestone
 * 
 * Description: This is the task service class
 */
package main.java.model;
import java.util.ArrayList;

public class TaskService {
	
	private ArrayList<Task> taskList = new ArrayList<Task>();  // Holds the added tasks
	
	
	// Adds a task to the taskList array
	public void newTask(String name, String description) {
		Task task = new Task(name, description);
		taskList.add(task);
	}
	
	// Methods to update task fields
	// Requires the taskId of the task to update
	public void updateName(String taskId, String name) {
		findTask(taskId).setName(name);
	}
	public void updateDescription(String taskId, String description) {
		findTask(taskId).setDescription(description);
	}
	
	// Delete a task from the list with the specified taskId
	public void deleteTask(String taskId) {
		taskList.remove(findTask(taskId));
	}
	
	// Finds a task within the array by taskId
	public Task findTask(String taskId) {
		int index = 0;
		while (index < taskList.size()) {
			if (taskId.equals(taskList.get(index).getTaskId())) {
				return taskList.get(index);
			}
		}
		return null;
	}
}
