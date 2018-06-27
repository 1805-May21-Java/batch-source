package com.revature.dao;

import java.io.IOException;

import java.sql.*;
import java.util.*;

import org.hibernate.*;

import com.revature.pojos.*;
import com.revature.util.ConnectionUtil;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao
{
	public List<MultiAccount> getAccountsByUser(String username)
	{
//		ArrayList<MultiAccount> accountList = new ArrayList<MultiAccount>();
//		
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
//				String acctType = rs.getString("ACCT_TYPE");
//				double balance = rs.getDouble("BALANCE");
//				accountList.add(new MultiAccount(username, acctType, balance));
//			}
//			
//			con.close();
//			return accountList;
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		return null;
		
		Session s = HibernateUtil.getSession();
		String hql = "from MultiAccount where username=:userVar";
		Query q = s.createQuery(hql);
		q.setString("userVar", username);
		List<MultiAccount> accts = q.list();
		s.close();
		return accts;
	}

	public boolean nameExists(String username)
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			int output;
//			String sql = "{call IS_UNIQUE_USERNAME_MULTI(?,?)}";
//			CallableStatement cs = con.prepareCall(sql);
//			cs.setString(1, username);
//			cs.registerOutParameter(2, java.sql.Types.NUMERIC);
//			cs.executeQuery();
//			output = cs.getInt(2);
//						
//			con.close();
//			if(output == 0)
//			{
//				return true;
//			}
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
		String hql = "from User where username=:userVar";
		Query q = s.createQuery(hql);
		q.setString("userVar", username);
		List<User> users = q.list();
		s.close();
		return !users.isEmpty();
	}

	public boolean isValidName(String username)
	{
		String shortened = username.trim();
		if(shortened.length() <= 0)
		{
			return false;
		}
		return !nameExists(username);
	}

	public void changePassword(String password, String username)
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "UPDATE USERS SET PASSWORD=? WHERE USERNAME=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, password);
//			ps.setString(2, username);
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
		s.update(new User(username, password));
		tx.commit();
		s.close();
	}

	public void createUser(String username)
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "INSERT INTO USERS(USERNAME) VALUES(?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, username);
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
		s.save(new User(username));
		tx.commit();
		s.close();
	}

	public List<String> getAcctTypByName(String username)
	{
//		ArrayList<String> accountTypes = new ArrayList<String>();
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT ACCT_TYPE FROM MULTI_ACCOUNT WHERE USERNAME=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				accountTypes.add(rs.getString("ACCT_TYPE"));
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
//		return accountTypes;
		
		Session s = HibernateUtil.getSession();
		String hql = "from MultiAccount where username=:userVar";
		Query q = s.createQuery(hql);
		q.setString("userVar", username);
		List<MultiAccount> accts = q.list();
		s.close();
		
		ArrayList<String> results = new ArrayList<String>();
		for(MultiAccount acct : accts) {
			results.add(acct.getAccountType());
		}
		return results;
	}

	public User logIn(String username)
	{
//		User user = null;
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD IS NULL";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				user = new User(username);
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
//		return user;
		
		Session s = HibernateUtil.getSession();
		String hql = "from User where username=:userVar and password is null";
		Query q = s.createQuery(hql);
		List<User> users = q.list();
		User result = null;
		if(!users.isEmpty()) {
			result = (User)q.list().get(0);
		}
		s.close();
		return result;
	}

	public User logIn(String username, String password)
	{
//		User user = null;
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, username);
//			ps.setString(2, password);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				user = new User(username, password);
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
//		return user;
		
		Session s = HibernateUtil.getSession();
		String hql = "from User where username=:userVar and password=:passVar";
		Query q = s.createQuery(hql);
		q.setString("userVar", username);
		q.setString("passVar", password);
		List<User> users = q.list();
		s.close();
		
		if(!users.isEmpty())
		{
			return users.get(0);
		}
		return null;
	}

	public boolean hasPassword(String username)
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD IS NOT NULL";
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
		
		return ((this.nameExists(username)) && (this.logIn(username) != null));
	}

	public boolean usersExist()
	{
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM USERS";
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);
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
//		
//		return false;
		
		Session s = HibernateUtil.getSession();
		String hql = "from User";
		Query q = s.createQuery(hql);
		List<User> users = q.list();
		s.close();
		return !users.isEmpty();
	}

	public boolean hasAccounts(String username)
	{
		List<MultiAccount> accounts = this.getAccountsByUser(username);
		return accounts.size() != 0;
	}
}
