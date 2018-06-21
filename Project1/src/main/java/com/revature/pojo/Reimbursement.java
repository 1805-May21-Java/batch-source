package com.revature.pojo;

import java.sql.Date;

/*
 * Reimbursement POJO
 */
public class Reimbursement {

	private int ID;
	private int requestID;
	private String picURL;
	private double amountRequest;
	private String description;
	private Date dateOfRequest;
	private String status;
	private int approveID;
	private Date dateOfApprove;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int ID, int requestID, String picURL, double amountRequest, String description, Date dateOfRequest, String status,
			int approveID, Date dateOfApprove) {
		super();
		this.ID = ID;
		this.requestID = requestID;
		this.picURL = picURL;
		this.amountRequest = amountRequest;
		this.description = description;
		this.dateOfRequest = dateOfRequest;
		this.status = status;
		this.approveID = approveID;
		this.dateOfApprove = dateOfApprove;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public String getPicURL() {
		return picURL;
	}

	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}

	public double getAmountRequest() {
		return amountRequest;
	}

	public void setAmountRequest(double amountRequest) {
		this.amountRequest = amountRequest;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getApproveID() {
		return approveID;
	}

	public void setApproveID(int approveID) {
		this.approveID = approveID;
	}

	public Date getDateOfApprove() {
		return dateOfApprove;
	}

	public void setDateOfApprove(Date dateOfApprove) {
		this.dateOfApprove = dateOfApprove;
	}
	
}
