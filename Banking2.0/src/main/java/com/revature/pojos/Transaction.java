package com.revature.pojos;

import java.sql.Date;
import java.text.DecimalFormat;

public class Transaction 
{

	//Define the format of our Decimals to prevent deposits/withdrawals 
	//of 1.000999 for example
	private static final DecimalFormat format = new DecimalFormat("#0.00");
	
	private String typeOfTransaction;
	private String user;
	private double amount;
	private double balance;
	private Date date;
	private int otherAccount;
	
	public Transaction() 
	{
		super();
	}

	public Transaction(String typeOfTransaction, String user, double amount, double balance, Date date, int otherAccount) 
	{
		super();
		this.typeOfTransaction = typeOfTransaction;
		this.user = user;
		this.amount = amount;
		this.balance = balance;
		this.date = date;
		this.otherAccount = otherAccount;
	}

	public String getTypeOfTransaction() 
	{
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) 
	{
		this.typeOfTransaction = typeOfTransaction;
	}

	public String getUser() 
	{
		return user;
	}

	public void setUser(String user) 
	{
		this.user = user;
	}

	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	

	public int getOtherAccount()
	{
		return otherAccount;
	}

	public void setOtherAccount(int otherAccount) 
	{
		this.otherAccount = otherAccount;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + otherAccount;
		result = prime * result + ((typeOfTransaction == null) ? 0 : typeOfTransaction.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (date == null) 
		{
			if (other.date != null)
				return false;
		}
		else if (!date.equals(other.date))
			return false;
		if (otherAccount != other.otherAccount)
			return false;
		if (typeOfTransaction == null) 
		{
			if (other.typeOfTransaction != null)
				return false;
		}
		else if (!typeOfTransaction.equals(other.typeOfTransaction))
			return false;
		if (user == null) 
		{
			if (other.user != null)
				return false;
		}
		else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "Transaction [typeOfTransaction=" + typeOfTransaction + ", user=" + user + ", amount=" + amount
				+ ", balance=" + balance + ", date=" + date + ", otherAccount=" + otherAccount + "]";
	}
}
