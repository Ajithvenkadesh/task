package com.taskManagement.service.implVersion2;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.taskManagement.dao.TaskDao;
import com.taskManagement.model.Task;
import com.taskManagement.service.TaskService;

/**
 * Implements the methods of assignee service.
 * 
 * @author Ajithvenkadesh
 * @version 1.0
 */
public class TaskImplementation implements TaskService {
    final TaskDao TASK = new TaskDao();
	
    /**
     * Calls the create new task method in task dao class.
     * 
     * @param Object of task.
     * @return Success or failure message.
     */
	public String create(final Task newTask) {
		return TASK.createTask(newTask.getTaskId(), newTask.getTaskName(), newTask.getTaskDescription(), 
				newTask.getTaskStatus(), newTask.getTaskStartDate(), newTask.getTaskDueDate());
	}
	
	/**
	 * Displays all task.
	 * 
	 * @return List of tasks.
	 */
	public ArrayList<Task> display() {
		return TASK.dispalay();
	}
	
	/**
	 * Deletes a particular task.
	 * 
	 * @param Id of the task.
	 * @return Success or failure message.
	 */
	public String delete(final int id) {
		return TASK.delete(id);
	}
	
	/**
	 * Creates new task.
	 * 
	 * @param id Id of the task.
	 * @param name Name of the task.
	 * @param description Description about the task.
	 * @param status Status of the task.
	 * @param taskStartDate Start date of the task.
	 * @param taskDueDate Due date of the task.
	 * @return Success or failure message.
	 */
	public String update(final int taskId, final String taskName,
			final String taskDescription, final String taskStatus, 
			final Date taskStartDate, final Date taskDueDate) {
		return TASK.update(taskId, taskName, taskDescription, taskStatus, taskStartDate, 
				taskDueDate);
	}
	
	/**
	 * Searches a particular task.
	 * 
	 * @param id Id of the task.
	 * @return Object of task.
	 */
	public Task search(final int id) {
		return TASK.search(id);
	}
	
	/**
	 * Searches task by status.
	 * 
	 * @param taskStatus Status of task.
	 * @return List of tasks.
	 */
	public ArrayList<Task> searchTaskByStatus(final String taskStatus) {
		return TASK.searchTaskByStatus(taskStatus);
	}
    
	/**
	 * Generates date from string format.
	 * 
	 * @param intermediateDate Date in string format.
	 * @return Date .
	 */
	public Date formatDate(final String intermediateDate) {
		Date date = null;
		
		try {
		    final SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			date = formatDate.parse(intermediateDate);
		} catch (ParseException e) {
			System.out.println ("You have entered wrong date format enter date in dd/mm/yyyy format");
		}
		return date;
	}
}
