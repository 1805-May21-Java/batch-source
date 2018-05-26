package com.revature.accountGrouping;

import java.io.Serializable;

public class Account implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8563499367251149658L;
	
	private String username;
	private String name;
	private Double balance = 0.0;
	private String password;
	
	public Account()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String username, String name, String password)
	{
		super();
		this.username = username;
		this.name = name;
		this.balance = balance;
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Double getBalance()
	{
		return balance;
	}

	public void withdraw(Double withdrawl)
	{
		this.balance -= withdrawl;
	}
	
	public void deposit(Double depositValue)
	{
		this.balance += depositValue;
	}

	public boolean isPassword(String password)
	{
		return this.password.equals(password);
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Account other = (Account) obj;
		if (balance == null)
		{
			if (other.balance != null)
				return false;
		}
		else if (!balance.equals(other.balance))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
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
		return name + ":" + username + ":" + password + ":" + balance;
	}
}
