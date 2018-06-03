package com.revature.dao;

import java.util.*;

import com.revature.pojos.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEmployeeByID(int id);
	public int createEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployeeById(int id);
}
