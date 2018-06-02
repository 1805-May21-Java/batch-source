package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.pojos.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao
{
	public void createAccount(String username)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ACCOUNT(USERNAME) VALUES(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
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

	public void changePassword(String username, String password)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE ACCOUNT SET PASSWORD=? WHERE USERNAME=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
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

	/**
	 * Returns the account associated with the passed username iff that account has no password
	 * If there is no such account or that account has a password, it passes null
	 */
	public Account logIn(String username)
	{
		Account acc = null;
		
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNT WHERE USERNAME=? AND PASSWORD IS NULL";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				double balance = rs.getDouble("BALANCE");
				acc = new Account(username, balance);
			}
			
			con.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return acc;
	}

	public Account logIn(String username, String password)
	{
		Account acc = null;
		
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNT WHERE USERNAME=? AND PASSWORD=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				double balance = rs.getDouble("BALANCE");
				acc = new Account(username, password, balance);
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
		
		return acc;
	}

	public void changeBalance(String username, double value)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE USERNAME=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, value);
			ps.setString(2, username);
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

	public double getBalance(String username)
	{
		double balance = 0;
		
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT BALANCE FROM ACCOUNT WHERE USERNAME=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				balance = rs.getDouble("BALANCE");
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
		
		return balance;
	}

	/**
	 * Checks whether the input name is both not just a string of spaces and that it doesn't already 
	 * exist in the table
	 */
	public boolean isValidUsername(String username)
	{
		String temp = username.trim();
		if(temp.length() <= 0)
			return false;
		try
		{
			Connection con = ConnectionUtil.getConnection();
			int output;
			String sql = "{call IS_UNIQUE_USERNAME(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.registerOutParameter(2, java.sql.Types.NUMERIC);
			cs.executeQuery();
			output = cs.getInt(2);
			
			con.close();

			if(output == 0)
			{
				return false;
			}
			return true;
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

	/**
	 * Checks if there is an account with the given username that has a password
	 */
	public boolean hasPassword(String username)
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT PASSWORD FROM ACCOUNT WHERE USERNAME=? AND PASSWORD IS NOT NULL";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
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

	public boolean accountsExist()
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNT";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			//If there are any accounts, return true
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
}
