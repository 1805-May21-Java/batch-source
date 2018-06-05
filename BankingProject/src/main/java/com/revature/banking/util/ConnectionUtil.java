package com.revature.banking.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Connection connect;

	public static Connection getConnection() throws SQLException, IOException {
		if(connect==null) {
			Properties props=new Properties();
			FileInputStream fileInput=new FileInputStream(new File("connection.properties"));
			props.load(fileInput);
			connect=DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("pass"));
		}
		
		return connect;
	}
	
	
	
	

}
