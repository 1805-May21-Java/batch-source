package com.revature.dao;

import java.util.List;

import com.revature.pojos.*;

public interface EmployeeDAO {
	//Get all Employees in DB
	public List<employee> getEmployees();
	//Check to see if passed Employee has manager Type_ID tag by comparing list of managers to employee list
	public boolean etypeCheck(employee emp);
	//Retireve Employee by Username
	public employee getEmployeeByUser(String user);
	//Get Employees by ID
	public employee getEmployeeByID(int e_Id);
	//Creates Employees
	public int createEmployee(employee emp);
	//Updates Info about Employees
	public int updateInfo(employee emp);
}

