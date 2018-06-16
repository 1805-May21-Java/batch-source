package com.revature.dao;

import com.revature.pojo.Employee;
import com.revature.pojo.Reimbursement;

import java.util.LinkedList;

public interface ERSDao {
	public LinkedList<Reimbursement> getReimbursementsByEmplID(int empl_id);
	public LinkedList<Reimbursement> getReimbursementsByManagerID(int empl_id);
	
	public Employee getEmployeeByID(int ID);
	public Employee getEmployeeByEmail(String email);
	public Reimbursement getReimbursementByID(int ID);
	
	public int createEmployee(Employee empl);
	public int createReimbursement(Reimbursement reimb);
	
	public int updateEmployee(Employee empl);
	public int updateReimbursement(Reimbursement reimb);
	
	public int deleteEmployeeByID(int empl_id);
}
