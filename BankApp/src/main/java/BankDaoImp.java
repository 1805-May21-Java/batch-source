import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;



public class BankDaoImp {
private static Connection connection;
	
	
	private Connection connect() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		if(connection == null) {
			connection = DriverManager.getConnection(url,username,password);
		}
		return connection;
	}
	//create account
	int addAccount(String firstName, String lastName, String ssn, AccountType accountType, double balance) {
	  int userId = -1;
	  int accountId = -1;
	  
	try {
	Connection	connection = connect();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  try { 
		//add user
		connection.setAutoCommit(false);
		String addUserSql = "INSERT INTO USERS(FIRSTNAME, LASTNAME, SSN) VALUES (?,?,?)";
		PreparedStatement addUser = connection.prepareStatement(addUserSql, Statement.RETURN_GENERATED_KEYS);
		addUser.setString(1, firstName);
		addUser.setString(2, lastName);
		addUser.setString(3, ssn);
		addUser.executeUpdate();
		ResultSet addUserRs = addUser.getGeneratedKeys();
		if(addUserRs.next()) {
			userId = addUserRs.getInt(1);
		}
		
		//add account
		String addAccountSql = "INSERT INTO ACCOUNTS(ACCOUNT_TYPE, BALANCE) VALUES (?,?)";
		PreparedStatement addAccount = connection.prepareStatement(addAccountSql, Statement.RETURN_GENERATED_KEYS);
		addAccount.setString(1, accountType.name());
		addAccount.setDouble(2, balance);
		ResultSet addAccountRs = addAccount.getGeneratedKeys();
		if(addAccountRs.next()) {
			accountId = addAccountRs.getInt(1);
		}
		//link user to account
		if (userId > 0 && accountId > 0) {
			String linkSql = "INSERT INTO LINKED(ACCOUNTID,USERID) VALUES (?,?)";
			PreparedStatement linkAccount = connection.prepareStatement(linkSql);
			linkAccount.setInt(1,userId);
			linkAccount.setInt(2, accountId);
			linkAccount.executeUpdate();
			connection.commit();
		} else {
			connection.rollback();
		}
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.err.println("An error has occured " + e.getMessage());
		e.printStackTrace();
	}
	  return accountId;
  }
	Customer getAccount(int accountId) {
		Customer customer = null;
        try {
			Connection connection = connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
        	String findUserSql = "SELECT FIRSTNAME,LASTNAME,SSN,ACCOUNT_TYPE,BALANCE "
		        + "FROM USERS A JOIN LINKED B ON A.USER_ID = B.USERID "
		        + "JOIN ACCOUNTS C ON B.ACCOUNTID = C.ACCOUNT_ID "
		        + "WHERE C.ACCOUNT_ID = ?";
        	
			PreparedStatement findUser = connection.prepareStatement(findUserSql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
