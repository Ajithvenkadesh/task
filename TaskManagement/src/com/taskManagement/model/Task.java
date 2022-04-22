package com.taskManagement.model;

import java.util.Date;

/**
 * Template for task .
 * 
 * @author Ajith venkadesh
 * @version 1.0 
 */
public class Task {
	private int taskId;
	private String taskName;
	private String taskDescription;
	private Date taskStartDate;
	private Date taskDueDate;
	private String taskStatus;
		
	/**
	 * Sets values of the instance variables.
	 * 
	 * @param taskId id of the task
	 * @param taskName name of the task
	 * @param taskDescription description of the task
	 * @param taskStartDate start date of the task
	 * @param taskDueDate due date of the task
	 * @param taskStatus current status of the task 
	 */
	public Task(final int taskId, final String taskName, final String taskDescription, 
			final Date taskStartDate, final Date taskDueDate, final String taskStatus) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskStartDate = taskStartDate;
		this.taskDueDate = taskDueDate;
		this.taskStatus = taskStatus;
	}
	
	/**
	 * Returns the id of the task.
	 * 
	 * @return id of the task.
	 */
	public int getTaskId() {
		return taskId;
	}
	
	/**
	 * Sets the id of the task.
	 * 
	 * @param taskId The id of the task to be added.
	 */
	public void setTaskId(final int taskId) {
		this.taskId = taskId;
	}
	
	/**
	 * Returns the name of the task.
	 * 
	 * @return name of the task.
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * Sets the task name.
	 * 
	 * @param taskName The name of the task to be added.
	 */
	public void setTaskName(final String taskName) {
		this.taskName = taskName;
	}
	
	/**
	 * Returns the description of the task.
	 * 
	 * @return description about the task.
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	
	/**
	 * Sets the task description.
	 * 
	 * @param taskDescription The description of the task to be added.
	 */
	public void setTaskDescription(final String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	/**
	 * Returns the start date of the task.
	 * 
	 * @return Start date of the task.
	 */
	public Date getTaskStartDate() {
		return taskStartDate;
	}
	
	/**
	 * Sets the start date of the task.
	 * 
	 * @param taskStartDate The start date of the task.
	 */
	public void setTaskStartDate(final Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	
	/**
	 * Returns the end date of the task.
	 * 
	 * @return due date of the task.
	 */
	public Date getTaskDueDate() {
		return taskDueDate;
	}
	
	/**
	 * Sets the end date for the task.
	 * 
	 * @param taskDueDate The last date to complete the task. 
	 */
	public void setTaskDueDate(final Date taskDueDate) {
		this.taskDueDate = taskDueDate;
	}
	
	/**
	 * Returns the status of the task.
	 * 
	 * @return current status of the task.
	 */
	public String getTaskStatus() {
		return taskStatus;
	}
	
	/**
	 * Sets the status of the task.
	 * 
	 * @param taskStatus The current status of the task.
	 */
	public void setTaskStatus(final String taskStatus) {
		this.taskStatus = taskStatus;
	}
}
