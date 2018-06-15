package com.revature.dao;

import java.util.HashMap;

import com.revature.pojos.Reimbursement;

public interface ReimbursementDao {
	
	public HashMap<Integer, Reimbursement> getReimbursements();
	
	public Reimbursement getReimbursementById(Integer id);
	
	public int createReimbursement(Reimbursement form);
	
	public int deleteReimbursementById(Integer id);
	
	public int updateReimbursement(Reimbursement current);
	

}
