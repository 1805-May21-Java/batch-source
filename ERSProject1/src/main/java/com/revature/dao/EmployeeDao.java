package com.revature.dao;

import java.util.List;

import com.revature.pojos.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByUsername(String username);
	public boolean isEmployeeManager(Employee employee);
	public int createEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployeeById(int id);
}
