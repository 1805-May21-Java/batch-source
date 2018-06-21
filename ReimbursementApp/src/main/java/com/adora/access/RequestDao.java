package com.adora.access;

import java.util.List;

import com.adora.pojos.Request;


public interface RequestDao {

	// get requests
	public List<Request> getAllRequests(int employeeId);
	public List<Request> getAllRequestsByManager(int managerId);
	public List<Request> getAllStatusRequestsByManager(int managerId, int status);
	
	public List<Request> getAllRequestsByEmployee(int employeeId);
	public List<Request> getAllStatusRequestsByEmployee(int employeeId, int status);
	
	public Request getRequest(Request request);
	
	// create requests
	public int createRequest(Request request);
	
	//approve or deny requests
	public int updateRequest(Request request);
}
