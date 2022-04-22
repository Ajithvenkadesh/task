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
		final String regularExpression;
		final Pattern stringPattern;
		final Matcher nameMatcher;
		String assigneeName;
		
		regularExpression = "[a-zA-Z\s]{1,30}$";
		stringPattern = Pattern.compile(regularExpression);
		nameMatcher = stringPattern.matcher(name);
		final AssigneeDetails details = new AssigneeDetails();
		
		if (!nameMatcher.matches()) {
		    details.printMessage("Invalid name enter proper name");
			assigneeName = details.getAssigneeName();
			return validateName(assigneeName);
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
	public Date validateStartDate(final Date startDate)	{
		String intermediateStartDate;
		Date today;
		String date;
		
		final AssigneeDetails details = new AssigneeDetails();
		final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		today = null;
		date = formatter.format(new Date());
		
		try {
			today = formatter.parse(date);
		} catch (ParseException exception) {
			details.printMessage("nvalid date format");
		} 
		
		try {				
		    if (startDate.compareTo(today) < 0) {
			    details.printMessage("Invalid start date, start date cannot less than today");
			    intermediateStartDate = MenuLauncher.input.nextLine();
			    Date taskStartDate = null;
			
			    try {
				    taskStartDate = formatter.parse(intermediateStartDate);
			    } catch (ParseException e) {
				    details.printMessage("Invalid date format enter date in dd/mm/yyyy format");
			    }
			    return validateStartDate(taskStartDate);
		    } else {		   
		        return startDate;
		    }
		} catch (NullPointerException exception) {
			details.printMessage("Start date cannot be null");
		}
		return startDate;
	}
	
	/**
	 * Validated the due date of the task.
	 * 
	 * @param dueDate Due date of the task.
	 * @return Validated due date.
	 * @throws ParseException if format of the date is wrong.
	 * @throws NullPointerException when the start date is null.
	 */
	public Date validateDueDate(final Date dueDate)	{
		String intermediateDueDate;
		Date today = null;
		String date;
				
		final AssigneeDetails details = new AssigneeDetails();
		final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		date = formatter.format(new Date());
				
		try {
			today = formatter.parse(date);
		} catch (ParseException exception) {
			details.printMessage("wrong date format");
		} catch (NullPointerException exception) {
			details.printMessage("unable to get today's date");
		}
		
		try {
		    if (dueDate.compareTo(today) < 0) {
		    	details.printMessage("Invalid due date, due date cannot less than today");
			    intermediateDueDate = MenuLauncher.input.nextLine();
			    Date taskDueDate = null;
			
			    try {
				    taskDueDate = formatter.parse(intermediateDueDate);
			    } catch (ParseException e) {
			    	details.printMessage("Invalid date format enter the date in dd/mm/yyyy format");
			    }
			    return validateDueDate(taskDueDate);
		    } else {
		        return dueDate;
		    }
		} catch (NullPointerException exception) {
			details.printMessage("Due date cannot be null");
		}
		return dueDate;
	}
	
	/**
	 * Validates the id of the assignee.
	 * 
	 * @param id Id of the assignee.
	 * @return Validated id.
	 */
	public int validateAssigneeId(final int id) {
		final String regularExpression;
		final Pattern stringPattern;
		final Matcher nameMatcher;
		String assigneeId;
		
		assigneeId = String.valueOf(id);
		regularExpression = "^[0-9]{1,2}[:.,-]?$";
		stringPattern = Pattern.compile(regularExpression);
		nameMatcher = stringPattern.matcher(assigneeId);
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
		final String regularExpression;
		final Pattern stringPattern;
		final Matcher nameMatcher;
		String taskId;
		
		taskId = String.valueOf(id);
		regularExpression = "^[0-9]{1,2}[:.,-]?$";
		stringPattern = Pattern.compile(regularExpression);
		nameMatcher = stringPattern.matcher(taskId);
		final TaskDetails details = new TaskDetails();
		
		if (!nameMatcher.matches()) {
			details.printMessage("Invalid task id enter proper id");
			return validateAssigneeId(details.getTaskId());
		} else {
		    return id;
		}
	}
}
