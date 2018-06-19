package com.revature.dao;

import java.util.List;

import com.revature.pojos.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeByUsername(String empId);
	public List<Employee> getAllEmployeesByManager(int managerId);
	public int updateEmployee(Employee emp);
	public int createEmployee(Employee emp);
	public int deleteEmployee(Employee emp);
}
