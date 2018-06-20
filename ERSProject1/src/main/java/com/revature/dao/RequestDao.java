package com.revature.dao;

import java.util.List;

import com.revature.pojos.Request;

public interface RequestDao {
	
	public List<Request> getRequests();
	public List<Request> getRequestsById(int id);
	public void createRequest(int id, String title, double amount, String comments);
	public int updateRequest(Request request);
	public int deleteRequestById(Request request);

}
