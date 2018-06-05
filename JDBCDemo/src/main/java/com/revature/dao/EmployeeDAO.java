package com.revature.dao;

import java.util.List;

import com.revature.pojos.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public int createEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployeeById(int id);
	
}
