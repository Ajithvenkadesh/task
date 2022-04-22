package com.taskManagement.service;

import java.util.ArrayList;
import com.taskManagement.model.Task;

/**
 * Lists the services available for mapping a task.
 * 
 * @author Ajith venkadesh.
 * @version 1.0
 *
 */
public interface TaskAssignerService {
	
	/**
	 * Assigns task to assignees.
	 * 
	 * @param assigneeId Id of the assignee.
	 * @param taskIdList List of task id.
	 */
	public void assignTask(final int assigneeId, final int[] taskIdList);
		
	/**
	 * Searches task assigned to assignee by using
	 * assignee id.
	 * 
	 * @param assigneeId Id of the assignee.
	 * @return list of tasks.
	 */
	public ArrayList<Task> searchTaskByAssigneeId(final int assigneeId);
	
}
