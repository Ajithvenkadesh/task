package com.taskManagement.service;

import java.sql.SQLException;

import com.taskManagement.model.Assignee;

/**
 * Lists the services available for assignee.
 *  
 * @author Ajith venkadesh
 * @version 1.0
 */
public interface AssigneeService {
	
	/**
	 * Creates new assignee by getting inputs from user.
	 * 
	 * @param assignee Object of assignee class.
	 * @return success or failure message.
	 * @throws SQLException 
	 */
	public String create(final Assignee assignee) throws SQLException;
			
	/**
	 * Deletes a particular assignee by using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @return success or failure message.
	 */
	public String delete(final int id) throws SQLException;
	
	/**
	 * Updates a particular assignee by using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @param name Name of the assignee.
	 * @return Success or failure message.
	 */
	public String update(final int id, final String name)throws SQLException;
	
	/**
	 * Searches a particular assignee by using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @return Required assignee record.
	 */
	public 	Assignee search(final int id)throws SQLException;
}
