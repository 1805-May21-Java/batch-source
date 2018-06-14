package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection connection;
	
	public static Connection getConnection() throws IOException, SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@ersdatabase.camswdktogrj.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username = "sydneymercier";
		String password = "classof2009";
		
		if (connection == null || connection.isClosed()) {		
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
		
	}

}
