package com.taskManagement.view;

import java.util.InputMismatchException;
import com.taskManagement.model.Assignee;

/**
 * Gets details about the assignee like id of assignee,
 * name of assignee from user and also it generates the
 * assignee id automatically.
 * 
 * @author Ajith venkadesh.
 * @version 1.0
 */
public class AssigneeDetails {
	
	/**
	 * Gets the id of the assignee from the user for searching,
	 * deleting, updating operations.
	 * 
	 * @return id of the assignee.
	 */
	public int getAssigneeId() {
		int assigneeId = 0;
		
		try {
		    System.out.println ("Enter the id of the assignee");
		    assigneeId = MenuLauncher.input.nextInt();
		    MenuLauncher.input.nextLine();
		} catch (InputMismatchException exception) {
			System.out.println ("Only integer value is accepted enter ineger value");
		}
	    return assigneeId;
	}
	
	/**
	 * Gets the name of the assignee from the user for
	 * searching, deleting, updating operations.
	 * 
	 * @return name of the assignee.
	 */
	public String getAssigneeName() {
		final String assigneeName;
				
		System.out.println ("Enter the name of the assignee");
		assigneeName = MenuLauncher.input.nextLine();
		return assigneeName;
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
	 * Prints the details about the assignee.
	 * 
	 * @param assigne Object of assignee class.
	 * @throws NullPointerException when no task record found.
	 */
	void print(Assignee assignee) {
		try {
		    System.out.println ("Assignee details");
		    System.out.println ("Assignee id is : " + assignee.getAssigneeId());
		    System.out.println ("Assignee name is : " + assignee.getAssigneeName());
		} catch (NullPointerException exception) {
			System.out.println ("No record found for the corrosponding id");
		}
	}
}
