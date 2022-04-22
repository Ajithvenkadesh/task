package com.taskManagement.exception;

/**
 * Raises exception when we enter invalid status.
 * 
 * @author Ajith venkadesh.
 * @version 1.0
 */
public class InvalidStatusException extends Exception{
	
	/**
	 * Constructor of the class.
	 * 
	 * @param message Message to be displayed.
	 */
	public InvalidStatusException(String message) {
		super(message);
	}
}
