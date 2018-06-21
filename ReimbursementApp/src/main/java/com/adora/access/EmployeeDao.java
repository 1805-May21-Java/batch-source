package com.adora.access;

import java.util.List;

import com.adora.pojos.Employee;

public interface EmployeeDao {
	//get all employees
	public List<Employee> getEmployees();
	//get a specific employee
	public Employee getEmployeeById(int employeeId);
}
