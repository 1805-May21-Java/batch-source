package com.revature.pojos;

import java.awt.Image;

public class Reimbursement {
	
	 private int ReimbursementId;
	 private Image receipt;
	 private String name;
	 private double reimbursementAmount;
	 private int status;
	 
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimbursementId, Image receipt, String name, double reimbursementAmount, int status) {
		super();
		ReimbursementId = reimbursementId;
		this.receipt = receipt;
		this.name = name;
		this.reimbursementAmount = reimbursementAmount;
		this.status = status;
	}

	public int getReimbursementId() {
		return ReimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		ReimbursementId = reimbursementId;
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
		result = prime * result + ReimbursementId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimbursementAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (ReimbursementId != other.ReimbursementId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		}
		if (Double.doubleToLongBits(reimbursementAmount) != Double.doubleToLongBits(other.reimbursementAmount))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [ReimbursementId=" + ReimbursementId + ", name=" + name + ", reimbursementAmount="
				+ reimbursementAmount + ", status=" + status + "]";
	}
	 

}   
