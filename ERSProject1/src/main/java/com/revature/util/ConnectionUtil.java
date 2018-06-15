package com.revature.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.OracleDriver;
//most of this is unchanged from the examples last Friday
public class ConnectionUtil {
	public static Connection getConnection() throws IOException, SQLException {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username = "ers";
		String password = "password";
		OracleDriver dr = new OracleDriver();
	DriverManager.registerDriver(dr);
	return DriverManager.getConnection(url, username, password);
	}

}