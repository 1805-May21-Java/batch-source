package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil{
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException, IOException,SQLException{
		if(connection == null || connection.isClosed()) {
			InputStream inputStream = new FileInputStream("connection.properties");
				Properties properties = new Properties();
				properties.load(inputStream);
				String url = properties.getProperty("url");
				String username = properties.getProperty("username");
				String password = properties.getProperty("password");
				connection = DriverManager.getConnection(url, username, password);	
		}
		return connection;
	}
	
}
