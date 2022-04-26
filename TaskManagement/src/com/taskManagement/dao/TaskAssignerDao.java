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
import com.taskManagement.view.MenuLauncher;

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
			} catch (SQLException exception) {}
	    }
	}
	
	/**
	 * Searches task assigned to assignee using assignee id.
	 * 
	 * @param assigneeId Id of the assignee.
	 * @return List of tasks.
	 */
	public ArrayList<Task> searchTaskByAssigneeId(final int assigneeId) {
		final ArrayList<Task> list = new ArrayList<Task>();
		final String sql = "SELECT * FROM task where assignee_id = " + assigneeId;
		final Connector connector = new Connector();
		connector.connect();
		
		try {
		    final Statement statement = Connector.connection.createStatement();
		    final ResultSet result = statement.executeQuery(sql);
			
			    while (result.next()){
				    final Task task = new Task(result.getInt(1), result.getString(2), result.getString(3),
			    	      	formatDate(result.getString(4)), formatDate(result.getString(5)), result.getString(6));
			        list.add(task);
			    }
		} catch (SQLException exception) {}
		return list;
	}
	
	/**
	 * Generates date from string format.
	 *  
	 * @param intermediateDate Date in string format.
	 * @return formatted date.
	 */
	private Date formatDate(final String intermediateDate) {
		Date date = null;
						
		try {
			final SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			date = formatDate.parse(intermediateDate);
		} catch (ParseException e) {
			System.out.println ("You have entered wrong date format enter date in yyyy-mm-dd format");
			formatDate(MenuLauncher.INPUT.nextLine());
		}
		return date;
	}
}
