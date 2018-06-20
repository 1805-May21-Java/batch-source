package com.Revature.Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.Revature.Exceptions.NonExistentEmployee;
import com.Revature.Exceptions.NonExistentManager;
import com.Revature.Exceptions.UsernameTaken;
import com.Revature.Pojo.Employee;

public interface EmployeeDao {
	// A method to check if the username is used or not
	public boolean checkUsernameAvailable(String username) throws SQLException, IOException;

	// To add a new employee to the dbs
	public int createEmployee(Employee e) throws SQLException, IOException, UsernameTaken, NonExistentManager;

	// Returns an employee or null if there is no employee by this name
	public Employee getEmployee(String username) throws SQLException, IOException;

	// Method for updating an employees information
	public int updateEmployee(Employee e) throws SQLException, IOException, NonExistentManager;

	// Returns all employees
	public List<Employee> getAllEmployees() throws SQLException, IOException;

	// Returns all employees that are below
	// e on the corporate ladder
	// Returns null if e is not an employee
	public List<Employee> getSubEmployees(Employee e) throws SQLException, IOException;

	// Checks if there are employee that report to e
	public boolean isManager(Employee e) throws SQLException, IOException, NonExistentEmployee;

	// Method for checking whether a given employee is a sub employee of a manager
	public boolean isSubEmployee(Employee manager, Employee e) throws SQLException, IOException;
}
