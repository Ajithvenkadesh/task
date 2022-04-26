package com.taskManagement.controller;

import java.util.ArrayList;
import com.taskManagement.model.Task;
import com.taskManagement.service.TaskAssignerService;
import com.taskManagement.service.implVersion2.TaskAssigner;

/**
 * Invokes the method of task assigner class.
 * 
 * @author Ajithvenkadesh
 * @version 1.0
 */
public class TaskAssignerController {
	final TaskAssignerService ASSIGNER = new TaskAssigner();
	
	/**
	 * Calls the assign task date method from
	 * task assigner class.
	 * 
	 * @param assigneeId Id of the assignee.
	 * @param taskIdList List of task id.
	 */
	public void assignTask(final int assigneeId, final int[] taskIdList) {
		ASSIGNER.assignTask(assigneeId, taskIdList);
	}
	
	/**
	 * Calls the search task by assignee id from 
	 * task assigner class.
	 * 
	 * @param assigneeId Id of the assignee.
	 * @return List of tasks.
	 */
	public ArrayList<Task> searchTaskByAssigneeId(final int assigneeId) {
		return ASSIGNER.searchTaskByAssigneeId(assigneeId);
	}
}
