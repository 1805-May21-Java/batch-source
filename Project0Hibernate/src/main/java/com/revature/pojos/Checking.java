package com.revature.pojos;

public class Checking
{
	private int id;
	private double balance;
	private int userId;
	private User checking;
	public Checking()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User getChecking()
	{
		return checking;
	}

	public void setChecking(User checking)
	{
		this.checking = checking;
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	@Override
	public String toString()
	{
		return "Checking [id=" + id + ", balance=" + balance + ", userId=" + userId + ", checking=" + checking + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((checking == null) ? 0 : checking.hashCode());
		result = prime * result + id;
		result = prime * result + userId;
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
		Checking other = (Checking) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (checking == null)
		{
			if (other.checking != null)
				return false;
		}
		else if (!checking.equals(other.checking))
			return false;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	
}
