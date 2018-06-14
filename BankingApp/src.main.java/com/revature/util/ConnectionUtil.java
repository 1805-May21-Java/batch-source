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
		
		String url = "jdbc:oracle:thin:@revaturedb.cv36tvcn8gsq.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "robosyd";
		String password = "classof2009";
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnection() throws IOException, SQLException {
		
		// added later
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader(); // added later
		prop.load(loader.getResourceAsStream("connection.properties")); //added later
//		InputStream in = new FileInputStream("connection.properties");
//		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		//added later
		if(connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(url, username, password);
		}
		//return DriverManager.getConnection(url, username, password);
		return connection; //added later
	}

}
