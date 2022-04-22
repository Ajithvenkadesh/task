package com.taskManagement.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Displays the menu for task and assignee.
 * 
 * @author Ajith venkadesh
 * @version 1.0
 */
public class MenuLauncher {
	public static final Scanner input = new Scanner(System.in);
	
	/**
	 * Displays the menu for task and assignee
	 * 
	 * @param args unused
	 * @throws SQLException 
	 * @throws InputMismatchException when invalid input is entered.
	 */
	public static void main(String[] args) throws SQLException {
		int choice = 0;
		
		final TaskMenu taskMenu = new TaskMenu();
		final AssigneeMenu assigneeMenu = new AssigneeMenu();
		
		do {
			System.out.println ("Enter 1 for assignee menu"
					+ "\n Enter 2 for task menu"
					+ "\n Enter 3 to exit");
			try {
			    choice = input.nextInt();
			    input.nextLine();
			} catch (InputMismatchException exception) {
				System.out.println ("Only integer value is accepted enter integer value ");
			}
			
			switch (choice) {
			case 1 :
				assigneeMenu.dispalyOptions();
				break;
			case 2 :
				taskMenu.displayOptions();
				break;
			default :
				System.out.println ("wrong choice");
				break;
			}
		} while (choice != 3);
	}
}
