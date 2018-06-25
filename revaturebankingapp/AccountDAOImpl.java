package com.revature.revaturebankingapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.Employee;
import com.revature.utilities.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	//Method to update balance with account ID and balance input
	@Override
	public void updateBalance(int accountid, double balance) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Query q = s.createSQLQuery("UPDATE RBA_ACCOUNT SET BALANCE = ? WHERE ACCOUNTID = ?").addEntity(Account.class);
		q.setDouble(0, balance);
		q.setDouble(1, accountid);
		q.executeUpdate(); //?????
		tx.commit();
		//s.close();
		
//		int accountCreated = 0;
//		try {
//			Connection con = ConnectionUtility.getConnection();
//			String sql = "UPDATE RBA_ACCOUNT SET BALANCE = ? WHERE ACCOUNTID = ?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setDouble(2, accountid);
//			ps.setDouble(1, balance);
//			
//			accountCreated = ps.executeUpdate();
//			
//		} catch (IOException | SQLException e) {
//			e.printStackTrace();
//		}
		
	}

	//Method to return balance with account ID input
	@Override
	public double balanceInquiry(int id) {
		double accountBalance = 0;
		Session s = HibernateUtil.getSession();
		Account a = (Account) s.get(Account.class, id);
		accountBalance = a.getBalance();
		s.close();
		
//		try {
//			Connection con = ConnectionUtility.getConnection();
//			String sql = "SELECT BALANCE FROM RBA_ACCOUNT WHERE ACCOUNTID = ?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				accountBalance = rs.getDouble("BALANCE");
//			}
//			
//		} catch (IOException | SQLException e) {
//			e.printStackTrace();
//		}
//		//System.out.println(accountBalance);
		
		return accountBalance;
	}

	//Method to return all accounts associated with user
	@Override
	public ArrayList<Account> getAccountsByUserId(int id) {
			ArrayList<Account> accounts = new ArrayList<Account>();
			Session s = HibernateUtil.getSession();
			String hql = "from Account where USERID= ?";
			org.hibernate.Query q = s.createQuery(hql);
			q.setInteger(0, id);
			
			accounts = (ArrayList<Account>) q.list();
			s.close();
			
//		try {
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM RBA_ACCOUNT WHERE USERID = ?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1,  user.getAccountid());
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				accounts.add(new Account(rs.getInt("ACCOUNTID"), rs.getString("ACCOUNTTYPE"), rs.getDouble("BALANCE"), rs.getInt("USERID")));
//			}
//			
//			for (Account a : accounts) {
//			    System.out.println(a);
//			}
//			
//		} catch (IOException | SQLException e1) {
//			e1.printStackTrace();
//		}
		return accounts;
		
	}

	//Method to add new account associated with user
	@Override
	public void addAccount(Account account) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Account a1 = new Account(account.getAccounttype(), account.getBalance(), account.getUserid());
		s.save(a1);
		tx.commit();
		s.close();
		
//		try {
//			Connection con = ConnectionUtility.getConnection();
//			String sql = "INSERT INTO RBA_ACCOUNT (ACCOUNTID, ACCOUNTTYPE, BALANCE, USERID) VALUES (?,?,?,?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, account.getAccountid());
//			ps.setString(2, account.getAccounttype());
//			ps.setDouble(3, account.getBalance());
//			ps.setInt(4, account.getUserid());
//			
//			accountCreated = ps.executeUpdate();
//			
//		} catch (IOException | SQLException e) {
//			e.printStackTrace();
//		}
		
	}

	

}
