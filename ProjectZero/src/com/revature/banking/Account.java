package com.revature.banking;


public class Account 
{
	private String username, password;
	private boolean isLoggedIn;
	private double balance;
	
	/**************** POJO implementation of a bank account *****************************/
	public Account() 
	{
		super();
	}
	public Account(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}
	public Account(String username, String password, double balance) 
	{
		super();
		this.username = username;
		this.password = password;
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
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public boolean isLoggedIn() 
	{
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) 
	{
		this.isLoggedIn = isLoggedIn;
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
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (isLoggedIn ? 1231 : 1237);
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
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (isLoggedIn != other.isLoggedIn)
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
		return "Account [username=" + username + ", password=" + password + ", isLoggedIn=" + isLoggedIn + ", balance="
				+ balance + "]";
	}
	/**************************************************************************************/
	
	public double deposit(double amount)
	{
		return this.balance += amount;
	}
	public double withdraw(double amount)
	{
		return this.balance -= amount;
	}
	
	
}
