package com.revature.dao;

import java.util.List;

import com.revature.pojo.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();
	public Employee getEMployeeById(int id);
	public int createEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployeeById(int id);
}
