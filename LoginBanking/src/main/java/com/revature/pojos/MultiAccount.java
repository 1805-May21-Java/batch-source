package com.revature.pojos;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MultiAccount
{
	NumberFormat formatter = new DecimalFormat("#0.00");
	
	private String username;
	private String accountType;
	private double balance;
	
	public MultiAccount()
	{
		super();
	}

	public MultiAccount(String username, String accountType, double balance)
	{
		super();
		this.username = username;
		this.accountType = accountType;
		this.balance = balance;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getAccountType()
	{
		return accountType;
	}

	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MultiAccount other = (MultiAccount) obj;
		if (accountType == null)
		{
			if (other.accountType != null)
				return false;
		}
		else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
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
		return accountType + " account has a balance of $" + formatter.format(balance);
	}
}
