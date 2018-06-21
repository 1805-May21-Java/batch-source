package com.revature.pojos;

public class Reimbursement {
	private String amount;
	private String reason;
	private String status;
	private String requestedBy;
	private String id;
	private String resolvedBy;
	private String outcome;
	private String insertedAt;
	private String key;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(String amount, String reason, String status, String requestedBy, String id) {
		super();
		this.amount = amount;
		this.reason = reason;
		this.status = status;
		this.requestedBy = requestedBy;
		this.id = id;
	}
	
	public Reimbursement(String amount, String reason, String status, String requestedBy, String id, String insertedAt, String key) {
		super();
		this.amount = amount;
		this.reason = reason;
		this.status = status;
		this.requestedBy = requestedBy;
		this.id = id;
		this.insertedAt = insertedAt;
		this.key = key;
	}


	public Reimbursement(String amount, String reason, String status, String requestedBy, String id, String resolvedBy, String outcome, String insertedAt, String key) {
		super();
		this.amount = amount;
		this.reason = reason;
		this.status = status;
		this.requestedBy = requestedBy;
		this.id = id;
		this.resolvedBy = resolvedBy;
		this.outcome = outcome;
		this.insertedAt = insertedAt;
		this.key = key;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(String insertedAt) {
		this.insertedAt = insertedAt;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insertedAt == null) ? 0 : insertedAt.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((outcome == null) ? 0 : outcome.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((requestedBy == null) ? 0 : requestedBy.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (insertedAt == null) {
			if (other.insertedAt != null)
				return false;
		} else if (!insertedAt.equals(other.insertedAt))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (outcome == null) {
			if (other.outcome != null)
				return false;
		} else if (!outcome.equals(other.outcome))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (requestedBy == null) {
			if (other.requestedBy != null)
				return false;
		} else if (!requestedBy.equals(other.requestedBy))
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
		return "Reimbursement [amount=" + amount + ", reason=" + reason + ", status=" + status + ", requestedBy="
				+ requestedBy + ", id=" + id + ", resolvedBy=" + resolvedBy + ", outcome=" + outcome + ", insertedAt="
				+ insertedAt + ", key=" + key + "]";
	}
}
