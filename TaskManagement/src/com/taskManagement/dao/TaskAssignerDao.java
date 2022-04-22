package com.taskManagement.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.taskManagement.model.Task;

/**
 * Assigns task to assignee, searches task assigned to assignee.
 * 
 * @author Ajithvenkadesh
 * @version 1.0
 */
public class TaskAssignerDao {
	
	/**
	 * Assigns task to assignee.
	 * 
	 * @param assigneeId Id of the assignee.
	 * @param taskIdList List of task id.
	 */
	public void assignTask(final int assigneeId, final int[] taskIdList) {
		
		for (int initialValue = 0; initialValue < taskIdList.length; initialValue++) {
			final Connector connector = new Connector();
			connector.connect();
			final String sql = "UPDATE task set assignee_id = ? where task_id = ? ";
						
			try {
				final PreparedStatement statement = Connector.connection.prepareStatement(sql);
				statement.setInt(1, assigneeId);
				statement.setInt(2, taskIdList[initialValue]);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println ("Error while connecting to database");
			}
	    }
	}
	
	/**
	 * Searches task assigned to assignee using assignee id.
	 * 
	 * @param assigneeId Id of the assignee.
	 * @return List of tasks.
	 */
	public ArrayList<Task> searchTaskByAssigneeId(final int assigneeId) {
		final ResultSet result;
		final Statement statement;
		
		final ArrayList<Task> list = new ArrayList<Task>();
		final String sql = "SELECT * FROM task where assignee_id = " + assigneeId;
		final Connector connector = new Connector();
		connector.connect(); 
				
		try {
			statement = Connector.connection.createStatement();
			result = statement.executeQuery(sql);
			
			while (result.next()){
				final int id = result.getInt(1);
				final String name = result.getString(2);
				final String description = result.getString(3);
				final String status = result.getString(4);
				final String startDate = result.getString(5);
				final String dueDate = result.getString(6);
				final Task task = new Task(id, name, description,
			    		formatDate(startDate), formatDate(dueDate), status);
			    list.add(task);
			}
		} catch (SQLException e) {
			System.out.println ("Error while connecting to database");
		}
		return list;
	}
	
	/**
	 * Generates date from string format.
	 *  
	 * @param intermediateDate Date in string format.
	 * @return formatted date.
	 */
	Date formatDate(final String intermediateDate) {
		Date date = null;
						
		try {
			final SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			date = formatDate.parse(intermediateDate);
		} catch (ParseException e) {
			System.out.println ("You have entered wrong date format enter date in yyyy-mm-dd format");
		}
		return date;
	}
}
