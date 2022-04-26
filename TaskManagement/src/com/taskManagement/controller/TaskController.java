package com.taskManagement.controller;

import java.util.ArrayList;
import java.util.Date;
import com.taskManagement.model.Task;
import com.taskManagement.service.TaskService;
import com.taskManagement.service.implVersion2.TaskImplementation;

/**
 * Used to invoke the methods of Task implementation class.
 * 
 * @author Ajith venkadesh
 * @version 1.0
 */
public class TaskController {
	final TaskService TASK = new TaskImplementation();
		
	/**
	 * Calls the create task method from
	 * task implementation method.
	 * 
	 * @param newTask Object of task class.
	 * @return Success or failure message.
	 */
	public String createTask(final Task newTask) {
		return TASK.create(newTask);
	}
	
	/**
	 * Calls the display task method from
	 * task implementation method.
	 * 
	 * @return List of available tasks.
	 */
	public ArrayList<Task> displayTask() {
		return TASK.display();
	}
	
	/**
	 * Calls the delete task method from 
	 * task implementation method.
	 * 
	 * @param id Id of the task.
	 * @return Success or failure message.
	 */
	public String deleteTask(final int id) {
		return TASK.delete(id);
	}
	
	/**
	 * Calls the update task method from
	 * task implementation method.
	 * 
	 * @param taskId Id of the task to be updated.
	 * @param taskName New task name.
	 * @param taskDescription New task description.
	 * @param taskStatus New task status.
	 * @param taskStartDate New start date of the task.
	 * @param taskDueDate New due date of the task.
	 * @return Success or failure message.
	 */
	public String updateTask(final int taskId, final String taskName,
			final String taskDescription, final String taskStatus, 
			final Date taskStartDate, final Date taskDueDate) {
		return TASK.update(taskId, taskName, taskDescription, taskStatus, 
				taskStartDate, taskDueDate);
	}
	
	/**
	 * Calls the search particular task method from the
	 * task implementation method.
	 * 
	 * @param id Id of the task to be searched.
	 * @return Required task.
	 */
	public Task searchParticularTask(final int id) {
		return TASK.search(id);
	}
	
	/**
	 * Calls the search task by status method from
	 * task implementation method.
	 * 
	 * @param taskStatus Status of the task.
	 * @return list of tasks.
	 */
	public ArrayList<Task> searchTaskByStatus(final String taskStatus) {
		return TASK.searchTaskByStatus(taskStatus);
	}
}
