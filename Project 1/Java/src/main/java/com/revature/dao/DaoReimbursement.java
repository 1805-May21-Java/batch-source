package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Reimbursement;

public interface daoReimbursement {
	public ArrayList<Reimbursement> getReimbursementByEmployee(int employeeId);
	public ArrayList<Reimbursement> getPendingReimbursements();
	public boolean updateOldReimbursement(Reimbursement reimbursement);
	public int insertNewReimbursement(Reimbursement reimbursement);
}