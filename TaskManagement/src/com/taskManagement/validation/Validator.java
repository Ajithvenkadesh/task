package com.taskManagement.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.taskManagement.view.AssigneeDetails;
import com.taskManagement.view.MenuLauncher;
import com.taskManagement.view.TaskDetails;

/**
 * Validates the task name, assignee name,
 * task start date, task due date.
 * 
 * @author Ajith venkadesh
 * @version 1.0
 */
public class Validator {
	
	/**
	 * Validates the task name
	 * 
	 * @param name Name of the task.
	 * @return validated name.
	 */
	public String validateName(final String name) {
		final String regularExpression = "[a-zA-Z\s]{1,30}$";
		final Pattern stringPattern = Pattern.compile(regularExpression);
		final Matcher nameMatcher = stringPattern.matcher(name);
		final AssigneeDetails details = new AssigneeDetails();
				
		if (!nameMatcher.matches()) {
		    details.printMessage("Invalid name enter proper name");
			return validateName(details.getAssigneeName());
		} else {
			return name;
		}
	}
	
	/**
	 * Validates the start date of the task.
	 * 
	 * @param startDate Start date of the task.
	 * @return Validated start date.
	 * @throws ParseException if format of the date is wrong.
	 * @throws NullPointerException when the start date is null.
	 */
	public Date validateStartDate(final String startDate)	{
		Date today;
		final AssigneeDetails details = new AssigneeDetails();
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		final String date = formatter.format(new Date());
		
		try {
			today = formatter.parse(date);
		} catch (ParseException e) {
			details.printMessage("Enter today's date manually");
			today = formatDate(MenuLauncher.INPUT.nextLine());
		}
			
		if (formatDate(startDate).compareTo(today) < 0) {
		   	details.printMessage("Invalid start date, start date cannot less than today");
		    return validateDueDate(MenuLauncher.INPUT.nextLine());
		} else {
		    return formatDate(startDate);
		}
	}
	
	/**
	 * Validates the due date of the task.
	 * 
	 * @param dueDate Due date of the task.
	 * @return Validated due date.
	 * @throws ParseException if format of the date is wrong.
	 */
	public Date validateDueDate(final String dueDate) {
		Date today;
		final AssigneeDetails details = new AssigneeDetails();
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		final String date = formatter.format(new Date());
		
		try {
			today = formatter.parse(date);
		} catch (ParseException e) {
			System.out.println ("Enter today's date manually");
			today = formatDate(MenuLauncher.INPUT.nextLine());
		}
			
		if (formatDate(dueDate).compareTo(today) < 0) {
		   	details.printMessage("Invalid due date, due date cannot less than today");
		    return validateDueDate(MenuLauncher.INPUT.nextLine());
		} else {
		    return formatDate(dueDate);
		}
	}
	
	/**
	 * Validates the id of the assignee.
	 * 
	 * @param id Id of the assignee.
	 * @return Validated id.
	 */
	public int validateAssigneeId(final int id) {
		final String assigneeId = String.valueOf(id);
		final String regularExpression = "^[0-9]{1,2}[:.,-]?$";
		final Pattern stringPattern = Pattern.compile(regularExpression);
		final Matcher nameMatcher = stringPattern.matcher(assigneeId);
		final AssigneeDetails details = new AssigneeDetails();
		
		if (!nameMatcher.matches()) {
			details.printMessage("Invalid assignee id enter proper id");
			return validateAssigneeId(details.getAssigneeId());
		} else {
		    return id;
		}
	}
	
	/**
	 * Validates the id of the assignee.
	 * 
	 * @param id Id of the assignee.
	 * @return Validated id.
	 */
	public int validateTaskId(final int id) {
		final String taskId = String.valueOf(id);
		final String regularExpression = "^[0-9]{1,2}[:.,-]?$";
		final Pattern stringPattern = Pattern.compile(regularExpression);
		final Matcher nameMatcher = stringPattern.matcher(taskId);
		final TaskDetails details = new TaskDetails();
		
		if (!nameMatcher.matches()) {
			details.printMessage("Invalid task id enter proper id");
			return validateAssigneeId(details.getTaskId());
		} else {
		    return id;
		}
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
			return formatDate.parse(intermediateDate);
		} catch (ParseException e) {
			MenuLauncher.LOGGER.warning("You have entered wrong date format enter date in yyyy-MM-dd format");
			return formatDate(MenuLauncher.INPUT.nextLine());
		}
	}
}
