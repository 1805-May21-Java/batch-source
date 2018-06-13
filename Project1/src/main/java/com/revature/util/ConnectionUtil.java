package com.revature.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection connection;
	
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
