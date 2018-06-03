package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {
	private static Connection connection;
	public static Connection getHardcodedConnection() throws SQLException {
		String host = "jdbc:oracle:thin:@keandredb.c7c3jiumkydd.us-east-1.rds.amazonaws.com:1521:ORCL";
		String uName = "ogoextreme";
		String pass = "password";
		if(connection == null) {
			connection = DriverManager.getConnection(host, uName, pass);
		}
		return connection;
	}
	public static Connection getConnection() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(connection == null) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
}
