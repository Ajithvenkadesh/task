package com.taskManagement.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import com.taskManagement.exception.InvalidDescriptionException;
import com.taskManagement.exception.InvalidStatusException;
import com.taskManagement.model.Task;

/**
 * Gets details about the task from the user like
 * task id, task name,task description,task status,
 * task start date, task due date and also it generates
 * date from from string format and also it generates
 * the task id automatically.
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
		int taskId = 0;
		
		try {
		    System.out.println ("Enter task id : ");
		    taskId = MenuLauncher.input.nextInt();
		    MenuLauncher.input.nextLine();
		} catch (InputMismatchException exception) {
			System.out.println ("Only integer value is accepted");
		}
		return taskId;
	}
	
	/**
	 * Gets the task name from the user.
	 * 
	 * @return Name of the task.
	 */
	public String getTaskName() {
		final String taskName;
						
		System.out.println ("Enter task Name : ");
		taskName = MenuLauncher.input.nextLine();
		return taskName;
	}
	
	/**
	 * Gets the task description from the user.
	 * 
	 * @return Description about the task.
	 */
	String getTaskDescription() {
		final String taskDescription;
		
		System.out.println ("Enter the task description :");
		taskDescription = MenuLauncher.input.nextLine();
		
		try {
		    if (taskDescription.length() < 2) {
			throw new InvalidDescriptionException("Too short description enter valid description");
		    }
		} catch (InvalidDescriptionException exception) {
			System.out.println (exception);
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
		
		System.out.println("The list of status avaialable are : ");
		
		for (TaskStatus status : TaskStatus.values()) {
			System.out.println ("ENTER  " + status.ordinal() + "  for   " + status);
		}
		
		try {
		    System.out.println ("Enter the value ");
		    index = MenuLauncher.input.nextInt();
		    MenuLauncher.input.nextLine();
		} catch (InputMismatchException exception) {
			System.out.println ("Enter only integer value");
		}
		
		try {
			if (index > 2) {
				throw new InvalidStatusException("No status found for the corrosponding number");
			}
		} catch (InvalidStatusException exception) {
			System.out.println (exception);
		}
		
		try {
		    return TaskStatus.values()[index].toString();
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println ("Enter only the listed value");
		}
		return null;
	}
	
	/**
	 * Gets the due date from the user in string format.
	 * 
	 * @return Date in string format.
	 */
	public String getDueDate() {
		final String dueDate;
				
		System.out.println (" Enter Task Due Date : ");
	    dueDate = MenuLauncher.input.nextLine();
	    return dueDate;
	}
	
	/**
	 *  Gets the start date of the task from the user in string format.
	 *  
	 * @return Start date of the task. 
	 */
	public String getStartDate() {
		final String startDate;
				
		System.out.println (" Enter task start Date : ");
	    startDate = MenuLauncher.input.nextLine();
	    return startDate;
	}

	/**
	 * Prints the message.
	 * 
	 * @param message Message to be printed.
	 */
	public void printMessage(final String message) {
		System.out.println (message);
	}
	
	/**
	 * Gets the id of the assignee from the user
	 * for searching the tasks assigned to him.
	 * 
	 * @return id of the assignee.
	 */
	int getAssigneeId() {
		final int assigneeId;
		
		System.out.println ("Enter the assignee id :");
		assigneeId = MenuLauncher.input.nextInt();
		MenuLauncher.input.nextLine();
		return assigneeId;
	}
	
	/**
	 * Gets the list of task id from the user.
	 * 
	 * @return list of task id.
	 */
	int[] getListOfTaskId() {
		final int sizeOfList;
		final int[] taskIdList;
		
		System.out.println ("Enter the total number of tasks");
		sizeOfList = MenuLauncher.input.nextInt();
		MenuLauncher.input.nextLine();
		taskIdList = new int[sizeOfList];
		
		for (int initialValue = 0; initialValue < sizeOfList; initialValue++) {
			System.out.println ("Enter the task id");
			taskIdList [initialValue] = MenuLauncher.input.nextInt();
			MenuLauncher.input.nextLine();			
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
		try {
		    System.out.println ("Task details");
		    System.out.println ("Task id : " + task.getTaskId());
		    System.out.println ("Task name : " + task.getTaskName());
		    System.out.println ("Task description : " + task.getTaskDescription());
		    System.out.println ("Task start date : " + task.getTaskStartDate());
		    System.out.println ("Task due date : " + task.getTaskDueDate());
		    System.out.println ("Task status : " + task.getTaskStatus());
		} catch (NullPointerException exception) {
			System.out.println ("No task record found");
		}
	}
	
	/**
	 * Prints all the available task.
	 * 
	 * @param taskCollection List of all available tasks.
	 * @throws NullPointerException when no task record found.
	 */
	void printAllTask(final ArrayList<Task> taskCollection) {
		try {
		    for (final Task task : taskCollection) {
			    System.out.println ("Task details");
			    System.out.println ("task id : " + task.getTaskId());
			    System.out.println ("Task name is : " + task.getTaskName());
			    System.out.println ("Task Description is : " + task.getTaskDescription());
			    System.out.println ("Task start date is : " + task.getTaskStartDate());
			    System.out.println ("Task due date is : " + task.getTaskDueDate());
			    System.out.println ("Task status is : " + task.getTaskStatus());
		    }
		} catch (NullPointerException exception) {
			System.out.println ("No task record found");
		}
		
	}
}
