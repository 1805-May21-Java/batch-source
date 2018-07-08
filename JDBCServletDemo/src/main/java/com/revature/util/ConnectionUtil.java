package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getHardcodedConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@[url]:1521:ORCL";
		String username = "Admin";
		String password = "p4ssw0rd";
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnection() throws IOException, SQLException {
		//check that our driver is being seen by Maven
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String filename = "connection.properties";
		
		//load connection credentials from file 
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(filename));
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;	
		
	}

}
