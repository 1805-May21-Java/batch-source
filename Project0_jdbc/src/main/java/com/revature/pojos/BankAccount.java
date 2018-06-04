package com.revature.pojos;

public class BankAccount
{
	
	private String accountId;
	private String userId;
	private double balance;
	
	public BankAccount(String accountId, String userId, Double balance2)
	{
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.balance = balance2;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}
	
	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}


	public BankAccount()
	{
	
	}

}
