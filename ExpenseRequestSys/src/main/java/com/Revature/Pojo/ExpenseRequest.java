package com.Revature.Pojo;

import java.sql.Date;

public class ExpenseRequest {
	private int requestId;
	private String submitter;
	private Date submissionDate;
	private float amount;
	private String expense;
	private String state;
	private String resolvingManager;

	public ExpenseRequest() {
		super();
	}

	public ExpenseRequest(String submitter, float amount, String expense) {
		super();
		this.submitter = submitter;
		this.amount = amount;
		this.expense = expense;
	}

	public ExpenseRequest(int requestId, String submitter, Date submissionDate, float amount, String expense,
			String state, String resolvingManager) {
		super();
		this.requestId = requestId;
		this.submitter = submitter;
		this.submissionDate = submissionDate;
		this.amount = amount;
		this.expense = expense;
		this.state = state;
		this.resolvingManager = resolvingManager;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getResolvingManager() {
		return resolvingManager;
	}

	public void setResolvingManager(String resolvingManager) {
		this.resolvingManager = resolvingManager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((expense == null) ? 0 : expense.hashCode());
		result = prime * result + requestId;
		result = prime * result + ((resolvingManager == null) ? 0 : resolvingManager.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((submissionDate == null) ? 0 : submissionDate.hashCode());
		result = prime * result + ((submitter == null) ? 0 : submitter.hashCode());
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
		ExpenseRequest other = (ExpenseRequest) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (expense == null) {
			if (other.expense != null)
				return false;
		} else if (!expense.equals(other.expense))
			return false;
		if (requestId != other.requestId)
			return false;
		if (resolvingManager == null) {
			if (other.resolvingManager != null)
				return false;
		} else if (!resolvingManager.equals(other.resolvingManager))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (submissionDate == null) {
			if (other.submissionDate != null)
				return false;
		} else if (!submissionDate.equals(other.submissionDate))
			return false;
		if (submitter == null) {
			if (other.submitter != null)
				return false;
		} else if (!submitter.equals(other.submitter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExpenseRequest [requestId=" + requestId + ", submitter=" + submitter + ", submissionDate="
				+ submissionDate + ", amount=" + amount + ", expense=" + expense + ", state=" + state
				+ ", resolvingManager=" + resolvingManager + "]";
	}

}
