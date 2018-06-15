package com.revature.dao;

import java.util.HashMap;

import com.revature.pojos.Employee;

public interface EmployeeDao {
	
	public HashMap<String, Employee> getEmployees();
	
	public Employee getEmployeeByUsername(String username);
	
	public int deleteEmployeeByUsername(String username);
	
	public int updateEmployee(Employee newAccount);
	
	public void viewPendingByUsername(String username);
	
	public void viewResolvedByUsername(String username);
	
	public void approveReimbursement(int reimbursementId, String yesOrNo);
	
	public void pendingReimbursementsByEmployeeId(int EmployeeId);
	
}
