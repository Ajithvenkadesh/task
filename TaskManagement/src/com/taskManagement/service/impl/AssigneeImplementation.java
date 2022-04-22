package com.taskManagement.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import com.taskManagement.model.Assignee;
import com.taskManagement.service.AssigneeService;

/**
 * Provides implementation for Assignee service interface.
 * 
 * @author Ajith venkadesh.
 * @version 1.0
 *
 */
public class AssigneeImplementation implements AssigneeService {
	public static final ArrayList<Assignee> ASSIGNEELIST = new ArrayList<Assignee>();
    private static final AtomicInteger ASSIGNEEID = new AtomicInteger(0);
	
	/**
	 * Generates assignee id automatically and in sequence.
	 * 
	 * @return Id of the assignee.
	 */
	public int generateAssigneeId() {
		return ASSIGNEEID.incrementAndGet();
	}	
	
	/**
	 * Creates new assignee by getting inputs from user.
	 * 
	 * @param assignee Object of class assignee.
	 * @return success or failure message.
	 */
	public String create(final Assignee assignee) {
		ASSIGNEELIST.add(assignee);
		return "New assignee created successfully and id is" +  assignee.getAssigneeId();
	}
	
	/**
	 * Deletes a particular assignee by using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @return success or failure message.
	 */
	public String delete(final int id) {
		final Iterator<Assignee> currentAssignee = ASSIGNEELIST.iterator();
								
		while (currentAssignee.hasNext()) {
			final Assignee assigneeToBeDeleted = currentAssignee.next();
			
			if (assigneeToBeDeleted.getAssigneeId() == id) {
				currentAssignee.remove();
				return "Deleted successfully";
			} 
		}
		return "Record not found";
	}
	
	/**
	 * Updates a particular assignee by using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @param name New assignee name.
	 * @return success or failure message.
	 */
	public String update(final int id, final String name) {
		for (final Assignee assignee : ASSIGNEELIST) {
			if (assignee.getAssigneeId() == id) {
				if (!name.equals("no")) {
					assignee.setAssigneeName(name);
					return "Assignee name updated";
				}
			} 
		}
		return "Assignee name not updated";
	}
	
	/**
	 * Searches a particular assignee by using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @return Required assignee record.
	 */
	public Assignee search(final int id) {
		for (final Assignee assignee : ASSIGNEELIST) {
			if (assignee.getAssigneeId() == id) {
				return assignee;
			}
		}
		return null;
	}
}
