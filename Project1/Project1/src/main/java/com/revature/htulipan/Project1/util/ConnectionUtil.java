package com.revature.htulipan.Project1.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection connection;
	private static String filename = "connection.properties";
	
//	public static Connection getHardcodedConnection() throws SQLException {
//		String url = "";
//		String username = "";
//		String password = "";
//		if(connection == null || connection.isClosed()) {
//			connection = DriverManager.getConnection(url, username, password);
//		}
//		return DriverManager.getConnection(url, username, password);
//	}
	
	public static Connection getConnection() throws IOException, SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(filename));

		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
	
	
}
