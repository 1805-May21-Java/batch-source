package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Employee;

public interface DaoEmployee {
	public Employee getEmployeeById(int employeeId);
	public Employee employeeLogin(String email, String password);
	public int updateOldEmployee(Employee employee);
	public int insertNewEmployee(Employee employee);
	public ArrayList<Employee> getEmployeesByManagerId(int managerId);
	public int deleteEmployeeById(int employeeId);
	public int deleteAllEmployees(int managerId);
	public boolean emailExists(String email);
	String getPasswordFromEmail(String email);
}
