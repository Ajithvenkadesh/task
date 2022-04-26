package com.taskManagement.controller;

import com.taskManagement.model.Assignee;
import com.taskManagement.service.AssigneeService;
import com.taskManagement.service.implVersion2.AssigneeImplementation;

/**
 * Invokes the methods of Assignee 
 * implementation class.
 * 
 * @author Ajith venkadesh
 * @version 1.0
 */
public class AssigneeController {
	final AssigneeService ASSIGNEE = new AssigneeImplementation();
		
	/**
	 * Calls the create assignee method in assignee
	 * implementation class.
	 * 
	 * @param newAssignee Object of assignee class.
	 * @return Success or failure message.
	 */
	public String createAssignee(final Assignee newAssignee) {
		return ASSIGNEE.create(newAssignee);
	}
	
	/**
	 * Calls the delete assignee method in the
	 * assignee implementation class.
	 * 
	 * @param id Id of the assignee.
	 * @return Success or failure message.
	 */
	public String deleteAssignee(final int id) {
		return ASSIGNEE.delete(id);
		
	}
	
	/**
	 * Calls the update assignee method in the
	 * assignee implementation method.
	 * 
	 * @param assigneeId Id of the assignee.
	 * @param assigneeName Name of the assignee.
	 * @return Success or failure message.
	 */
	public String updateAssignee(final int assigneeId, final String assigneeName) {
		return ASSIGNEE.update(assigneeId, assigneeName);
	}
	
	/**
	 * Calls the searchParticularAssignee method in the
	 * assignee implementation class.
	 * 
	 * @param id Id of the assignee.
	 * @return Required assignee record.
	 */
	public Assignee searchParticularAssignee(final int id) {
		return ASSIGNEE.search(id);
	}
}
