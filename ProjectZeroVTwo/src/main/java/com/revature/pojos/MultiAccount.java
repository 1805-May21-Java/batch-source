package com.revature.pojos;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MULTI_ACCOUNT")
public class MultiAccount implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1405186840794255938L;

	NumberFormat formatter = new DecimalFormat("#0.00");
	
	@Id
	@Column
	private String username;
	@Id
	@Column(name="ACCT_TYPE")
	private String accountType;

	@Column
	private double balance;

	public MultiAccount(String username, String accountType)
	{
		super();
		this.username = username;
		this.accountType = accountType;
		balance = 0;
	}

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
