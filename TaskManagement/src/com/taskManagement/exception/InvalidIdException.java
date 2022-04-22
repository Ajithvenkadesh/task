package com.taskManagement.exception;

/**
 * Raises exception when the id is invalid.
 * 
 * @author Ajith venkadesh
 * @version 1.0
 */
public class InvalidIdException extends Exception {
	
	/**
	 * Constructor of the class.
	 * 
	 * @param message Message to be displayed.
	 */
	public InvalidIdException(String message) {
		super(message);
	}
}
