package com.revature.dao;

import java.io.IOException;
import java.sql.*;

import com.revature.pojos.*;
import com.revature.util.ConnectionUtil;

public class MultiAccountDaoImpl implements MultiAccountDao
{

	public MultiAccount getAccountByType(String type, String username)
	{
		MultiAccount account = null;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM MULTI_ACCOUNT WHERE USERNAME=? AND ACCT_TYPE=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, type);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				double balance = rs.getDouble("BALANCE");
				account = new MultiAccount(username, type, balance);
			}
			
			con.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return account;
	}

	public double getAccountBalance(String type, String username)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT BALANCE FROM MULTI_ACCOUNT WHERE ACCT_TYPE=? AND USERNAME=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, type);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				return rs.getDouble("BALANCE");
			}
			
			con.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public void createAccount(String type, String username)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO MULTI_ACCOUNT(USERNAME, ACCT_TYPE) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, type);
			ps.executeUpdate();
			
			con.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void changeBalance(String type, String username, double value)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE MULTI_ACCOUNT SET BALANCE=BALANCE+? WHERE USERNAME=? AND ACCT_TYPE=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, value);
			ps.setString(2, username);
			ps.setString(3, type);
			ps.executeUpdate();
			
			con.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public boolean acctsExits()
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM MULTI_ACCOUNT";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				return true;
			}
			
			con.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean accountTypeExists(String type, String username)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT ACCT_TYPE FROM MULTI_ACCOUNT WHERE ACCT_TYPE=? AND USERNAME=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, type);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				con.close();			
				return true;
			}
			
			con.close();
			return false;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean isValidType(String type, String username)
	{
		String temp = type.trim();
		if(temp.length() <= 0)
			return false;
		return !accountTypeExists(type, username);
	}

}
