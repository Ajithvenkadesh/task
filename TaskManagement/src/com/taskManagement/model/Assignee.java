package com.taskManagement.model;

/**
 * Template for assignee.
 * 
 * @author Ajith venkadesh
 * @version 1.0
 */
public class Assignee {
	private int assigneeId;
	private String assigneeName;
	
	/**
	 * Initializes the values of the variables.
	 * 
	 * @param assigneeId Id of the assignee.
	 * @param assigneeName Name of the assignee.
	 */
	public Assignee(final int assigneeId, final String assigneeName) {
		this.assigneeId = assigneeId;
		this.assigneeName = assigneeName;
	}
	
	/**
	 * Returns the id of the assignee.
	 * 
	 * @return Id of the assignee.
	 */
	public int getAssigneeId() {
		return assigneeId;
	}
	
	/**
	 * Sets the id of the assignee.
	 * 
	 * @param assigneeId Id of the assignee.
	 */
	public void setAssigneeId(final int assigneeId) {
		this.assigneeId = assigneeId;
	}
	
	/**
	 * Returns the name of the assignee.
	 *  
	 * @return Name of the assignee.
	 */
	public String getAssigneeName() {
		return assigneeName;
	}
	
	/**
	 * Sets the name of the assignee.
	 * 
	 * @param assigneeName Name of the assignee.
	 */
	public void setAssigneeName(final String assigneeName) {
		this.assigneeName = assigneeName;
	}
}
