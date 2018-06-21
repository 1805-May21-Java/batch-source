package com.revature.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.*;
import java.sql.*;
import java.util.Properties;

//public class ConnectionUtil {
//	private static Connection connection;
////	public static Connection getHardCodedConnect() throws SQLException{
////		String url = "jdbc:oracle:thin:@ogoexdb.c7c3jiumkydd.us-east-1.rds.amazonaws.com:1521:ORCL";
////		String username = "ogoextreme";
////		String password = "Johndope1";
////		if(connection == null || connection.isClosed()) {
////			connection = DriverManager.getConnection(url, username, password);
////		}
////		return DriverManager.getConnection(url,username,password);
////	}
//	public static Connection getConnection() throws IOException, SQLException{
//		Properties prop = new Properties();
//		String path = "/Users/Moses/Documents/1805-May21-Java/batch-source/Reimbursement/connection.properties";
//		InputStream in = new FileInputStream(path);
//		prop.load(in);
//		//String url = prop.getProperty("url");
//		//String username = prop.getProperty("username");
//		//String password = prop.getProperty("password");
////		return DriverManager.getConnection(url, username, password);
//		return DriverManager.getConnection("jdbc:oracle:thin:@ogoexdb.c7c3jiumkydd.us-east-1.rds.amazonaws.com:1521:ORCL", "ogoextreme", "password");
//
//	}
//}

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getConnection() throws IOException, SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@ogoexdb.c7c3jiumkydd.us-east-1.rds.amazonaws.com:1521:ORCL";
		String username = "ogoextreme";
		String password = "Johndope1";
		
		if (connection == null || connection.isClosed()) {		
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
		
	}

}

//public class ConnectionUtil{
//	private static Connection connection;
//	
//	public static Connection getConnection() throws SQLException, IOException,SQLException{
//		if(connection == null || connection.isClosed()) {
//			String filename = "connection.properties";
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			ClassLoader loader = Thread.currentThread().getContextClassLoader();
//			
//				Properties properties = new Properties();
//				properties.load(loader.getResourceAsStream(filename));
//				String url = properties.getProperty("url");
//				String username = properties.getProperty("username");
//				String password = properties.getProperty("password");
//				connection = DriverManager.getConnection(url, username, password);	
//			}
//		return connection;
//	}
//	
//}
//
//
//
//
//import java.util.Properties;
//
//public class ConnectionUtil {
////	private static Connection connection;
////	public static Connection getHardCodedConnect() throws SQLException{
////		String url = "jdbc:oracle:thin:@ogoexdb.c7c3jiumkydd.us-east-1.rds.amazonaws.com:1521:ORCL";
////		String username = "ogoextreme";
////		String password = "Johndope1";
////		if(connection == null || connection.isClosed()) {
////			connection = DriverManager.getConnection(url, username, password);
////		}
////		return DriverManager.getConnection(url,username,password);
////	}
//	public static Connection getConnection() throws IOException, SQLException{
//		Properties prop = new Properties();
//		String path = "/Users/Moses/Documents/1805-May21-Java/batch-source/Reimbursement/connection.properties";
//		InputStream in = new FileInputStream(path);
//		prop.load(in);
//		String url = prop.getProperty("url");
//		String username = prop.getProperty("username");
//		String password = prop.getProperty("password");
//		return DriverManager.getConnection(url, username, password);
////		return DriverManager.getConnection("jdbc:oracle:thin:@ogoexdb.c7c3jiumkydd.us-east-1.rds.amazonaws.com:1521:ORCL", "ogoextreme", "Johndope1");
//
//	}
//}
