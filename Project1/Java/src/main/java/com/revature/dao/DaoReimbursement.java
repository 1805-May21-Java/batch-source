package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Reimbursement;

public interface DaoReimbursement {
	public ArrayList<Reimbursement> getReimbursementByEmployee(int employeeId);
	public ArrayList<Reimbursement> getPendingReimbursements();
	public int updateOldReimbursement(Reimbursement reimbursement);
	public int insertNewReimbursement(Reimbursement reimbursement);
	public Reimbursement getReimbursementById(int reimburesmentId);
	public int deleteReimbursementById(int remibursementId);
}