package data;

import java.util.Date;

public class Reimbursement {
	long reimbursementId, employeeId, reimbursementValue, managerId;
	String reimbursementReason;
	boolean status;
	Date date;
	
	public Reimbursement(long reimbursementId, long employeeId, long reimbursementValue, long managerId, String reimbursementReason, boolean status, Date date){
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.reimbursementValue = reimbursementValue;
		this.managerId = managerId;
		this.reimbursementReason = reimbursementReason;
		this.status = status;
		this.date = date;
	}
	public Reimbursement(long reimbursementId, long employeeId, long reimbursementValue, String reimbursementReason, boolean status){
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.reimbursementValue = reimbursementValue;
		this.reimbursementReason = reimbursementReason;
		this.status = status;
	}
	
	public long getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(long reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public long getEmployeId() {
		return employeeId;
	}
	public void setEmployeId(long employeId) {
		this.employeeId = employeId;
	}
	public long getReimbursementValue() {
		return reimbursementValue;
	}
	public void setReimbursementValue(long reimbursementValue) {
		this.reimbursementValue = reimbursementValue;
	}
	public long getManagerId() {
		return managerId;
	}
	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}
	public String getReimbursementReason() {
		return reimbursementReason;
	}
	public void setReimbursementReason(String reimbursementReason) {
		this.reimbursementReason = reimbursementReason;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
