package com.revature.util;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection connection;
	
	public static Connection getHardCodedConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@mynewdb.cxtaoxy1rnwl.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "mabrannan";
		String password = "password";
		
		if (connection == null) {
			connection = DriverManager.getConnection(url, username, password);
		} 
		return connection;	
	}
	
	public static Connection getConnection() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if (connection == null) {
			connection = DriverManager.getConnection(url, username, password);
		} 
		return connection;
		
		
	}
	
}
