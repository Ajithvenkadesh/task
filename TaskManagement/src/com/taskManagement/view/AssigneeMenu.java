package com.taskManagement.view;

import com.taskManagement.controller.AssigneeController;
import com.taskManagement.model.Assignee;
import com.taskManagement.validation.Validator;

/**
 * List various operations available for
 * creating, reading, updating, deleting 
 * assignee.
 * 
 * @author Ajith venkadesh.
 * @version 1.0
 */
public class AssigneeMenu {
    
	/**
	 * Display all options available for assignee.
	 */
	public void dispalyOptions() {
	    final AssigneeController controller = new AssigneeController();
        final TaskMenu menu = new TaskMenu();
        final AssigneeDetails details = new AssigneeDetails();
        final Validator validator = new Validator();
               
        MenuLauncher.LOGGER.info("\n Enter 1 for creating new assignee"
		        + "\n Enter 2 for updating a partcular assignee"
		        + "\n Enter 3 for deleting a particular assignee"
		        + "\n Enter 4 searching a particular assignee"
		        + "\n Enter * to move to task menu ");
            
        switch (MenuLauncher.INPUT.nextLine()) {
        case "1" :
        	 final Assignee assignee = new Assignee(details.getAssigneeId(),
     	             validator.validateName(details.getAssigneeName()));
        	 MenuLauncher.LOGGER.info(controller.createAssignee(assignee));
    	    break;
        case "2" :
        	MenuLauncher.LOGGER.info(controller.updateAssignee(validator.validateAssigneeId
    	    		(details.getAssigneeId()), validator.validateName
    	    		(details.getAssigneeName())));
    	    break;
        case "3" :
        	MenuLauncher.LOGGER.info(controller.deleteAssignee(validator.validateAssigneeId
    	    		(details.getAssigneeId())));
    	    break;
        case "4" :
    	    details.print(controller.searchParticularAssignee(validator.validateAssigneeId
    	    		(details.getAssigneeId())));
    	    break;
        case "*" :
    	    menu.displayOptions();
    	    break;
        default :
        	MenuLauncher.LOGGER.warning("You have enetered wrong choice");
    	    break;
        }
    }
}
