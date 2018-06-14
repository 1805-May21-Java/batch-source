package com.revature.dao;

import java.util.List;

import com.revature.pojos.Request;

public interface RequestDao {
	public List<Request> getRequestsByEmployeeId(int id);
	public int resolveRequest(int requestId, String status);
	public int createRequest(Request request);
}
