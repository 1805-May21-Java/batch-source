package com.revature.htulipan.Project1.daos;

import java.util.ArrayList;

import com.revature.htulipan.Project1.pojos.Employee;

public interface EmployeeDao {
	/**
	 * Which interactions with my SQL database do I want to support?
	 */
	public int checkLoginCredentials(String username, String password);
	public Employee getEmployeeById(int id);
	public int updateEmployee(Employee emp);
	public ArrayList<Employee> getAllEmployees();
	
}
