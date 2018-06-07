package com.revature.util;

import java.io.*;
import java.sql.*;
import java.util.*;
public class ConnectionUtil 
{
	private static Connection connection;

	public static Connection getHardcodedConnection() throws SQLException 
	{
		String url = "jdbc:oracle:thin:@mydbinstance.cgpujnzup6qj.us-east-2.rds.amazonaws.com:1521/ORCL";
		String username = "username";
		String password = "password";
		if(connection == null || connection.isClosed()) 
		{
			connection = DriverManager.getConnection(url, username, password);
		}
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnection() throws IOException, SQLException 
	{
		Properties prop = new Properties();
		InputStream in = new FileInputStream("D:\\Projects\\1805-May21\\Banking2.0\\src\\main\\java\\connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(connection == null || connection.isClosed()) 
		{
			connection = DriverManager.getConnection(url, username, password);
		}
		return DriverManager.getConnection(url, username, password);
	}
}
