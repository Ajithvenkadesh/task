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
			MenuLauncher.LOGGER.info("Enter the id of the assignee");
		    assigneeId = MenuLauncher.INPUT.nextInt();
		    MenuLauncher.INPUT.nextLine();
		} catch (InputMismatchException exception) {
			MenuLauncher.LOGGER.warning("Only integer value is accepted enter ineger value");
			getAssigneeId();
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
		MenuLauncher.LOGGER.info("Enter the name of the assignee");
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
	 * Prints the details about the assignee.
	 * 
	 * @param assigne Object of assignee class.
	 */
	void print(Assignee assignee) {
		if (assignee == null) {
			MenuLauncher.LOGGER.warning("No assignee record found");
		} else {
			MenuLauncher.LOGGER.info("Assignee details");
			MenuLauncher.LOGGER.info("Assignee id is : " + assignee.getAssigneeId());
			MenuLauncher.LOGGER.info("Assignee name is : " + assignee.getAssigneeName());
		}
	}
}
