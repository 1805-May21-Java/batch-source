package com.revature.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//most of this is unchanged from the examples last Friday
public class ConnectionUtil {
	private static Connection con;
	public static Connection getConnection() throws IOException, SQLException {
		Properties prop =  new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(con == null || con.isClosed()) { //except isClosed as another way to get the DriverManager thing
			con = DriverManager.getConnection(url, username, password);
		}
		return con;
	}

}