package com.revature.dao;

import java.util.List;
import com.revature.pojos.*;

public interface ReimbursementDAO {
	//Get all Reimbursement's in the DB
	public List<Reimbursement> getReimburse();
	//Get Reimbursement by employee ID
	public List<Reimbursement> getReimByID(int ID);
	//Adapt this to change the reimbursement state
	public int reimAnswer(int r_id, int stateNum, int mod_id);
	//Make a Reimbursement
	public void createReim(int mod_id,double amount,String reason, int state, int e_id, String type);
}


