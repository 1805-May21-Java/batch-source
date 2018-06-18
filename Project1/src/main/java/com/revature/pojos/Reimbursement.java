package com.revature.pojos;

//a pretty ordinary java object
public class Reimbursement
{
	private int id;
	private String reason;
	private double amount;
	private int userId;
	private int pending;
	private int resolvedBy;
	public Reimbursement()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(String reason, double amount, int userId)
	{
		super();
		this.reason = reason;
		this.amount = amount;
		this.userId = userId;
	}
	
	public Reimbursement(int id, String reason, double amount, int userId, int pending, int resolvedBy)
	{
		super();
		this.id = id;
		this.reason = reason;
		this.amount = amount;
		this.userId = userId;
		this.pending = pending;
		this.resolvedBy = resolvedBy;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getReason()
	{
		return reason;
	}
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getPending()
	{
		return pending;
	}
	public void setPending(int pending)
	{
		this.pending = pending;
	}
	public int getResolvedBy()
	{
		return resolvedBy;
	}
	public void setResolvedBy(int resolvedBy)
	{
		this.resolvedBy = resolvedBy;
	}
	@Override
	public String toString()
	{
		return "Reimbursement [id=" + id + ", reason=" + reason + ", amount=" + amount + ", userId=" + userId
				+ ", pending=" + pending + ", resolvedBy=" + resolvedBy + "]";
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + pending;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + resolvedBy;
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		if (pending != other.pending)
			return false;
		if (reason == null)
		{
			if (other.reason != null)
				return false;
		}
		else if (!reason.equals(other.reason))
			return false;
		if (resolvedBy != other.resolvedBy)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
