package com.revature.pojos;

import java.sql.Date;

public class Request {
	
	private int id;
	private String imageURL;
	private int employeeId;
	private int managerId;
	private String title;
	private Double amount ;
	private String comments;
	private Date dateCreated;
	private Date dateApproved;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int id, String imageURL, int employeeId, int managerId, String title, Double amount, String comments,
			Date dateCreated, Date dateApproved) {
		super();
		this.id = id;
		this.imageURL = imageURL;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.title = title;
		this.amount = amount;
		this.comments = comments;
		this.dateCreated = dateCreated;
		this.dateApproved = dateApproved;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateApproved() {
		return dateApproved;
	}

	public void setDateApproved(Date dateApproved) {
		this.dateApproved = dateApproved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((dateApproved == null) ? 0 : dateApproved.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + employeeId;
		result = prime * result + id;
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + managerId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Request other = (Request) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (dateApproved == null) {
			if (other.dateApproved != null)
				return false;
		} else if (!dateApproved.equals(other.dateApproved))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (id != other.id)
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (managerId != other.managerId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", imageURL=" + imageURL + ", employeeId=" + employeeId + ", managerId="
				+ managerId + ", title=" + title + ", amount=" + amount + ", comments=" + comments + ", dateCreated="
				+ dateCreated + ", dateApproved=" + dateApproved + "]";
	}
	
	
	

}
