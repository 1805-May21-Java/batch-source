package com.adora.pojos;

import java.sql.Date;

public class Request {

	private int requestId;
	private int employeeId;
	private int managerId;
	private double requestedAmount;
	private double approvedAmount;
	private int status;
	private Date dateSubmitted;
	private Date dateApproved;
	private String subject;
	
	public Request() {
		super();
		
	}
	public Request(int requestId, int employeeId, int managerId, double requestedAmount, double approvedAmount,
			int status, Date dateSubmitted, Date dateApproved, String subject) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.requestedAmount = requestedAmount;
		this.approvedAmount = approvedAmount;
		this.status = status;
		this.dateSubmitted = dateSubmitted;
		this.dateApproved = dateApproved;
		this.subject = subject;
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
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public double getRequestedAmount() {
		return requestedAmount;
	}
	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}
	public double getApprovedAmount() {
		return approvedAmount;
	}
	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public Date getDateApproved() {
		return dateApproved;
	}
	public void setDateApproved(Date dateApproved) {
		this.dateApproved = dateApproved;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(approvedAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateApproved == null) ? 0 : dateApproved.hashCode());
		result = prime * result + ((dateSubmitted == null) ? 0 : dateSubmitted.hashCode());
		result = prime * result + employeeId;
		result = prime * result + managerId;
		result = prime * result + requestId;
		temp = Double.doubleToLongBits(requestedAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + status;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		if (Double.doubleToLongBits(approvedAmount) != Double.doubleToLongBits(other.approvedAmount))
			return false;
		if (dateApproved == null) {
			if (other.dateApproved != null)
				return false;
		} else if (!dateApproved.equals(other.dateApproved))
			return false;
		if (dateSubmitted == null) {
			if (other.dateSubmitted != null)
				return false;
		} else if (!dateSubmitted.equals(other.dateSubmitted))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (managerId != other.managerId)
			return false;
		if (requestId != other.requestId)
			return false;
		if (Double.doubleToLongBits(requestedAmount) != Double.doubleToLongBits(other.requestedAmount))
			return false;
		if (status != other.status)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", employeeId=" + employeeId + ", managerId=" + managerId
				+ ", requestedAmount=" + requestedAmount + ", approvedAmount=" + approvedAmount + ", status=" + status
				+ ", dateSubmitted=" + dateSubmitted + ", dateApproved=" + dateApproved + ", subject=" + subject + "]";
	}
	
	
}
