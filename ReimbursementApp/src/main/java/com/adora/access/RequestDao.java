package com.adora.access;

import java.util.List;

import com.adora.pojos.Request;

public interface RequestDao {

	// get requests
	public List<Request> getAllRequests(int employeeId);
	public List<Request> getAllRequestsByManager(int managerId);
	public List<Request> getAllPendingRequests();
	public List<Request> getAllPendingRequestsByManager(int managerId);
	
	public List<Request> getAllRequestsByEmployee(int employeeId);
	public List<Request> getAllPendingRequestsByEmployee(int employeeId);
	
	public Request getRequestById(int requestId);
	
	// create requests
	public int createRequest(Request request);
	
	//approve or deny requests
	public int approveRequest(int requestId, int managerId, double requestAmount);
	public int denyRequest(int requestId, int managerId);
}
