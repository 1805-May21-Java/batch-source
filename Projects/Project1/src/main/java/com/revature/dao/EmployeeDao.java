package com.revature.dao;

import java.util.List;

import com.revature.pojos.Employee;

public interface EmployeeDao 
{

	List<Employee> getEmployees();
	Employee getEmployeeById(int id);
	Employee getEmployeeByName(String name);
//	Boolean isEmployeeNameExist(String newName);
	Boolean isAuthenticated(String newName, String newPassword);
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployeeById(int id);
}
