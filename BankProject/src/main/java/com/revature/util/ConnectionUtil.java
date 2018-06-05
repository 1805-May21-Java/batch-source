package com.revature.util;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	private static Connection connection;
//	public static Connection getHardCodedConnect() throws SQLException{
//		String url = "jdbc:oracle:thin:@ogoexdb.c7c3jiumkydd.us-east-1.rds.amazonaws.com:1521:ORCL";
//		String username = "ogoextreme";
//		String password = "Johndope1";
//		if(connection == null || connection.isClosed()) {
//			connection = DriverManager.getConnection(url, username, password);
//		}
//		return DriverManager.getConnection(url,username,password);
//	}
	public static Connection getConnection() throws IOException, SQLException{
		Properties prop = new Properties();
		String path = "/Users/Moses/Documents/1805-May21-Java/batch-source/BankProject/connection.properties";
		InputStream in = new FileInputStream(path);
		prop.load(in);
		//String url = prop.getProperty("url");
		//String username = prop.getProperty("username");
		//String password = prop.getProperty("password");
//		return DriverManager.getConnection(url, username, password);
		return DriverManager.getConnection("jdbc:oracle:thin:@ogoexdb.c7c3jiumkydd.us-east-1.rds.amazonaws.com:1521:ORCL", "ogoextreme", "password");

	}
}
