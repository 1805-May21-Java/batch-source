package com.revature.util;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnectionUtil
{
	private static Connection connection;
	
	public static Connection getConnection() throws IOException, SQLException
	{
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if(connection == null || connection.isClosed())
		{
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
