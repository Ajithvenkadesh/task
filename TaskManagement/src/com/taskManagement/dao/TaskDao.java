package com.taskManagement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.taskManagement.model.Task;

/**
 * Create new task,deletes a task, updates task,
 * search a particular task.
 * 
 * @author Ajithvenkadesh
 * @version 1.0
 */
public class TaskDao {
	
	/**
	 * Creates new task.
	 * 
	 * @param id Id of the task.
	 * @param name Name of the task.
	 * @param description Description about the task.
	 * @param status Status of the task.
	 * @param taskStartDate Start date of the task.
	 * @param taskDueDate Due date of the task.
	 * @return Success or failure message.
	 */
	public String createTask(final int id, final String name, final String description,
			final String status, final Date taskStartDate, final Date taskDueDate) {
		int rowsInserted = 0;
		final Connector connector = new Connector();
        final java.sql.Date startDate = new java.sql.Date(taskStartDate.getTime());
        final java.sql.Date dueDate = new java.sql.Date(taskDueDate.getTime());
		final String sql = "INSERT INTO task (task_id, task_name,"
					+ "task_description, task_status, task_start_date, task_due_date) VALUES "
					+ "(?, ?, ?, ?, ?, ?)";
		connector.connect();
		
		try {
			PreparedStatement statement = Connector.connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, description);
			statement.setString(4, status);
			statement.setDate(5, startDate);
			statement.setDate(6, dueDate);
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
	 * Displays all tasks.
	 * 
	 * @return List of tasks.
	 */
	public ArrayList<Task> dispalay() {
		final Statement statement;
		final ResultSet result;
		
		final Connector connector = new Connector();
		final ArrayList<Task> list = new ArrayList<Task>();
		final String sql = "SELECT * FROM task";
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
	 * @return Formatted date.
	 * @throws NullPointerException if date is null
	 */
	Date formatDate(final String intermediateDate) throws NullPointerException {
		Date date = null;
						
		try {
		    final SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			date = formatDate.parse(intermediateDate);
		} catch (ParseException e) {
			System.out.println ("You have entered wrong date format enter date in dd/mm/yyyy format");
		}
		return date;
	}
	
	/**
	 * Updates a particular task record.
	 * 
	 * @param id Id of the task.
	 * @param name Name of the task.
	 * @param description Description about the task.
	 * @param status Status of the task.
	 * @param startDate Start date of the task.
	 * @param dueDate Due date of the task.
	 * @return Success or failure message
	 */
	public String update(final int id, final String name, final String description, 
			final String status, final Date startDate, final Date dueDate) {
		final PreparedStatement statement;
		
		int rowsUpdated = 0;
		final java.sql.Date taskStartDate = new java.sql.Date(startDate.getTime());
		final java.sql.Date taskDueDate = new java.sql.Date(dueDate.getTime());		
		final Connector connector = new Connector();
		final String sql = "UPDATE task SET task_name=? , task_description = ?,"
				+ "task_status = ?, task_start_date = ?, task_due_date = ?,"
				+ "WHERE task_id=?";
		connector.connect(); 
		
		try {
			statement = Connector.connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setString(3, status);
			statement.setDate(4, taskStartDate);
			statement.setDate(5, taskDueDate);
			statement.setInt(7, id);
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
	 * Deletes a particular task.
	 * 
	 * @param id Id of the task to be deleted.
	 * @return Success or failure message.
	 */
	public String delete(final int id) {
		final String sql = "DELETE FROM task WHERE task_id=?";
		final Connector connector = new Connector();
		int rowsDeleted = 0;
		connector.connect(); 
				 		
		try {
			final PreparedStatement statement = Connector.connection.prepareStatement(sql);
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
	 * Searches a particular task.
	 * 
	 * @param id Id of the task.
	 * @return Object of task.
	 */
	public Task search(final int id) {
		final ResultSet result;
		final Statement statement;
		
		final String sql = "SELECT * FROM task where task_id = " + id;
		final Connector connector = new Connector();
		connector.connect();
				
		try {
			statement = Connector.connection.createStatement();
			result = statement.executeQuery(sql);
			 
			while (result.next()){
				final int taskId = result.getInt(1);
				final String taskName = result.getString(2);
				final String taskDescription = result.getString(3);
			    final String startDate = result.getString(5);
			    final String dueDate = result.getString(6);
			    final String taskStatus = result.getString(4);
			    final Task task = new Task(taskId, taskName, taskDescription, formatDate(startDate),
			    		formatDate(dueDate), taskStatus);
			    return task;
			}
		} catch (SQLException e) {
			System.out.println ("Error while connecting to database");
		}
		return null;
	}
	
    /**
     * Searches task by using status of task.
     * 
     * @param taskStatus Status of the task.
     * @return Required list of tasks.
     */
	public ArrayList<Task> searchTaskByStatus(final String taskStatus) {
		final Statement statement;
		final ResultSet result;
		
		final String sql = "SELECT * FROM task where task_status =  " + "'" + taskStatus + "'" ;
		final Connector connector = new Connector();
		final ArrayList<Task> taskList = new ArrayList<Task>();
		connector.connect();
		
		try {
			statement = Connector.connection.createStatement();
			result = statement.executeQuery(sql);
			
			while (result.next()){
			    final int taskId = result.getInt(1);
			    final String taskName = result.getString(2);
			    final String taskDescription = result.getString(3);
			    final String startDate = result.getString(5);
			    final String dueDate = result.getString(6);
			    final String status = result.getString(4);
			    final Task task = new Task(taskId, taskName, taskDescription, formatDate(startDate),
			    		formatDate(dueDate), status);
			    taskList.add(task);
			}
		} catch (SQLException exception) {
			System.out.println ("Error while connecting to database");
		}
		return taskList;
	}
}
