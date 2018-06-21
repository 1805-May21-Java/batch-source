package com.revature.pojos;

public class Reimbursement {

	private int reimbursementId;
	private String status;
	private int empId;
	private int mngId;
	private String description;
	private String amount;
	
	
	public Reimbursement() {
		super();
	}


	public Reimbursement(int reimbursementId, String status, int empId, int mngId, String description, String amount) {
		super();
		this.reimbursementId = reimbursementId;
		this.status = status;
		this.empId = empId;
		this.mngId = mngId;
		this.description = description;
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", status=" + status + ", empId=" + empId
				+ ", mngId=" + mngId + ", description=" + description + ", amount=" + amount + "]";
	}


	public int getReimbursementId() {
		return reimbursementId;
	}


	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public int getMngId() {
		return mngId;
	}


	public void setMngId(int mngId) {
		this.mngId = mngId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + empId;
		result = prime * result + mngId;
		result = prime * result + reimbursementId;
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
		Reimbursement other = (Reimbursement) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (empId != other.empId)
			return false;
		if (mngId != other.mngId)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
