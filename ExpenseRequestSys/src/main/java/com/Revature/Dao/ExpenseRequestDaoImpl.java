package com.Revature.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Revature.Exceptions.NonExistentEmployee;
import com.Revature.Exceptions.NonExistentManager;
import com.Revature.Pojo.Employee;
import com.Revature.Pojo.ExpenseRequest;
import com.Revature.util.ConnectionUtil;

public class ExpenseRequestDaoImpl implements ExpenseRequestDao {

	@Override
	public int createExpenseRequest(ExpenseRequest er) throws SQLException, IOException, NonExistentEmployee {
		int rval = 0;

		// Verify that the submitter is non null and does exist
		EmployeeDao empDao = new EmployeeDaoImpl();
		if (er.getSubmitter() == null || empDao.checkUsernameAvailable(er.getSubmitter())) {
			throw new NonExistentEmployee();
		}

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO EXPENSE_REQUEST(USERNAME,AMOUNT,EXPENSE) VALUES(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, er.getSubmitter());
			stmt.setDouble(2, er.getAmount());
			stmt.setString(3, er.getExpense());

			rval = stmt.executeUpdate();
		}

		return rval;
	}

	@Override
	public ExpenseRequest getExpenseRequest(int id) throws SQLException, IOException {
		ExpenseRequest er = null;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EXPENSE_REQUEST WHERE REQUEST_ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String username = rs.getString("USERNAME");
				Date submissionDate = rs.getDate("SUBMISSION_DATE");
				double amount = rs.getDouble("AMOUNT");
				String expense = rs.getString("EXPENSE");
				String state = rs.getString("STATE");
				String resolvingManager = rs.getString("RESOLVING_MANAGER");

				er = new ExpenseRequest(id, username, submissionDate, amount, expense, state, resolvingManager);
			}
		}
		return er;
	}

	@Override
	public int updateExpenseRequest(ExpenseRequest er) throws SQLException, IOException, NonExistentManager {

		// Checks if there is a resolving manager and if he exists
		EmployeeDao empDao = new EmployeeDaoImpl();
		if (er.getResolvingManager() != null && empDao.checkUsernameAvailable(er.getResolvingManager())) {
			throw new NonExistentManager();
		}

		int rval = 0;

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "UPDATE EXPENSE_REQUEST SET RESOLVING_MANAGER = ?, STATE = ? WHERE REQUEST_ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, er.getResolvingManager());
			stmt.setString(2, er.getState());
			stmt.setInt(3, er.getRequestId());

			rval = stmt.executeUpdate();
		}

		return rval;
	}

	@Override
	public List<ExpenseRequest> getAllExpenseRequests(Employee e)
			throws SQLException, IOException, NonExistentEmployee {
		EmployeeDao empDao = new EmployeeDaoImpl();
		if (empDao.checkUsernameAvailable(e.getUsername())) {
			throw new NonExistentEmployee();
		}

		List<ExpenseRequest> erList = new ArrayList<ExpenseRequest>();

		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM EXPENSE_REQUEST WHERE USERNAME = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, e.getUsername());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REQUEST_ID");
				String username = rs.getString("USERNAME");
				Date submissionDate = rs.getDate("SUBMISSION_DATE");
				double amount = rs.getDouble("AMOUNT");
				String expense = rs.getString("EXPENSE");
				String state = rs.getString("STATE");
				String resolvingManager = rs.getString("RESOLVING_MANAGER");

				erList.add(new ExpenseRequest(id, username, submissionDate, amount, expense, state, resolvingManager));
			}
		}
		return erList;
	}

	@Override
	public List<ExpenseRequest> getAllExpenseRequests() throws SQLException, IOException {
		List<ExpenseRequest> erList = new ArrayList<ExpenseRequest>();

		try (Connection con = ConnectionUtil.getConnection()) {
			ResultSet rs = con.prepareStatement("SELECT * FROM EXPENSE_REQUEST").executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REQUEST_ID");
				String username = rs.getString("USERNAME");
				Date submissionDate = rs.getDate("SUBMISSION_DATE");
				double amount = rs.getDouble("AMOUNT");
				String expense = rs.getString("EXPENSE");
				String state = rs.getString("STATE");
				String resolvingManager = rs.getString("RESOLVING_MANAGER");

				erList.add(new ExpenseRequest(id, username, submissionDate, amount, expense, state, resolvingManager));
			}
		}

		return erList;
	}
}
