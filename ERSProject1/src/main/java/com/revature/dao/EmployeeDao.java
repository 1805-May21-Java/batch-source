package com.revature.dao;

import java.util.List;

import com.revature.pojos.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByUsername(String username);
	public boolean isEmployeeManager(Employee employee);
	public void createEmployee(String firstname, String lastname, int reportsto, String email, String username, String password);
	public void updateEmployee(int id, String firstname, String lastname, String email, String username, String password);
	public List<Employee> getAllSubordinates(int id);
	public int deleteEmployeeById(int id);
}
