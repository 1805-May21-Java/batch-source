package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Reimbursement;

public interface ReimbursementDao {
	public ArrayList<Reimbursement> getPendingReimbursementsForUser(String employeeEmail);
	public ArrayList<Reimbursement> getResolvedReimbursementsForUser(String employeeEmail);
	public ArrayList<Reimbursement> getAllReimbursementsForUser(String employeeEmail);
	public ArrayList<Reimbursement> getAllPendingReimbursements();
	public ArrayList<Reimbursement> getAllResolvedReimbursements();
	public int createReimbursement(String amount, String reason, String employeeEmail, String key);
	public int approveReimbursement(String id, String managerEmail);
	public int denyReimbursement(String id, String managerEmail);
	public Reimbursement getReimbursementById(String id);
}
