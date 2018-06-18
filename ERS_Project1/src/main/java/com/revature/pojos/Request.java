package com.revature.pojos;

import java.sql.Date;

public class Request {
	private int id;
	private int emplId;
	private double amount;
	private String description;
	private String status;
	private Date dateRequested;
	private Date dateResolved;
	private String resolvedBy;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(int id, int emplId, double amount, String description, String status, Date dateRequested,
			Date dateResolved, String resolvedBy) {
		super();
		this.id = id;
		this.emplId = emplId;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.dateRequested = dateRequested;
		this.dateResolved = dateResolved;
		this.resolvedBy = resolvedBy;
	}
	public Request(int emplId, double amount, String description) {
		super();
		this.emplId = emplId;
		this.amount = amount;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmplId() {
		return emplId;
	}
	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateRequested() {
		return dateRequested;
	}
	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}
	public Date getDateResolved() {
		return dateResolved;
	}
	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}
	public String getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateRequested == null) ? 0 : dateRequested.hashCode());
		result = prime * result + ((dateResolved == null) ? 0 : dateResolved.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + emplId;
		result = prime * result + id;
		result = prime * result + ((resolvedBy == null) ? 0 : resolvedBy.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (dateRequested == null) {
			if (other.dateRequested != null)
				return false;
		} else if (!dateRequested.equals(other.dateRequested))
			return false;
		if (dateResolved == null) {
			if (other.dateResolved != null)
				return false;
		} else if (!dateResolved.equals(other.dateResolved))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (emplId != other.emplId)
			return false;
		if (id != other.id)
			return false;
		if (resolvedBy == null) {
			if (other.resolvedBy != null)
				return false;
		} else if (!resolvedBy.equals(other.resolvedBy))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", emplId=" + emplId + ", amount=" + amount + ", description=" + description
				+ ", status=" + status + ", dateRequested=" + dateRequested + ", dateResolved=" + dateResolved
				+ ", resolvedBy=" + resolvedBy + "]";
	}
	
	
	
	
}
