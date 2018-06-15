package com.revature.daos;

import java.util.*;

import com.revature.pojos.*;

public interface EmployeeDao
{
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById();
	public void updateEmployee(Employee employee);

}
