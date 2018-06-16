package com.revature.dao;

import java.util.List;

import com.revature.pojos.Request;

public interface RequestDao {
	
	public List<Request> getRequests();
	public Request getRequestById(int id);
	public int createRequest(Request request);
	public int updateRequest(Request request);
	public int deleteRequestById(Request request);

}
