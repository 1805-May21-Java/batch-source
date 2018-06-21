package com.revature.dao;

import java.util.List;

import com.revature.pojos.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeByUsername(String username);
	public int createEmployee(Employee employee);
	public Employee getEmployeeById(int employeeId);

}
