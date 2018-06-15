package com.revature.daos;

import java.util.*;

import com.revature.pojos.*;

public interface ReimbursementRequestDao
{
	public ReimbursementRequest getRiRbyID(int rirId);
	public List<ReimbursementRequest> getRiRsByEmpId(int empId);
	public void createRiR(int empId, String description, double value);
	public void approveRiR(int rirId, int managerId);
}
