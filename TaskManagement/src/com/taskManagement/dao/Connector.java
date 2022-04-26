package com.taskManagement.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.postgresql.jdbc3.Jdbc3PoolingDataSource;

import com.taskManagement.view.MenuLauncher;

/**
 * Provides method for connecting to database.
 * 
 * @author Ajithvenkadesh
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class Connector {
	static Connection connection;
	
	/**
	 * Connects to the PostgreSQL database
	 */
	public void connect() {
	   final Properties properties = new Properties();
	   String propertyFileLocation = "C:\\database\\JDBCSettings.properties";
	   FileReader fileReader = null;
	    	
	   	try {
	   		fileReader = new FileReader(propertyFileLocation);
	   		properties.load(fileReader);
		} catch (IOException e) {
			MenuLauncher.LOGGER.warning("Change file location");
		}
	   	
	    try {
			final Jdbc3PoolingDataSource source = new Jdbc3PoolingDataSource();
	    	source.setDataSourceName("A Data Source");
	    	source.setDataSourceName("dataSource");
	    	source.setServerName(properties.getProperty("db.serverName"));
	    	source.setDatabaseName(properties.getProperty("db.databaseName"));
	    	source.setUser(properties.getProperty("db.username"));
	    	source.setPassword(properties.getProperty("db.password"));
	    	source.setMaxConnections(100);
	    	connection = source.getConnection();
		} catch (SQLException e) {
		MenuLauncher.LOGGER.warning("Change the url or db user name or db password");
		}
	        
	    if (connection != null) {
	    	MenuLauncher.LOGGER.info("Connected to sql successfully");
		} else {
			MenuLauncher.LOGGER.warning("Failed to connect");
		}
	}
}

