package com.revature.dao;
import java.util.List;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.pojos.Account;
import com.revature.util.ConnectionUtil;
public class AccountDAOImpl implements AccountDAO {
	@Override
	public List<Account> listAllAccounts() {
		List<Account> accts = new ArrayList(); //need an array list
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNT"; //SQL statement for selecting account
			Statement st = con.createStatement(); //here's where we use a statement
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				accts.add(new Account( //USR, USERNAME, PWORD, BALANCE
				rs.getString("USR"), //USER is a SQL keyword
				rs.getString("USERNAME"),
				rs.getString("PWORD"), //I found out PASSWORD is a keyword for some reason
				rs.getFloat("BALANCE"),
				false));
			}
			con.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return accts;
	}
	@Override
	public Account getAccountById(String username) { //get an account by the id
		Account ac = null; //set this to null
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNT WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql); //I prefer prepared statements!
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ac = new Account(
				rs.getString("USR"),
				rs.getString("USERNAME"),
				rs.getString("PWORD"),
				rs.getFloat("BALANCE"),
				false);
			}
			con.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return ac;
	}
	@Override
	public int createAccount(Account acct) {
		int acctCreate = 0; //initialize this variable
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ACCOUNT (USERNAME, USR, BALANCE, PWORD) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql); // because they remove SQL injection
			ps.setString(1, acct.getUsername());
			ps.setString(2, acct.getUsr());
			int temp = (int) (acct.getBalance()*100); //two temporary variables for the roundings
			float temp2 = (float)(temp)/100;	//a different way to round to two decimal places
			ps.setFloat(3, acct.getBalance()); // okay the rest should be easy
			ps.setString(4, acct.getPw());
			acctCreate = ps.executeUpdate();
			con.close();
		} catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		return acctCreate;
	}
	@Override
	public int updateAccount(Account acct) {
		int acctUpdate = 0; //basically the same as before but with different temp variables and SQL statements
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false); // also we'll need this, setAutoCommit is default to TRUE
			String sql = "UPDATE ACCOUNT SET USR = ?, BALANCE = ?, PWORD = ? WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(4, acct.getUsername());
			ps.setString(1, acct.getUsr());
			int temp = (int) (acct.getBalance()*100);
			float temp2 = (float)(temp)/100;
			ps.setFloat(2, temp2);
			ps.setString(3, acct.getPw());
			acctUpdate = ps.executeUpdate();
			con.commit(); // this is an update transaction, so we are committing this before closing the connection
			con.close();
		} catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		return acctUpdate;
	}
	@Override
	public int deleteAccount(String username) { //one last time, for delete
		int acctDelete = 0; //deleting updates our rows
		String sql = "{call DELETE_ACCOUNT (?)}";
		try { //deleteAccount by the way takes in the username as a parameter
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			CallableStatement cs = con.prepareCall(sql);	
			cs.setString(1, username);
			acctDelete = cs.executeUpdate();
			cs.close();
			con.commit(); //also a commit
			con.close();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return acctDelete;// this function is not necessarily required though.
	}
	
	public boolean checkUniqueUsername(String username) { //unused but it has my callable statement
		String tempString = username.trim();
		if(tempString.length() <= 0)
			return false;
		try {
			Connection con = ConnectionUtil.getConnection();
			int valid;
			String sql = "{call CHECK_UNIQUE_USERNAME(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.registerOutParameter(2, java.sql.Types.NUMERIC);
			cs.executeQuery();
			valid = cs.getInt(2);
			con.close();
			if(valid == 0) {// sorry this is not a valid username
				return false;
			}
			return true;
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return false; //default back to false if nothing happens
	}
}
