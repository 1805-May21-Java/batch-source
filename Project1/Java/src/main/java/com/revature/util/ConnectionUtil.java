package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil{
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException, IOException,SQLException{
		if(connection == null || connection.isClosed()) {
			String filename = "connection.properties";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			
				Properties properties = new Properties();
				properties.load(loader.getResourceAsStream(filename));
				String url = properties.getProperty("url");
				String username = properties.getProperty("username");
				String password = properties.getProperty("password");
				connection = DriverManager.getConnection(url, username, password);	
			}
		return connection;
	}
	
}
