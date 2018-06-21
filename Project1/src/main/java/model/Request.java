package model;

import java.util.Date;

public class Request {

	int id;
	double amount;
	Date requestDate;
	int employeeId;
	String approved;
	int managerApproved;
	String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApproved() {
		return approved;
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Request(int id, double amount, Date requestDate, int employeeId, String approved, int managerApproved, String description) {
		super();
		this.id = id;
		this.amount = amount;
		this.requestDate = requestDate;
		this.employeeId = employeeId;
		this.approved = approved;
		this.managerApproved = managerApproved;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String isApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public int getManagerApproved() {
		return managerApproved;
	}
	public void setManagerApproved(int managerApproved) {
		this.managerApproved = managerApproved;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", amount=" + amount + ", requestDate=" + requestDate + ", employeeId="
				+ employeeId + ", approved=" + approved + ", managerApproved=" + managerApproved + "]";
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
		if (approved != other.approved)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (id != other.id)
			return false;
		if (managerApproved != other.managerApproved)
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		return true;
	}
	
	
	
}
