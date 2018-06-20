package com.revature.pojos;

import java.awt.Image;

public class Reimbursement {
	
	 private int reimbursementId;
	 private Image receipt;
	 private String name;
	 private double reimbursementAmount;
	 private int status;
	 private int employeeId;
	 private String description;
	 
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimbursementId, Image receipt, String name, 
			double reimbursementAmount, int status, String description, int employeeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.receipt = receipt;
		this.name = name;
		this.reimbursementAmount = reimbursementAmount;
		this.status = status;
		this.description = description;
		this.employeeId = employeeId;
	}
	public Reimbursement(int reimbursementId, String name, double reimbursementAmount, 
			int status, String description,int employeeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.name = name;
		this.reimbursementAmount = reimbursementAmount;
		this.status = status;
		this.description = description;
		this.employeeId = employeeId;
	}
	public Reimbursement(String name, double reimbursementAmount, 
			int status, String description, int employeeId) {
		super();
		this.name = name;
		this.reimbursementAmount = reimbursementAmount;
		this.status = status;
		this.description = description;
		this.employeeId = employeeId;
	}
	public Reimbursement(String name, double reimbursementAmount, 
			int status, String description) {
		super();
		this.name = name;
		this.reimbursementAmount = reimbursementAmount;
		this.status = status;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public Image getReceipt() {
		return receipt;
	}

	public void setReceipt(Image receipt) {
		this.receipt = receipt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimbursementAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbursementId;
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
		Reimbursement other = (Reimbursement) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(reimbursementAmount) != Double.doubleToLongBits(other.reimbursementAmount))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", name=" + name + ", reimbursementAmount="
				+ reimbursementAmount + ", status=" + status + ", employeeId=" + employeeId + ", description="
				+ description + "]";
	}
	 

}   
