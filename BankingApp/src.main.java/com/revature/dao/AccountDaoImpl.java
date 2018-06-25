package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;
import com.revature.util.HibernateUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> getAccounts() {
		
		Session session = HibernateUtil.getSession();
		List<Account> accountList = session.createQuery("from Account").list();
		session.close();
		
		
//		List<Account> accountList = new ArrayList<Account>();
//		
//		// connect to the database
//		try {
//			Connection con = ConnectionUtil.getHardcodedConnection();
//			String sql = "SELECT * FROM ACCOUNT"; // get all entries in Account
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);
//			
//			// loop thru result set and add to accountList
//			while (rs.next()) {
//				int accountId = rs.getInt("ACC_ID");
//				String username = rs.getString("ACC_USERNAME");
//				String password = rs.getString("ACC_PASSWORD");
//				double balance = rs.getDouble("ACC_BALANCE");
//				
//				accountList.add(new Account(accountId, username, password, balance));
//			}
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return accountList;
	}

	
	@Override
	public Account getAccountById(int id) {
		
		Session session = HibernateUtil.getSession();
		Account account = (Account) session.get(Account.class, id);
		session.close();
		return account;
		
//		Account a = null;
//		
//		try {
//			Connection con = ConnectionUtil.getHardcodedConnection();
//			String sql = "SELECT * FROM ACCOUNT WHERE ACC_ID = ?"; // select desired account
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				int accountId = rs.getInt("ACC_ID");
//				String username = rs.getString("ACC_USERNAME");
//				String password = rs.getString("ACC_PASSWORD");
//				double balance = rs.getDouble("ACC_BALANCE");
//				
//				a = new Account(accountId, username, password, balance);
//			}
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return a;
	}

	@Override
	public void createAccount(Account account) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(account);
		transaction.commit();
		session.close();
		
//		int accountCreated = 0;
//		try {
//			Connection con = ConnectionUtil.getHardcodedConnection();
//			String sql = "INSERT INTO ACCOUNT (ACC_USERNAME, ACC_PASSWORD, ACC_BALANCE) VALUES (?,?,?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, account.getUsername());
//			ps.setString(2, account.getPassword());
//			ps.setDouble(3, account.getBalance());
//			accountCreated = ps.executeUpdate();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return accountCreated;
	}


	@Override
	public void updateAccount(Account account) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(account);
		transaction.commit();
		session.close();
		
//		System.out.println("Inside updateAccount");
//		
//		int accountUpdated = 0;
//		String sql = "UPDATE ACCOUNT SET ACC_BALANCE = ? WHERE ACC_ID = ?";
//		try {
//			Connection con = ConnectionUtil.getHardcodedConnection();
//			//con.setAutoCommit(false);
//			PreparedStatement pstatement = con.prepareStatement(sql);
//			pstatement.setDouble(1, account.getBalance());
//			pstatement.setInt(2, account.getId());
//			accountUpdated = pstatement.executeUpdate();
//			//con.commit();
//			con.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return accountUpdated;
	
	}


	@Override
	public int deleteAccountById(int id) {
		
		int rowsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getHardcodedConnection();
			con.setAutoCommit(false);
			String sql = "{call DELETE_ACCOUNT (?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, id);
			rowsUpdated = cs.executeUpdate();
			cs.close();
			con.commit();
			con.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

}
