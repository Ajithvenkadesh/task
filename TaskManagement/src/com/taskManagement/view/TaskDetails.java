package com.taskManagement.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import com.taskManagement.exception.InvalidDescriptionException;
import com.taskManagement.model.Task;

/**
 * Gets details about the task from the user like
 * task id, task name,task description,task status,
 * task start date, task due date and also it generates
 * date from from string format .
 *  
 * @author Ajith venkadesh.
 * @version 1.0
 */
public class TaskDetails {
	private enum TaskStatus {
		Under_progress, Under_review, Completed;
	}
		
	/**
	 * Gets the task id from the user for delete,
	 * update, search operations.
	 * 
	 * @return id of the task.
	 * @throws InputMismatchException when invalid input is entered.
	 */
	public int getTaskId() {
		int taskId = 0 ;
		
		try {
			MenuLauncher.LOGGER.info("Enter task id : ");
		    taskId = MenuLauncher.INPUT.nextInt();
		    MenuLauncher.INPUT.nextLine();
		} catch (InputMismatchException exception) {
			MenuLauncher.LOGGER.warning("Only integer value is accepted");
			getTaskId();
		}
		return taskId;
	}
	
	/**
	 * Gets the task name from the user.
	 * 
	 * @return Name of the task.
	 */
	public String getTaskName() {
		MenuLauncher.LOGGER.info("Enter task Name : ");
		return MenuLauncher.INPUT.nextLine();
	}
	
	/**
	 * Gets the task description from the user.
	 * 
	 * @return Description about the task.
	 */
	String getTaskDescription() {
		MenuLauncher.LOGGER.info("Enter the task description :");
		final String taskDescription = MenuLauncher.INPUT.nextLine();
		
		try {
		    if (taskDescription.length() < 10) {
			throw new InvalidDescriptionException("Too short description enter valid description");
		    }
		} catch (InvalidDescriptionException exception) {
			getTaskDescription();
		}
		return taskDescription;
	}
	
	/**
	 * Gets the status of the task from the user.
	 * 
	 * @return status of the task.
	 * @throws InputMismatchException when invalid input is entered.
	 * @throws ArrayIndexOutOfBoundsException when wrong index is entered.
	 */
	String getTaskStatus() {
		int index = 0;
		
		MenuLauncher.LOGGER.info("The list of status avaialable are : ");
		
		for (TaskStatus status : TaskStatus.values()) {
			MenuLauncher.LOGGER.info("ENTER  " + status.ordinal() + "  for   " + status);
		}
		
		try {
			MenuLauncher.LOGGER.info("Enter the value ");
		    index = MenuLauncher.INPUT.nextInt();
		    MenuLauncher.INPUT.nextLine();
		} catch (InputMismatchException exception) {
			MenuLauncher.LOGGER.warning("Enter only integer value");
			index = MenuLauncher.INPUT.nextInt();
		    MenuLauncher.INPUT.nextLine();
		}
		
    	try {
		    return TaskStatus.values()[index].toString();
		} catch (ArrayIndexOutOfBoundsException exception) {
			getTaskStatus();
		}
		return null;
	}
	
	/**
	 * Gets the due date from the user in string format.
	 * 
	 * @return Date in string format.
	 */
	public String getDueDate() {
		MenuLauncher.LOGGER.info(" Enter Task Due Date : ");
	    return MenuLauncher.INPUT.nextLine();
	}
	
	/**
	 *  Gets the start date of the task from the user in string format.
	 *  
	 * @return Start date of the task. 
	 */
	public String getStartDate() {
		MenuLauncher.LOGGER.info(" Enter task start Date : ");
	    return MenuLauncher.INPUT.nextLine();
	}

	/**
	 * Prints the message.
	 * 
	 * @param message Message to be printed.
	 */
	public void printMessage(final String message) {
		MenuLauncher.LOGGER.info(message);
	}
	
	/**
	 * Gets the id of the assignee from the user
	 * for searching the tasks assigned to him.
	 * 
	 * @return id of the assignee.
	 */
	int getAssigneeId() {
		int assigneeId = 0;
		
		try {
		    MenuLauncher.LOGGER.info("Enter the assignee id :");
		    assigneeId = MenuLauncher.INPUT.nextInt();
		    MenuLauncher.INPUT.nextLine();
		} catch (InputMismatchException exception) {
			MenuLauncher.LOGGER.warning("Enter only integer value");
			getAssigneeId();
		}
		return assigneeId;
	}
	
	/**
	 * Gets the list of task id from the user.
	 * 
	 * @return list of task id.
	 */
	int[] getListOfTaskId() {
		MenuLauncher.LOGGER.info("Enter the total number of tasks");
		int[] taskIdList = new int[ MenuLauncher.INPUT.nextInt()];
		MenuLauncher.INPUT.nextLine();
		
		for (int initialValue = 0; initialValue < taskIdList.length; initialValue++) {
			MenuLauncher.LOGGER.info("Enter the task id");
			taskIdList [initialValue] = MenuLauncher.INPUT.nextInt();
			MenuLauncher.INPUT.nextLine();			
		}
		return taskIdList;
	}
	
	/**
	 * Prints the details of task.
	 * 
	 * @param task Object of task class.
	 * @throws NullPointerException when no task record found.
	 */
	void printDetails(final Task task) {
		if (task == null) {
			MenuLauncher.LOGGER.warning("No task found");
		} else {
		MenuLauncher.LOGGER.info("Task details");
		MenuLauncher.LOGGER.info("Task id : " + task.getTaskId());
		MenuLauncher.LOGGER.info("Task name : " + task.getTaskName());
		MenuLauncher.LOGGER.info("Task description : " + task.getTaskDescription());
		MenuLauncher.LOGGER.info("Task start date : " + task.getTaskStartDate());
		MenuLauncher.LOGGER.info("Task due date : " + task.getTaskDueDate());
		MenuLauncher.LOGGER.info("Task status : " + task.getTaskStatus());
		}
	}
	
	/**
	 * Prints all the available task.
	 * 
	 * @param taskCollection List of all available tasks.
	 */
	void printAllTask(final ArrayList<Task> taskCollection) {
		if (taskCollection.isEmpty()) {
			MenuLauncher.LOGGER.warning("No task found");
		} else {
		    for (final Task task : taskCollection) {
		    	MenuLauncher.LOGGER.info("Task details");
		    	MenuLauncher.LOGGER.info("task id : " + task.getTaskId());
		    	MenuLauncher.LOGGER.info("Task name is : " + task.getTaskName());
		    	MenuLauncher.LOGGER.info("Task Description is : " + task.getTaskDescription());
		    	MenuLauncher.LOGGER.info("Task start date is : " + task.getTaskStartDate());
		    	MenuLauncher.LOGGER.info("Task due date is : " + task.getTaskDueDate());
		    	MenuLauncher.LOGGER.info("Task status is : " + task.getTaskStatus());
		    }
		}
	}
}
