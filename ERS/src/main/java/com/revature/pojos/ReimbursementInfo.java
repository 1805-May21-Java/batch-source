package com.revature.pojos;

import java.sql.Date;

public class ReimbursementInfo {
	private int reimbursementid;
	private String reqname;
	private String reason;
	private double totalcost;
	private int requesterid;
	private Date billDate;
	private Date decisionDate;
	private String approvalname;
	private String status;
	public ReimbursementInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementInfo(int reimbursementid, String reqname, String reason, double totalcost, int requesterid,
			Date billDate, Date decisionDate, String approvalname, String status) {
		super();
		this.reimbursementid = reimbursementid;
		this.reqname = reqname;
		this.reason = reason;
		this.totalcost = totalcost;
		this.requesterid = requesterid;
		this.billDate = billDate;
		this.decisionDate = decisionDate;
		this.approvalname = approvalname;
		this.status = status;
	}
	
	public ReimbursementInfo(int reimbursementid, String reqname, String reason, double totalcost, int requesterid,
			Date billDate, String status) {
		super();
		this.reimbursementid = reimbursementid;
		this.reqname = reqname;
		this.reason = reason;
		this.totalcost = totalcost;
		this.requesterid = requesterid;
		this.billDate = billDate;
		this.status = status;
	}
	
	public int getReimbursementid() {
		return reimbursementid;
	}
	public void setReimbursementid(int reimbursementid) {
		this.reimbursementid = reimbursementid;
	}
	public String getReqname() {
		return reqname;
	}
	public void setReqname(String reqname) {
		this.reqname = reqname;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	public int getRequesterid() {
		return requesterid;
	}
	public void setRequesterid(int requesterid) {
		this.requesterid = requesterid;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public Date getDecisionDate() {
		return decisionDate;
	}
	public void setDecisionDate(Date decisionDate) {
		this.decisionDate = decisionDate;
	}
	public String getApprovalname() {
		return approvalname;
	}
	public void setApprovalid(String approvalname) {
		this.approvalname = approvalname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReimbursementInfo [reimbursementid=" + reimbursementid + ", reqname=" + reqname + ", reason=" + reason
				+ ", totalcost=" + totalcost + ", requesterid=" + requesterid + ", billDate=" + billDate
				+ ", decisionDate=" + decisionDate + ", approvalid=" + approvalname + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvalname == null) ? 0 : approvalname.hashCode());
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + ((decisionDate == null) ? 0 : decisionDate.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + reimbursementid;
		result = prime * result + ((reqname == null) ? 0 : reqname.hashCode());
		result = prime * result + requesterid;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalcost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ReimbursementInfo other = (ReimbursementInfo) obj;
		if (approvalname == null) {
			if (other.approvalname != null)
				return false;}
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
			return false;
		if (decisionDate == null) {
			if (other.decisionDate != null)
				return false;
		} else if (!decisionDate.equals(other.decisionDate))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reimbursementid != other.reimbursementid)
			return false;
		if (reqname == null) {
			if (other.reqname != null)
				return false;
		} else if (!reqname.equals(other.reqname))
			return false;
		if (requesterid != other.requesterid)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(totalcost) != Double.doubleToLongBits(other.totalcost))
			return false;
		return true;
	}
	
}
