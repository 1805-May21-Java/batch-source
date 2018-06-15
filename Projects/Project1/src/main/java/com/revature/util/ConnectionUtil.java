package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getHardcodedConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@revaturetest.cwxw0actfyzo.us-west-2.rds.amazonaws.com:1521:ORCL";
		String username = "evannara";
		String password = "Medo0101?";
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
		
		
		InputStream in = new FileInputStream("/Users/vannarahouth/Desktop/workspace/ServletSecond/src/main/resources/connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
//		if(connection == null) {
//			connection = DriverManager.getConnection(url, username, password);
//		}
		return DriverManager.getConnection(url, username, password);
	}

}
