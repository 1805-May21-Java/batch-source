package com.revature.dao;

import java.util.List;
import com.revature.pojos.Reimbursement;

public interface ReimbursementDao
{
	List<Reimbursement> getReimbursements();
	Reimbursement getReimbursementById(int id);
	void createReimbursement(Reimbursement reimbursement);
	void deleteReimbursementById(int id);
	void updateReimbursement(Reimbursement reimbursement);
	List<Reimbursement> getReimbursementsByEmpIds(List<Reimbursement> reimbursements, List<Integer> empIds);
	List<Reimbursement> getReimbursementsByEmpId(int id);
}
