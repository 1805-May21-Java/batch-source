package com.revature.pojos;

public class Reimbursement {
	
	private Integer reimbursement_id;
	private Double money;
	private Integer employee_id;
	private String status;
	private Integer reviewer_id;
	public Reimbursement(Integer reimbursement_id, Double money, Integer employee_id, String status, Integer reviewer_id) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.money = money;
		this.employee_id = employee_id;
		this.status = status;
		this.reviewer_id = reviewer_id;
	}
	public Integer getReimbursement_id() {
		return reimbursement_id;
	}
	public void setReimbursement_id(Integer reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getReviewer_id() {
		return reviewer_id;
	}
	public void setReviewer_id(Integer reviewer_id) {
		this.reviewer_id = reviewer_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employee_id;
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbursement_id;
		result = prime * result + reviewer_id;
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
		if (employee_id != other.employee_id)
			return false;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		if (reimbursement_id != other.reimbursement_id)
			return false;
		if (reviewer_id != other.reviewer_id)
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
		return "Reimbursement [reimbursement_id=" + reimbursement_id + ", money=" + money + ", employee_id="
				+ employee_id + ", status=" + status + ", reviewer_id=" + reviewer_id + "]";
	}
	
	

}
