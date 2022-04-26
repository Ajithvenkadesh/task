package com.taskManagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.taskManagement.model.Assignee;
import com.taskManagement.view.MenuLauncher;

/**
 * Creates, deletes, reads, updates assignee records.
 * 
 * @author Ajithvenkadesh
 * @version 1.0
 */
public class AssigneeDao {
	
	/**
	 * Inserts new assignee record into the database.
	 * 
	 * @param id Id of the assignee.
	 * @param name Name of the assignee.
	 * @return Success or failure message.
	 */
	public String createAssignee(final int id, final String name) {
		final Connector connector = new Connector();
		connector.connect();
		final String sql = "INSERT INTO assignee (assignee_id, assignee_name) VALUES (?, ?)";
		PreparedStatement statement;
		
		try {
			statement = Connector.connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, name);
							
			if (statement.executeUpdate() > 0) {
			    return "A new assignee was inserted successfully!";
			}
		} catch (SQLException e) {
			MenuLauncher.LOGGER.warning("Enter new assignee id");
			createAssignee(MenuLauncher.INPUT.nextInt(), name);
			MenuLauncher.INPUT.nextLine();
		}
		return "Assignee not inserted";
	}
	
	/**
	 * Updates a particular assignee record.
	 * 
	 * @param id Id of the assignee.
	 * @param name Name of the assignee.
	 * @return Success or failure message.
	 */
	public String update(final int id, final String name) {
		final String sql = "UPDATE assignee SET assignee_name=? WHERE assignee_id=?";
		final Connector connector = new Connector();
		connector.connect(); 
		PreparedStatement statement;
		
		try {
			statement = Connector.connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, id);
			
			if (statement.executeUpdate() > 0) {
			    return "An existing user was updated successfully!";
			}
		} catch (SQLException e) {}
		return "Assignee was not updated";
	}
	
	/**
	 * Deletes a particular record from assignee table.
	 * 
	 * @param id Id of the assignee.
	 * @return Success or failure message.
	 */
	public String delete(final int id) {
		final String sql = "DELETE FROM assignee WHERE assignee_id=?";
		final Connector connector = new Connector();
		connector.connect();
		
		try {
		    final PreparedStatement statement = Connector.connection.prepareStatement(sql);
		    statement.setInt(1, id);
						
		    if (statement.executeUpdate() > 0) {
		        return "A user was deleted successfully!";
		    }
		} catch (SQLException exception) {}
		return "User was not deleted";
	}
	
	/**
	 * Searches a particular assignee record using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @return Object of assignee class.
	 */
	public Assignee search(final int id) {
		try {
		    final String sql = "SELECT * FROM assignee WHERE assignee_id = " + id;
		    final Connector connector = new Connector();
		    connector.connect();
		    final Statement statement = Connector.connection.createStatement();
		    final ResultSet result = statement.executeQuery(sql);
		    			
		    while (result.next()){
			    Assignee assignee = new Assignee(result.getInt(1), result.getString(2));
			    return assignee;
		    }
		} catch (SQLException exception) {}
		 return null;	
	}	   
}
