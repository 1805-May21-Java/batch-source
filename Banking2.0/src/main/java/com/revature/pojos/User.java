package com.revature.pojos;

import java.util.ArrayList;

public class User 
{


	private String username, password;
	private ArrayList<Integer> accounts;

	public User() 
	{
		this.accounts = new ArrayList<Integer>();
	}

	public User(String username, String password)
	{
		super();
		this.username = username;
		this.password = password;
		this.accounts = new ArrayList<Integer>();
	}
	
	public User(String username, String password, ArrayList<Integer> accounts) 
	{
		super();
		this.username = username;
		this.password = password;
		this.accounts = accounts;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public ArrayList<Integer> getAccounts()
	{
		return accounts;
	}

	public void setAccounts(ArrayList<Integer> accounts) 
	{
		this.accounts = accounts;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accounts == null) 
		{
			if (other.accounts != null)
				return false;
		}
		else if (!accounts.equals(other.accounts))
			return false;
		if (password == null) 
		{
			if (other.password != null)
				return false;
		}
		else if (!password.equals(other.password))
			return false;
		if (username == null) 
		{
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "User [username=" + username + ", password=" + password + ", accounts=" + accounts + "]";
	}
}
