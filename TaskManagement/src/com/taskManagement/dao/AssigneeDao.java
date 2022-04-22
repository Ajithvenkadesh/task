package com.taskManagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.taskManagement.model.Assignee;

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
		final PreparedStatement statement;
		
		int rowsInserted = 0;
		final Connector connector = new Connector();
		final String sql = "INSERT INTO assignee (assignee_id, assignee_name) VALUES (?, ?)";
		connector.connect();		
		
		try {
			statement = Connector.connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, name);
			rowsInserted = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println ("Error while connecting to database");
		}
		
		if (rowsInserted > 0) {
		    return "A new assignee was inserted successfully!";
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
		final PreparedStatement statement;
		
		int rowsUpdated = 0;
		final String sql = "UPDATE assignee SET assignee_name=? WHERE assignee_id=?";
		final Connector connector = new Connector();
		connector.connect(); 
		
		try {
			statement = Connector.connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, id);
			rowsUpdated = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println ("Error while connecting to database");
		}
		
		if (rowsUpdated > 0) {
		    return "An existing user was updated successfully!";
		}
		return "Assignee was not updated";
	}
	
	/**
	 * Deletes a particular record from assignee table.
	 * 
	 * @param id Id of the assignee.
	 * @return Success or failure message.
	 */
	public String delete(final int id) {
		final PreparedStatement statement;
		
		int rowsDeleted = 0; 
		final String sql = "DELETE FROM assignee WHERE assignee_id=?";
		final Connector connector = new Connector();
		connector.connect(); 
		
		try {
			statement = Connector.connection.prepareStatement(sql);
			statement.setInt(1, id);
			rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println ("Error while connecting to database");
		}
		
		if (rowsDeleted > 0) {
		    return "A user was deleted successfully!";
		}
		return "User was not deleted";
	}
	
	/**
	 * Searches a particular assignee record using assignee id.
	 * 
	 * @param id Id of the assignee.
	 * @return Object of assignee class.
	 */
	public Assignee search(final int id) {
		final ResultSet result;
		final Statement statement;
		
		final String sql = "SELECT * FROM assignee where assignee_id = " + id;
		final Connector connector = new Connector();
		connector.connect();
				
		try {
			statement = Connector.connection.createStatement();
			result = statement.executeQuery(sql);
			
			while (result.next()){
			    final int aasignee_id = result.getInt("assignee_id");
			    final String name = result.getString(2);
			    final Assignee assignee = new Assignee(aasignee_id, name);
			    return assignee;
			}
		} catch (SQLException e) {
			System.out.println ("Error while connecting to database");
		}
		return null;
	}	   
}
