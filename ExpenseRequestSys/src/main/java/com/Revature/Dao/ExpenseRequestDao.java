package com.Revature.Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.Revature.Exceptions.NonExistentEmployee;
import com.Revature.Exceptions.NonExistentManager;
import com.Revature.Pojo.Employee;
import com.Revature.Pojo.ExpenseRequest;

public interface ExpenseRequestDao {
	// Attempts to create a new expense request
	// Throws non existent exception if the employee does not exist
	public int createExpenseRequest(ExpenseRequest er) throws SQLException, IOException, NonExistentEmployee;

	// A method of returning an expense request by id
	public ExpenseRequest getExpenseRequest(int id) throws SQLException, IOException;

	// A method for updating an expense request
	// The only members that will get updated are:
	// the state of the request and the resolving manager if applicable
	public int updateExpenseRequest(ExpenseRequest er) throws SQLException, IOException, NonExistentManager;

	// Gets all expense requests submitted by a specific employee
	public List<ExpenseRequest> getAllExpenseRequests(Employee e) throws SQLException, IOException, NonExistentEmployee;

	// Get all expense requests for all employees
	// For ease, overload prev method
	public List<ExpenseRequest> getAllExpenseRequests() throws SQLException, IOException;
}
