package com.Revature.util;

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

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// connection
		// Check if the connection has already been initialized
		// and is not closed
		if (connection != null && !connection.isClosed()) {
			return connection;
		}

		InputStream in = ConnectionUtil.class.getResourceAsStream("/connectionProperties");
		
		Properties prop = new Properties();

		prop.load(in);
		

		connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));

		return connection;
	}

}
