package com.revature.dao;

import java.sql.Date;
import java.util.List;

import com.revature.pojos.Request;

public interface RequestDao {
	
	public List<Request> getRequests();
	public List<Request> getRequestsById(int id);
	public Request getRequestById(int id);
	public void createRequest(int id, String title, double amount, String comments);
	public void updateRequest(int reqId, int mgrId, Date dateApproved, String managerName);
	public void deleteRequestById(int id);

}
