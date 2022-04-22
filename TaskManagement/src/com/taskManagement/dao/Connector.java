package com.taskManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides method for connecting to database;
 * @author Ajithvenkadesh
 * @version 1.0
 */
public class Connector {
	static Connection connection;
	private final String URL = "jdbc:postgresql://localhost/sql";
	private final String USER = "postgres";
	private final String PASSWORD = "123";

	/**
	 * Connects to the PostgreSQL database
	 */
	public void connect() {
	
	    try {
	        connection = DriverManager.getConnection(URL, USER, PASSWORD);
	        	
	        if (connection != null) {
	        	System.out.println ("Connected to sql successfully");
	        } else {
	        	System.out.println ("Failed to connect");
	        }
	    } catch (SQLException e) {
	        System.out.println ("Error while connecting to database");
	    }
	}
}

