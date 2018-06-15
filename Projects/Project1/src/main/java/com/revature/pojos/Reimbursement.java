package com.revature.pojos;

import java.sql.Date;

public class Reimbursement 
{
	
	private int reimburseId;
	private int requestBy;
	private double amount;
	private int approveBy;
	private Date dateRequest;
	private Date dateApprove;
	private String status;
	private String url;
	
	public Reimbursement(
			int requestBy, double amount, int approveBy, Date dateRequest, Date dateApprove, String status, String url
	)	{
		super();
		this.requestBy = requestBy;
		this.amount = amount;
		this.approveBy = approveBy;
		this.dateRequest = dateRequest;
		this.dateApprove = dateApprove;
		this.status = status;
		this.url = url;
	}
	


	public Reimbursement(
			int reimburseId, int requestBy, double amount, int approveBy, Date dateRequest, Date dateApprove,
			String status, String url
	)
	{
		super();
		this.reimburseId = reimburseId;
		this.requestBy = requestBy;
		this.amount = amount;
		this.approveBy = approveBy;
		this.dateRequest = dateRequest;
		this.dateApprove = dateApprove;
		this.status = status;
		this.url = url;
	}


	public Reimbursement()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReimburseId()
	{
		return reimburseId;
	}
	public void setReimburseId(int reimburseId)
	{
		this.reimburseId = reimburseId;
	}
	public int getRequestBy()
	{
		return requestBy;
	}
	public void setRequestBy(int requestBy)
	{
		this.requestBy = requestBy;
	}
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	public int getApproveBy()
	{
		return approveBy;
	}
	public void setApproveBy(int approveBy)
	{
		this.approveBy = approveBy;
	}
	public Date getDateRequest()
	{
		return dateRequest;
	}
	public void setDateRequest(Date dateRequest)
	{
		this.dateRequest = dateRequest;
	}
	public Date getDateApprove()
	{
		return dateApprove;
	}
	public void setDateApprove(Date dateApprove)
	{
		this.dateApprove = dateApprove;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}

	@Override
	public String toString()
	{
		return "Reimbursement [reimburseId=" + reimburseId + ", requestBy=" + requestBy + ", amount=" + amount
				+ ", approveBy=" + approveBy + ", dateRequest=" + dateRequest + ", dateApprove=" + dateApprove
				+ ", status=" + status + ", url=" + url + "]";
	}
	
	
	
}
