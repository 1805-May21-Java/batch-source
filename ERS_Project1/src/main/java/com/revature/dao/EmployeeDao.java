package com.revature.dao;

import java.util.List;

import com.revature.pojos.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesByManager(int managerId);
	public Employee getEmployeeById(int emplId);
	public Employee getEmployeeByEmail(String email);
	public int createEmployee(Employee employee);
	public int updateEmployeeInfo(Employee employee);
	public int updateEmployeePassword(int emplId, String password);
	public int removeEmployee(int emplId);
}
