package com.revature.accountGrouping;

import java.io.Serializable;

public class Account implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -809462251539502495L;
	
	private String userName;
	private Double balance;
	
	public Account()
	{
		super();
	}

	public Account(String userName)
	{
		super();
		this.userName = userName;
		balance = 0.0;
	}

	public String getUserName()
	{
		return userName;
	}

	public double getBalance()
	{
		return balance;
	}

	public void deposit(double depositValue)
	{
		balance += depositValue;
	}
	
	public void withdraw(double withdrawValue)
	{
		balance -= withdrawValue;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (userName == null)
		{
			if (other.userName != null)
				return false;
		}
		else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Account: " + userName + "\n balance:" + balance;
	}
}
