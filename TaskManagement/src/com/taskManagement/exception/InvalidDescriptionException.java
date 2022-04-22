package com.taskManagement.exception;

/**
 * Throws exception when the description is too short.
 * 
 * @author Ajith venkdesh.
 * @version 1.0
 */
public class InvalidDescriptionException extends Exception {
	
	/**
	 * Constructor of the class.
	 * 
	 * @param message message to be printed.
	 */
	public InvalidDescriptionException(String message) {
		super(message);
	}
}
