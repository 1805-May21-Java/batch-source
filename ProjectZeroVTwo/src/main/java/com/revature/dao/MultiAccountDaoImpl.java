package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.*;
import com.revature.util.ConnectionUtil;
import com.revature.util.HibernateUtil;

public class MultiAccountDaoImpl implements MultiAccountDao
{

	public MultiAccount getAccountByType(String type, String username)
	{
//		MultiAccount account = null;
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM MULTI_ACCOUNT WHERE USERNAME=? AND ACCT_TYPE=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, username);
//			ps.setString(2, type);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				double balance = rs.getDouble("BALANCE");
//				account = new MultiAccount(username, type, balance);
//			}
//			
//			con.close();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		
//		return account;
		
		Session s = HibernateUtil.getSession();
		String hql = "from MultiAccount where username=:userVar and accountType=typeVar";
		Query q = s.createQuery(hql);
		q.setString("userVar", username);
		q.setString("typeVar", type);
		List<MultiAccount> accts = q.list();
		s.close();
		if(!accts.isEmpty()) {
			return accts.get(0);
		}
		return null;
	}

	public double getAccountBalance(String type, String username)
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT BALANCE FROM MULTI_ACCOUNT WHERE ACCT_TYPE=? AND USERNAME=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, type);
//			ps.setString(2, username);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				return rs.getDouble("BALANCE");
//			}
//			
//			con.close();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return 0;
		
		Session s = HibernateUtil.getSession();
		String hql = "from MultiAccount where accountType=:typeVar and username=:userVar";
		Query q = s.createQuery(hql);
		q.setString("typeVar", type);
		q.setString("userVar", username);
		MultiAccount acct = (MultiAccount)q.list().get(0);
		s.close();
		return acct.getBalance();
	}

	public void createAccount(String type, String username)
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "INSERT INTO MULTI_ACCOUNT(USERNAME, ACCT_TYPE) VALUES(?,?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, username);
//			ps.setString(2, type);
//			ps.executeUpdate();
//			
//			con.close();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(new MultiAccount(username, type));
		tx.commit();
		s.close();
	}

	public void changeBalance(String type, String username, double value)
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "UPDATE MULTI_ACCOUNT SET BALANCE=BALANCE+? WHERE USERNAME=? AND ACCT_TYPE=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setDouble(1, value);
//			ps.setString(2, username);
//			ps.setString(3, type);
//			ps.executeUpdate();
//			
//			con.close();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		MultiAccount acct = new MultiAccount(username, type, value);
		s.update(acct);
		tx.commit();
		s.close();
	}

	public boolean acctsExits(String username)
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM MULTI_ACCOUNT WHERE USERNAME=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				return true;
//			}
//			
//			con.close();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return false;
		
		Session s = HibernateUtil.getSession();
		String hql = "from MultiAccount where username=:userVar";
		Query q = s.createQuery(hql);
		q.setString("userVar", username);
		List<MultiAccount> accts = q.list();
		s.close();
		return !accts.isEmpty();
	}

	public boolean accountTypeExists(String type, String username)
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT ACCT_TYPE FROM MULTI_ACCOUNT WHERE ACCT_TYPE=? AND USERNAME=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, type);
//			ps.setString(2, username);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				con.close();			
//				return true;
//			}
//			
//			con.close();
//			return false;
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return false;
		
		Session s = HibernateUtil.getSession();
		String hql = "from MULTI_ACCOUNT where username=:userVar and ACCT_TYPE=:typeVar";
		Query q = s.createQuery(hql);
		q.setString("userVar", username);
		q.setString("typeVar", type);
		List<MultiAccount> accts = q.list();
		s.close();
		
		return !accts.isEmpty();
	}

	public boolean isValidType(String type, String username)
	{
		String temp = type.trim();
		if(temp.length() <= 0)
			return false;
		return !accountTypeExists(type, username);
	}

}
