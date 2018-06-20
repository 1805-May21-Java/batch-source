package data;

import java.util.Date;

public class Reimbursement {
	long reimbursementId, employeeId, managerId;
	double reimbursementValue;
	String reimbursementReason;
	int status; //=>2 is resolved, 1 is denied, 0 is pending
	Date date;
	
	public Reimbursement(long reimbursementId, long employeeId, double reimbursementValue, long managerId, String reimbursementReason, int status, Date date){
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.reimbursementValue = reimbursementValue;
		this.managerId = managerId;
		this.reimbursementReason = reimbursementReason;
		this.status = status;
		this.date = date;
	}
	public Reimbursement(long reimbursementId, long employeeId, double reimbursementValue, String reimbursementReason, int status, Date date){
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
	public double getReimbursementValue() {
		return reimbursementValue;
	}
	public void setReimbursementValue(double reimbursementValue) {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
