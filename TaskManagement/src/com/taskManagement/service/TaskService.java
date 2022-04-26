package com.taskManagement.service;

import java.util.ArrayList;
import java.util.Date;
import com.taskManagement.model.Task;

/**
 * Lists the services available for task.
 * 
 * @author Ajith venkadesh
 * @version 1.0
 */
public interface TaskService {
	
	/**
	 * Creates new task by getting inputs from user.
	 *
	 * @param task Object of task class.
	 * @return Success or failure message.
	 */
	public String create(final Task task);
	
	/**
	 * Displays all the tasks in the list.
	 * 
	 * @return List of available tasks.
	 */
	public ArrayList<Task> display();
	
	/**
	 * Updates a particular task by using task id.
	 * 
	 * @param id Id of the task.
	 * @param taskName New task name.
	 * @param taskDescription New task description.
	 * @param taskStatus New task status.
	 * @param startDate New task start date.
	 * @param dueDate New task due date.
	 * @return Success or failure message.
	 */
	public String update(final int id, final String taskName, 
			final String taskDescription, final String taskStatus,
			final Date startDate, final Date dueDate);
	
	/**
	 * Deletes a particular task by using id.
	 * 
	 * @param id Id of the task.
	 * @return Success or failure message.
	 */
	public String delete(final int id);
	
	/**
	 * Searches a particular task by using id.
	 * 
	 * @param id Id of the task. 
	 * @return Object of task class.
	 */
	public Task search(final int id);
	
	/**
	 * Searches task by status.
	 * 
	 * @param taskStatus status of task.
	 * @return List of tasks.
	 */
	public ArrayList<Task> searchTaskByStatus(final String taskStatus);
}
