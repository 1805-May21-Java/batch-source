package com.revature.daos;

import java.util.*;
import com.revature.pojos.*;

public interface EmployeeDao
{
	public Employee getEmployeeById(int id);
	public Employee getEmployeeByCredentials(String email, String pass);
	public List<Employee> getAllEmployees();
	public boolean isValidLogin(String email, String pass);
	public void updateEmployee(Employee emp);
}
