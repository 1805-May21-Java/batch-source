package com.Revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	// Define as singleton

	private static Connection connection; // Define class wide connection

	public static Connection getConnection() throws SQLException, IOException {// Define static method for getting sql
																				// connection
		// Check if the connection has already been initialized
		// and is not closed
		if (connection != null && !connection.isClosed()) {
			return connection;
		}

		Properties prop = new Properties();
		InputStream in = new FileInputStream("connectionProperties");
		prop.load(in);

		connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
		
		return connection;
	}

}
