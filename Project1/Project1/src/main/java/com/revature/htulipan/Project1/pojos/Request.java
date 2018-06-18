package com.revature.htulipan.Project1.pojos;

import java.sql.Date;

public class Request {
	
	private final int requestId;
	private final int employeeId;
	private int managerId;
	private float amount;
	private Date dateCreated;
	private Date dateAddressed;
	private String requestText;
	private int status;
	
	public Request(int requestId, int employeeId, int managerId, float amount, Date dateCreated, Date dateAddressed,
			String requestText, int status) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.amount = amount;
		this.dateCreated = dateCreated;
		this.dateAddressed = dateAddressed;
		this.requestText = requestText;
		this.status = status;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateAddressed() {
		return dateAddressed;
	}

	public void setDateAddressed(Date dateAddressed) {
		this.dateAddressed = dateAddressed;
	}

	public String getRequestText() {
		return requestText;
	}

	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", employeeId=" + employeeId + ", managerId=" + managerId
				+ ", amount=" + amount + ", dateCreated=" + dateCreated + ", dateAddressed=" + dateAddressed
				+ ", requestText=" + requestText + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((dateAddressed == null) ? 0 : dateAddressed.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + employeeId;
		result = prime * result + managerId;
		result = prime * result + requestId;
		result = prime * result + ((requestText == null) ? 0 : requestText.hashCode());
		result = prime * result + status;
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
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (dateAddressed == null) {
			if (other.dateAddressed != null)
				return false;
		} else if (!dateAddressed.equals(other.dateAddressed))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (managerId != other.managerId)
			return false;
		if (requestId != other.requestId)
			return false;
		if (requestText == null) {
			if (other.requestText != null)
				return false;
		} else if (!requestText.equals(other.requestText))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
