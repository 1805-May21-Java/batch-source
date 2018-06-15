package com.revature.pojos;

import java.sql.Date;

public class Reimbursement {
	private int id;
	private double amount; //okay, I lied. It's a double this time
	private String descript;
	private boolean has_receipt;
	private Date date_submitted;
	private Date date_resolved;
	private int requester_id;
	private String requester_name;
	private int resolver_id;
	private String resolver_name;
	private ReimbursementType type;
	private ReimbursementStatus status;
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int id, double amount, String descript, boolean has_receipt, Date date_submitted,
			Date date_resolved, int requester_id, String requester_name, int resolver_id, String resolver_name,
			ReimbursementType type, ReimbursementStatus status) {
		super();
		this.id = id;
		this.amount = amount;
		this.descript = descript;
		this.has_receipt = has_receipt;
		this.date_submitted = date_submitted;
		this.date_resolved = date_resolved;
		this.requester_id = requester_id;
		this.requester_name = requester_name;
		this.resolver_id = resolver_id;
		this.resolver_name = resolver_name;
		this.type = type;
		this.status = status;
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
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public boolean isHas_receipt() {
		return has_receipt;
	}
	public void setHas_receipt(boolean has_receipt) {
		this.has_receipt = has_receipt;
	}
	public Date getDate_submitted() {
		return date_submitted;
	}
	public void setDate_submitted(Date date_submitted) {
		this.date_submitted = date_submitted;
	}
	public Date getDate_resolved() {
		return date_resolved;
	}
	public void setDate_resolved(Date date_resolved) {
		this.date_resolved = date_resolved;
	}
	public int getRequester_id() {
		return requester_id;
	}
	public void setRequester_id(int requester_id) {
		this.requester_id = requester_id;
	}
	public String getRequester_name() {
		return requester_name;
	}
	public void setRequester_name(String requester_name) {
		this.requester_name = requester_name;
	}
	public int getResolver_id() {
		return resolver_id;
	}
	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}
	public String getResolver_name() {
		return resolver_name;
	}
	public void setResolver_name(String resolver_name) {
		this.resolver_name = resolver_name;
	}
	public ReimbursementType getType() {
		return type;
	}
	public void setType(ReimbursementType type) {
		this.type = type;
	}
	public ReimbursementStatus getStatus() {
		return status;
	}
	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", descript=" + descript + ", has_receipt="
				+ has_receipt + ", date_submitted=" + date_submitted + ", date_resolved=" + date_resolved
				+ ", requester_id=" + requester_id + ", requester_name=" + requester_name + ", resolver_id="
				+ resolver_id + ", resolver_name=" + resolver_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date_resolved == null) ? 0 : date_resolved.hashCode());
		result = prime * result + ((date_submitted == null) ? 0 : date_submitted.hashCode());
		result = prime * result + ((descript == null) ? 0 : descript.hashCode());
		result = prime * result + (has_receipt ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + requester_id;
		result = prime * result + ((requester_name == null) ? 0 : requester_name.hashCode());
		result = prime * result + resolver_id;
		result = prime * result + ((resolver_name == null) ? 0 : resolver_name.hashCode());
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (date_resolved == null) {
			if (other.date_resolved != null)
				return false;
		} else if (!date_resolved.equals(other.date_resolved))
			return false;
		if (date_submitted == null) {
			if (other.date_submitted != null)
				return false;
		} else if (!date_submitted.equals(other.date_submitted))
			return false;
		if (descript == null) {
			if (other.descript != null)
				return false;
		} else if (!descript.equals(other.descript))
			return false;
		if (has_receipt != other.has_receipt)
			return false;
		if (id != other.id)
			return false;
		if (requester_id != other.requester_id)
			return false;
		if (requester_name == null) {
			if (other.requester_name != null)
				return false;
		} else if (!requester_name.equals(other.requester_name))
			return false;
		if (resolver_id != other.resolver_id)
			return false;
		if (resolver_name == null) {
			if (other.resolver_name != null)
				return false;
		} else if (!resolver_name.equals(other.resolver_name))
			return false;
		return true;
	}
	
}
