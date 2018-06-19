package com.revature.pojos;

public class Request {

	private int requestId, employeeId, status;
	private float amount;
	private String comments, name;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(int requestId, int employeeId, int status, float amount, String comments, String name) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.status = status;
		this.amount = amount;
		this.comments = comments;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", employeeId=" + employeeId + ", status=" + status + ", amount="
				+ amount + ", comments=" + comments + ", name="+name+"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + employeeId;
		result = prime * result + requestId;
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
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (requestId != other.requestId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
