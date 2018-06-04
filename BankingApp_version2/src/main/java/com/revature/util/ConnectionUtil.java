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
	
	//Static member variable that will be used to connect to the database 
	private static Connection connection;
	
	//Method uses connections.properties file to set up a connection to the database
	public static Connection getConnection() throws IOException, SQLException {
		//Properties prop is used to allow the program to read from
		//the .properties file.
		Properties prop = new Properties();
		InputStream is = new FileInputStream("connection.properties");
		prop.load(is);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		//Connection connection is used to store the connection to the database
		if(connection == null) {
			connection = DriverManager.getConnection(url, username, password);
		}
		//static member variable is returned
		return connection;
	}

}
