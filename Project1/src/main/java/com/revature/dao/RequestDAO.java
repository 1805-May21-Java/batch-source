package com.revature.dao;

import java.util.List;

import com.revature.pojos.Employee;
import com.revature.pojos.Request;

public interface RequestDAO {

	public List<Request> getAllRequests();
	public List<Request> getAllRequestsByEmployee(Employee emp);
	public List<Request> getAllRequestsByManager(Employee emp);
	public int createRequest(Request req);
	public int updateRequest(int reqId, int status);
	
}
