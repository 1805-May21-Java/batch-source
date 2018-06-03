package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{

	public List<Account> getAccounts() {
		List<Account> accountList = new ArrayList<Account>();
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKACCOUNT";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				long accountNumber = rs.getLong("ACCTNUMBER");
				double balance = rs.getDouble("ACCTBALANCE");
				List<Integer> jointUsers = new ArrayList<Integer>();
				
				String s2 = "SELECT USERID FROM BANKUSER_BANKACCOUNT WHERE ACCTNUMBER = ?";
				PreparedStatement ps = conn.prepareStatement(s2);
				ps.setLong(1, accountNumber);
				ResultSet rs2 = ps.executeQuery();
				while (rs2.next()) {
					jointUsers.add(rs2.getInt("USERID"));
				}
				
				accountList.add(new Account(accountNumber, balance, jointUsers));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	public List<Account> getAccountsByUser(int userId) {
		List<Account> accountList = new ArrayList<Account>();
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT A.ACCTNUMBER, A.ACCTBALANCE FROM BANKACCOUNT A LEFT JOIN BANKUSER_BANKACCOUNT B ON A.ACCTNUMBER = B.ACCTNUMBER WHERE B.USERID = " + userId;
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Long accountNumber = rs.getLong("ACCTNUMBER");
				double balance = rs.getDouble("ACCTBALANCE");
				List<Integer> jointUsers = new ArrayList<Integer>();
				
				String s2 = "SELECT USERID FROM BANKUSER_BANKACCOUNT WHERE ACCTNUMBER = ?";
				PreparedStatement ps = conn.prepareStatement(s2);
				ps.setLong(1, accountNumber);
				ResultSet rs2 = ps.executeQuery();
				while (rs2.next()) {
					jointUsers.add(rs2.getInt("USERID"));
				}
				accountList.add(new Account(accountNumber, balance, jointUsers));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accountList;
	}

	public Account getAccountByNumber(long accountNumber) {
		Account a = null;
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKACCOUNT WHERE ACCTNUMBER = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1,  accountNumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				double balance = rs.getDouble("ACCTBALANCE");
				List<Integer> jointUsers = new ArrayList<Integer>();
				
				String s2 = "SELECT USERID FROM BANKUSER_BANKACCOUNT WHERE ACCTNUMBER = ?";
				PreparedStatement ps2 = conn.prepareStatement(s2);
				ps2.setLong(1, accountNumber);
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					jointUsers.add(rs2.getInt("USERID"));
				}
				a = new Account(accountNumber, balance, jointUsers);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	public int createAccount(Account account, int userId) {
		int accountCreated = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			/*
			 * 
			 * CREATE OR REPLACE PROCEDURE LINK_NEW_ACCOUNT (UID IN NUMBER, AMOUNT IN NUMBER)
			 * IS 
			 * N NUMBER;
			 * BEGIN
			 * 		-- INSERTING INTO BANK ACOUNT WHICH CREATES AN ACCOUNT NUMBER THAT ISN'T IN BANKUSER_BANKACCOUNT
			 * 		INSERT INTO BANKACCOUNT (ACCTBALANCE) VALUES(AMOUNT);
			 * 
			 * 		-- USE THE INFORMATION THAT WE ONLY HAVE THE NUMBER IN BANKACOUNT AND NOT BANKUSER_BANKACCOUNT TO GET THE NEW ACCOUNT NUMBER
			 * 	    -- THIS IS FUNCTIONAL IF AND ONLY IF THIS IS THE ONLY CALL TO INSERT INTO THE TABLE
			 * 	    SELECT ACC.ACCTNUMBER
			 * 	    INTO N
			 * 	    FROM BANKACCOUNT ACC
			 * 	    LEFT JOIN BANKUSER_BANKACCOUNT REL
			 * 	    ON ACC.ACCTNUMBER = REL.ACCTNUMBER
			 * 	    WHERE REL.ACCTNUMBER IS NULL;
			 * 
			 *      -- LINKING ACCOUNTS
			 *      INSERT INTO BANKUSER_BANKACCOUNT VALUES (UID, N);
			 *      
			 *      COMMIT;
			 * END;
			 * 
			 */
			String sql = "{call LINK_NEW_ACCOUNT(?,?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, userId);
			cs.setDouble(2, account.getBalance());
			cs.execute();
			
			accountCreated = 1;
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accountCreated;
	}

	public int updateAccount(Account account) {
		int accountUpdated = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "UPDATE BANKACCOUNT " +
								"SET ACCTBALANCE = ? " +
								"WHERE ACCTNUMBER = ?";	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setLong(2, account.getAccountNumber());
			accountUpdated = ps.executeUpdate();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accountUpdated;
	}

	public int deleteAccount(int accountNumber) {
		int accountDeleted = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "DELETE FROM BANKACCOUNT WHERE ACCTNUMBER = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, accountNumber);
			accountDeleted = ps.executeUpdate();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accountDeleted;
	}

}
