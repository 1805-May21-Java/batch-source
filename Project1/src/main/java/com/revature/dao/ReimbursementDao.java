package com.revature.dao;
import java.util.*;
import com.revature.pojos.*;

public interface ReimbursementDao
{
	public Map<Integer,Reimbursement> getReimbursementInfo();
	public Map<Integer,Reimbursement> getResolvedReimbursementInfo();
	public Reimbursement getReimbursementById(int id);
	public Reimbursement getResolvedReimbursementById(int id);
	public int updateReimbursement(Reimbursement re);
	public int createReimbursement(Reimbursement re);;
}
