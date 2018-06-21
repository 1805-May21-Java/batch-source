package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

		private static Connection connection;
	
		public static Connection getConnection() throws IOException, SQLException {
		
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		};
		
//		Properties prop = new Properties();
//		InputStream in = new FileInputStream("connection.properties");
//		prop.load(in);
		String url =  "jdbc:oracle:thin:@projectone.ckbbyw2sarv3.us-east-2.rds.amazonaws.com:1521:ORCL"; //prop.getProperty("url");
		String username = "rfwilliams11";  //prop.getProperty("username");
		String password =  "152145Ree$e"; //prop.getProperty("password");
		if(connection == null) {
			connection = DriverManager.getConnection(url, username, password);
			//System.out.println("hello");
		}
		return connection;
	}
}
