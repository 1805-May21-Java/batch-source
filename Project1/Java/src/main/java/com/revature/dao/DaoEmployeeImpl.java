package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.revature.pojos.Employee;
import com.revature.pojos.Manager;
import com.revature.util.ConnectionUtil;
import com.revature.util.ERSContract;

public class DaoEmployeeImpl implements DaoEmployee {

	public Employee getEmployeeById(int employeeId) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("SELECT * FROM %s WHERE %s = ?",
					ERSContract.EMPLOYEE_TABLE_NAME,ERSContract.EMPLOYEE_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				return new Employee(
						employeeId,
						resultSet.getString(ERSContract.EMPLOYEE_NAME),
						resultSet.getString(ERSContract.EMPLOYEE_EMAIL),
						resultSet.getString(ERSContract.EMPLOYEE_PASSWORD),
						resultSet.getInt(ERSContract.EMPLOYEE_MANAGER_ID));
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee employeeLogin(String email, String password) {
		Connection connection = null;
		try{
			connection = ConnectionUtil.getConnection();
			String sql = String.format("SELECT * FROM %s WHERE (%s = ? AND %s = ?)",
				ERSContract.EMPLOYEE_TABLE_NAME,ERSContract.EMPLOYEE_EMAIL, ERSContract.EMPLOYEE_PASSWORD);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Employee employee = new Manager(
						resultSet.getInt(ERSContract.EMPLOYEE_ID),
						resultSet.getString(ERSContract.EMPLOYEE_NAME),
						resultSet.getString(ERSContract.EMPLOYEE_EMAIL),
						resultSet.getString(ERSContract.EMPLOYEE_PASSWORD),
						resultSet.getInt(ERSContract.EMPLOYEE_MANAGER_ID));
				
				//sees if employee is the manager of any people 
				//if so cast as a manager, if not return employee
				ArrayList<Employee> empList = ((Manager) employee).getEmployeesUnderManager();
				if(empList.size() > 0) {
					//is a manager, add the employlist and return as manager
					Manager manager = (Manager) employee;
					manager.setEmployeeList(empList);
					return manager;
				}else {
					return (Employee) employee;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}finally {
			//close connection, catches exceptions that might come from closing multiple at the same time
			try { connection.close();}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public boolean emailExists(String email) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("SELECT * FROM %s WHERE %s = ?",
				ERSContract.EMPLOYEE_TABLE_NAME,ERSContract.EMPLOYEE_EMAIL);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				//if inside here, then there is an email address matching the string
				return true;
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		//if out here, was not able to find matching email
		return false;
	}
	
	@Override
	public String getPasswordFromEmail(String email) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("SELECT * FROM %s WHERE %s = ?",
				ERSContract.EMPLOYEE_TABLE_NAME,ERSContract.EMPLOYEE_EMAIL);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("here!");
				//if inside here, then there is an email address matching the string
				return resultSet.getString(ERSContract.EMPLOYEE_PASSWORD);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		//if out here, was not able to find matching email
		return null;
	}

	public int updateOldEmployee(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?",
					ERSContract.EMPLOYEE_TABLE_NAME,
					ERSContract.EMPLOYEE_NAME,
					ERSContract.EMPLOYEE_EMAIL,
					ERSContract.EMPLOYEE_PASSWORD,
					ERSContract.EMPLOYEE_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPassword());
			preparedStatement.setInt(4, employee.getIdNumber());
			return preparedStatement.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Employee> getEmployeesByManagerId(int managerId) {
		ArrayList<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		try{
			connection = ConnectionUtil.getConnection();
			String sql = String.format("SELECT * FROM %s WHERE %s = ?", 
					ERSContract.EMPLOYEE_TABLE_NAME,ERSContract.EMPLOYEE_MANAGER_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, managerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				employeeList.add(new Employee(
						resultSet.getInt(ERSContract.EMPLOYEE_ID), 
						resultSet.getString(ERSContract.EMPLOYEE_NAME), 
						resultSet.getString(ERSContract.EMPLOYEE_EMAIL), 
						resultSet.getString(ERSContract.EMPLOYEE_PASSWORD),
						resultSet.getInt(ERSContract.EMPLOYEE_MANAGER_ID)));
			}
			return employeeList;
		} catch (SQLException | IOException e) {	
		}finally {
			try {connection.close();}catch (SQLException e) {
			}
		}
		return null;
	}

	public int deleteEmployeeById(int employeeId) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("DELETE FROM %s WHERE %s = ?", 
					ERSContract.EMPLOYEE_TABLE_NAME,ERSContract.EMPLOYEE_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employeeId);
			return preparedStatement.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insertNewEmployee(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("BEGIN INSERT INTO %s (%s, %s, %s, %s) VALUES(?,?,?,?)"
					+ " RETURNING %s INTO ?;END;", 
					ERSContract.EMPLOYEE_TABLE_NAME,
					ERSContract.EMPLOYEE_NAME,
					ERSContract.EMPLOYEE_EMAIL,
					ERSContract.EMPLOYEE_PASSWORD,
					ERSContract.EMPLOYEE_MANAGER_ID,
					ERSContract.EMPLOYEE_ID);
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setString(1, employee.getName());
			callableStatement.setString(2, employee.getEmail());
			callableStatement.setString(3, employee.getPassword());
			callableStatement.setInt(4, employee.getManagerId());
			callableStatement.registerOutParameter(5, Types.NUMERIC);
			callableStatement.execute();
			return callableStatement.getInt(5);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAllEmployees(int managerId) {
		//Deletes all of a manager's employees
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = String.format("DELETE FROM %s WHERE %s = ?", 
					ERSContract.EMPLOYEE_TABLE_NAME,ERSContract.EMPLOYEE_MANAGER_ID);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, managerId);
			return preparedStatement.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	

}
