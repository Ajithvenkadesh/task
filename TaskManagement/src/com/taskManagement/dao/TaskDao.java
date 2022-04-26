package com.taskManagement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.taskManagement.model.Task;
import com.taskManagement.view.MenuLauncher;

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
		final Connector connector = new Connector();
		connector.connect();
        final java.sql.Date startDate = new java.sql.Date(taskStartDate.getTime());
        final java.sql.Date dueDate = new java.sql.Date(taskDueDate.getTime());
		final String sql = "INSERT INTO task (task_id, task_name,"
					+ "task_description, task_status, task_start_date, task_due_date) VALUES "
					+ "(?, ?, ?, ?, ?, ?)";
		
		try {
		    final PreparedStatement statement = Connector.connection.prepareStatement(sql);
		    statement.setInt(1, id);
		    statement.setString(2, name);
		    statement.setString(3, description);
		    statement.setString(4, status);
		    statement.setDate(5, startDate);
		    statement.setDate(6, dueDate);
		    
		    if (statement.executeUpdate() > 0) {
				return "A new task was inserted successfully!";
			}
		} catch (SQLException exception) {
			MenuLauncher.LOGGER.warning("Change the task id");
			createTask(MenuLauncher.INPUT.nextInt(), name, description, status,
					taskStartDate, taskDueDate);
		}
		return "Task not inserted";
	}
	
	/**
	 * Displays all tasks.
	 * 
	 * @return List of tasks.
	 */
	public ArrayList<Task> dispalay() {
		final Connector connector = new Connector();
		connector.connect();
		final ArrayList<Task> list = new ArrayList<Task>();
		final String sql = "SELECT * FROM task";
		
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
		final java.sql.Date taskStartDate = new java.sql.Date(startDate.getTime());
		final java.sql.Date taskDueDate = new java.sql.Date(dueDate.getTime());		
		final Connector connector = new Connector();
		connector.connect(); 
		final String sql = "UPDATE task SET task_name=? , task_description = ?,"
				+ "task_status = ?, task_start_date = ?, task_due_date = ?,"
				+ "WHERE task_id=?";
		
		try {
		    final PreparedStatement statement = Connector.connection.prepareStatement(sql);
		    statement.setString(1, name);
		    statement.setString(2, description);
		    statement.setString(3, status);
		    statement.setDate(4, taskStartDate);
		    statement.setDate(5, taskDueDate);
		    statement.setInt(7, id);
				
		    if (statement.executeUpdate() > 0) {
		        return "An existing user was updated successfully!";
		    }
		} catch (SQLException exception) {}
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
	 * Searches a particular task.
	 * 
	 * @param id Id of the task.
	 * @return Object of task.
	 */
	public Task search(final int id) {
		final String sql = "SELECT * FROM task where task_id = " + id;
		final Connector connector = new Connector();
		connector.connect();
		
		try {
		    final Statement statement = Connector.connection.createStatement();
		    final ResultSet result = statement.executeQuery(sql);
			 
		    while (result.next()){
			    final Task task = new Task(result.getInt(1), result.getString(2), result.getString(3), 
		    	    	formatDate(result.getString(5)), formatDate(result.getString(6)), result.getString(4));
			    return task;
		    }
		} catch (SQLException exception) {}
		return null;
	}
	
    /**
     * Searches task by using status of task.
     * 
     * @param taskStatus Status of the task.
     * @return Required list of tasks.
     */
	public ArrayList<Task> searchTaskByStatus(final String taskStatus) {
		final String sql = "SELECT * FROM task where task_status =  " + "'" + taskStatus + "'" ;
		final Connector connector = new Connector();
		connector.connect();
		final ArrayList<Task> taskList = new ArrayList<Task>();
		
		try {
		    final Statement statement = Connector.connection.createStatement();
		    final ResultSet result = statement.executeQuery(sql);
			
		    while (result.next()){
		        final Task task = new Task(result.getInt(1), result.getString(2), result.getString(2), 
		    	    	formatDate(result.getString(5)), formatDate(result.getString(6)), result.getString(4));
		        taskList.add(task);
		    }
		} catch (SQLException exception) {}
		return taskList;
	}
	
	/**
	 * Generates date from string format.
	 * 
	 * @param intermediateDate Date in string format.
	 * @return Formatted date.
	 */
	private Date formatDate(final String intermediateDate) {
		try {
		    final SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = formatDate.parse(intermediateDate);
		    return date;
		} catch (ParseException e) {
			System.out.println ("You have entered wrong date format enter date in dd/mm/yyyy format");
			return formatDate(MenuLauncher.INPUT.nextLine());
		}
	}
}
