package project0.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project0.interfaces.AccountInterface;

public class AccountDao implements AccountInterface {

	private String insertAccount = "INSERT INTO Account (accountID) values (seq_pk_accountID.nextval)";
	private String getBalanceQuery = "SELECT Balance FROM Account where accountID = ?";
	private String updateBalanceQuery = "UPDATE Account set balance = ? where accountID = ?";
	private String getAccount = "SELECT * FROM Account where accountId = ?";

	@Override
	public double updateBalance(Connection connection, long accountId, double bloops) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(getBalanceQuery);
		ps.setLong(1, accountId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		double balance = rs.getDouble(1);
		ps = connection.prepareStatement(updateBalanceQuery);
		ps.setDouble(1, bloops + balance);
		ps.setLong(2, accountId);
		ps.executeUpdate();
		return bloops + balance;
	}

	@Override
	public double getBalance(Connection connection, long accountId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(getBalanceQuery);
		ps.setLong(1, accountId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getDouble(1);
	}

	@Override
	public long createAccount(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(insertAccount, new String[] {"accountID"});
		ps.executeUpdate();
		ps.getGeneratedKeys().next();
		return ps.getGeneratedKeys().getLong(1);
	}

	@Override
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
	
	public ArrayList<Account> getAccountList(Connection connection) throws SQLException{
		ArrayList<Account> accountList = new ArrayList();
		String statement = "Select * from Usertable";
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery(statement);
		while(rs.next()){
			accountList.add(new Account(rs.getLong("accountId"), rs.getLong("balance")));
		}
		return accountList;
		
	}
	

}
