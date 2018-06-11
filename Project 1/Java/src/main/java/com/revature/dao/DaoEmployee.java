package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Employee;

public interface daoEmployee {
	public Employee getEmployeeById(int employeeId);
	public Employee EmployeeLogin(String email, String password);
	public boolean updateOldEmployee(Employee employee);
	public int insertNewEmployee(Employee employee);
	public ArrayList<Employee> getEmployeeByManagerId(int managerId);
	public boolean deleteEmployeeById(int employeeId);
}
