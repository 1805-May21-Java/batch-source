package com.adora.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	/**
	 * This method establishes and return a connection to a database.
	 * @return Connection object to database
	 * @throws IOException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		
		return DriverManager.getConnection(url, username, password);
	}

}
