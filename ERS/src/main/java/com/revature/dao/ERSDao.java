package com.revature.dao;

import java.sql.Date;
import java.util.List;

import com.revature.pojos.EmployeeInfo;
import com.revature.pojos.ManagerInfo;
import com.revature.pojos.ReimbursementInfo;

public interface ERSDao {
	//here are all the functions needed that connects the datbase sql with java
	public EmployeeInfo findEmpByUP(String user, String pass);
	public ManagerInfo findManByUP(String user, String pass);
	public int updateEmployee(EmployeeInfo ei);
	public List<EmployeeInfo> empList();
	public int approve(int id, String name, Date aday);
	public int deny(int id);
	public int submit(ReimbursementInfo ri);
	public List<ReimbursementInfo> viewPending();
	public List<ReimbursementInfo> viewEPending(int userid);
	public List<ReimbursementInfo> viewApproved();
	public List<ReimbursementInfo> viewEApproved(int userid);
	public List<ReimbursementInfo> viewAllRR(int userid);
	public int createEmployee (EmployeeInfo ei);
	public String emailfromId(int id);
	public int idfromId(int id);
}
