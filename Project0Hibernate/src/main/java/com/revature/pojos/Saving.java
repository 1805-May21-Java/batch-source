package com.revature.pojos;

public class Saving
{
	private int id;
	private double balance;
	private int userId;
	private User saving;
	public Saving()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User getSaving()
	{
		return saving;
	}

	public void setSaving(User saving)
	{
		this.saving = saving;
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
		return "Saving [id=" + id + ", balance=" + balance + ", userId=" + userId + ", saving=" + saving + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((saving == null) ? 0 : saving.hashCode());
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
		Saving other = (Saving) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (saving == null)
		{
			if (other.saving != null)
				return false;
		}
		else if (!saving.equals(other.saving))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	
}
