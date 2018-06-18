package project0.src.main.java.project0.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project0.src.main.java.project0.data.Account;


public class DatabaseThings {

	private String insertUser = "INSERT INTO Usertable (userId, userName, password, accountId) values (seq_pk_userId.nextval, ?, ?, ?)";
	private String insertAccount = "INSERT INTO Account (accountID) values (seq_pk_accountID.nextval)";
	private String getBalanceQuery = "SELECT Balance FROM Account where accountID = ?";
	private String updateBalanceQuery = "UPDATE Account set balance = ? where accountID = ?";
	private String checkUser = "SELECT * FROM userTable where username = ?";
	private String getAccount = "SELECT * FROM Account where accountId = ?";
			
	public long createAccount(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(insertAccount, new String[] {"accountID"});
		ps.executeUpdate();
		ps.getGeneratedKeys().next();
		return ps.getGeneratedKeys().getLong(1);
	}
	
	public long getBalance(Connection connection, long accountId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(getBalanceQuery);
		ps.setLong(1, accountId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getLong(1);
	}
	public long updateBalance(Connection connection, long accountId, long value) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(getBalanceQuery);
		ps.setLong(1, accountId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		long balance = rs.getLong(1);
		ps = connection.prepareStatement(updateBalanceQuery);
		ps.setLong(1, value + balance);
		ps.setLong(2, accountId);
		ps.executeUpdate();
		return balance + value;
	}
	
	public long createUser(Connection connection, String username, String password) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(insertUser, new String[] {"userID"});
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setLong(3, createAccount(connection));
		ps.executeUpdate();
		ps.getGeneratedKeys().next();
		return ps.getGeneratedKeys().getLong(1);
	}
	
	public boolean checkUser(Connection connection, String username) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(checkUser);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			return true;
		} else return false;
	}
	
	public Account getAccountById(Connection connection, long accountId) throws SQLException {
		Account returnAccount = null;
		PreparedStatement ps = connection.prepareStatement(getAccount);
		ps.setLong(1, accountId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			returnAccount = new Account(rs.getLong("accountId"), rs.getLong("balance"));
		}
		return returnAccount;
	}
}
