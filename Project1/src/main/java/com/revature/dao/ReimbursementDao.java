package com.revature.dao;
import java.util.*;
import com.revature.pojos.*;

public interface ReimbursementDao
{
	public List<Reimbursement> getReimbursementInfo();
	public List<Reimbursement> getResolvedReimbursementInfo();
	public List<Reimbursement> getReimbursementById(int id);
	public List<Reimbursement> getResolvedReimbursementById(int id);
	public int updateReimbursement(Reimbursement re);
	public int createReimbursement(Reimbursement re);;
}
