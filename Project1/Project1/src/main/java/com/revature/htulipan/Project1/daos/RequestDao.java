package com.revature.htulipan.Project1.daos;

import java.util.ArrayList;

import com.revature.htulipan.Project1.pojos.Request;

public interface RequestDao {

	public int createRequest(int eid, float amount, String text, int status);
	public int updateRequest(int rid, int mid, int status);
	public Request getRequestById(int requestId);
	public ArrayList<Request> getAllRequests();
	public ArrayList<Request> getRequestsByEmployeeId(int employeeId);
	public ArrayList<Request> getRequestsByManagerId(int managerId);
	public ArrayList<Request> getRequestsByStatus(int status);
	
}
