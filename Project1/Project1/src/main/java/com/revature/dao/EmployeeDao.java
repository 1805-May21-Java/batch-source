package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Employee;

public interface EmployeeDao {
	public Employee getEmployee(String email, String password);
	public Employee getEmployee(String email);
	public ArrayList<Employee> getEmployees();
	public int createEmployee(String email, String password);
	public int updatePassword(String email, String password);
	public int updateEmplyee(String email, String firstName, String lastName, String phone, String streetAddress, String city, String state, String zipCode);
}
