package com.revature.pojos;

import javax.persistence.*;

@Entity
@Table
public class Checking
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(allocationSize=1, name="userSequence", sequenceName="USER_ACCT_PK")
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="BALANCE")
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User userId;
	
	
	public Checking()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Checking(int id, double balance, User userId)
	{
		super();
		this.id = id;
		this.balance = balance;
		this.userId = userId;
	}
	
	public Checking(int id, double balance)
	{
		super();
		this.id = id;
		this.balance = balance;
	}
	

	public Checking(int id)
	{
		super();
		this.id = id;
	}

	public User getUserId()
	{
		return userId;
	}

	public void setUserId(User userId)
	{
		this.userId = userId;
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

	@Override
	public String toString()
	{
		return "Checking [id=" + id + ", balance=" + balance + ", userId=" + userId + "]";
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
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (id != other.id)
			return false;
		if (userId == null)
		{
			if (other.userId != null)
				return false;
		}
		else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
	
	
}
