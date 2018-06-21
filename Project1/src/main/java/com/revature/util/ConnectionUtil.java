package com.revature.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/*
 * Connection Utility Class
 * 
 * Contains globally accessing methods to establish a Connection
 * to the Amazon RDS Oracle SQL database using JDBC
 */
public class ConnectionUtil {

	private static Connection connection;

	// Establishes the connection with the provided hardcoded string values
	public static Connection getHardcodedConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@dboulos.cv36tvcn8gsq.us-east-2.rds.amazonaws.com:1521/ORCL";
		String username = "mboulos";
		String password = "lucasking";
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return DriverManager.getConnection(url, username, password);
	}
	
	// Establishes the connection using the connection.properties file in src/main/resources
	public static Connection getConnection() throws IOException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		InputStream in = new FileInputStream("C:\\Users\\mboul\\Documents\\Revature\\batch-source\\Project1\\src\\main\\resources\\connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return DriverManager.getConnection(url, username, password);
	}
}
