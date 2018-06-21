package com.revature.dao;

import java.util.List;

import com.revature.pojos.Reimbursement;

public interface ReimbursementDao {
	
	public List<Reimbursement> getReimbursements();
	public Reimbursement getReimbursementByUsername(String username);
	public int createReimbursement(Reimbursement reimbursement);
	public List<Reimbursement> getPendingsById(int employeeId);
	public int approveReimbursement(int reimbursementId, int mngId);
	public int denyReimbursement(int reimbursementId, int mngId);
	public List<Reimbursement> getResolvedById(int employeeId);
	public List<Reimbursement> getResolved();
	public List<Reimbursement> getReimbursementsById(int employeeId);
	

}
