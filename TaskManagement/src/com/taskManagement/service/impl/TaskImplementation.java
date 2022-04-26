package com.taskManagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import com.taskManagement.model.Task;
import com.taskManagement.service.TaskService;

/**
 * Performs create, read, update, delete operations
 * in the task class.
 * 
 * @author Ajith venkadesh.
 * @version 1.0
 *
 */
public class TaskImplementation implements TaskService {
	public static final ArrayList<Task> TASKCOLLECTION = new ArrayList<Task>();
    static final AtomicInteger TASKID = new AtomicInteger(0);
	
	/**
	 * Generates task id automatically and in sequence.
	 * 
	 * @return Id of the task.
	 */
	public int generateTaskId() {
		return TASKID.incrementAndGet();
	}
				
	/**
	 * Creates new task by getting inputs from user.
	 *
	 * @param task Object of task class.
	 * @return Success or failure message.
	 */
	public String create(Task task) {
		TASKCOLLECTION.add(task);
		return "New task create and the task id is :" + task.getTaskId();
	}
	
	/**
	 * Displays all the tasks in the list.
	 */
	public ArrayList<Task> display() {
		return TASKCOLLECTION;
	}
	
	/**
	 * Updates a particular task by using task id.
	 * 
	 * @param taskId Id of the task.
	 * @param taskName Name of the task.
	 * @param taskDescription Description about the task.
	 * @param taskStartDate Start date of the task.
	 * @param taskDueDate Due date of the task.
	 * @param taskStatus Status of the task.
	 */
	public String update(final int id, final String taskName, 
			final String taskDescription, final String taskStatus,
			final Date startDate, final Date dueDate) {
		for (final Task task : TASKCOLLECTION) {
			if (task.getTaskId() == id) {
				if (!taskName.equals("no")) {
					task.setTaskName(taskName);
    			}
								
				if (!taskDescription.equals("no")) {
					task.setTaskDescription(taskDescription);
    			}
								
				if (!taskStatus.equals("")) {
					task.setTaskStatus(taskStatus);
    			}
								
				if (!startDate.equals("no")) {
					task.setTaskStartDate(startDate);
    			}
										
				if (!dueDate.equals("no")) {
					task.setTaskDueDate(dueDate);
    			} 
			} 
			return "Assignee record updated";
		}
		return "Assignee record not updated";
	}
	
	/**
	 * Deletes a particular task by using id.
	 * 
	 * @param id Id of the assignee.
	 * @return Success or failure message.
	 */
	public String delete(final int id) {
		final Iterator<Task> currentTask = TASKCOLLECTION.iterator();
							
		while (currentTask.hasNext()) {
			final Task taskToBeDeleted = currentTask.next();
			
			if (taskToBeDeleted.getTaskId() == id) {
				currentTask.remove();
				return "Task was deleted successfully";
			} 
		}
		return "NO RECORD FOUND";
	}
	
	/**
	 * Searches a particular task by using id.
	 * 
	 * @param id Id of the assignee
	 * @return Details about particular task.
	 */
	public Task search(final int id) {
		for (final Task task : TASKCOLLECTION) {
    		if (task.getTaskId() == id) {
    			return task;
    		} 
		}
    	return null;
    }
	
	/**
	 * Searches task by status.
	 * 
	 * @param status status of the task.
	 */
	public ArrayList<Task> searchTaskByStatus(final String status) {
		final ArrayList<Task> taskList = new ArrayList<Task>();
		
		for (final Task task : TASKCOLLECTION) {
			if (status.equals(task.getTaskStatus())) {
				taskList.add(task);
			}
		}
		return taskList;
	}
}
