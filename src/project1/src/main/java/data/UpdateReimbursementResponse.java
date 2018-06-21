package data;

public class UpdateReimbursementResponse {
	private long reimbursementId, managerId;
	private int status;
	
	public long getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(long reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getManagerId() {
		return managerId;
	}
	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}
}
