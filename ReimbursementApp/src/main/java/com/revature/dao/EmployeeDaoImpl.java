package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;



import com.revature.pojos.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	public HashMap<String, Employee> getEmployees() {
		
		HashMap<String, Employee> employeeData = new HashMap<String, Employee>();
		//try/catch block is used to catch any possible IOException and SQLException
		try {
			//Connection con is used to create a Statement instance
			//using String sql to retrieve all rows from table EMPLOYEE
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE";
			//Uses Statement
			Statement s = con.createStatement();
			//ResultSet rs stores result of Statement
			ResultSet rs = s.executeQuery(sql);
			//rs is iterated over and values are retrieved and stored into
			//HashMap employeeData
			while(rs.next()) {
				Integer employeeId = rs.getInt("EMPLOYEE_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String address = rs.getString("ADDRESS");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				Integer isManager = rs.getInt("ISMANAGER");
				employeeData.put(username, new Employee(employeeId, firstname,
						lastname, username, password, address, email, phone, isManager));
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return employeeData;
	}

	public Employee getEmployeeByUsername(String username) {
		Employee user = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			//PreparedStatement is created using the Connection con
			PreparedStatement ps = con.prepareStatement(sql);
			//PreparedStatment is passed username and then executed.
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			//Result set is iterated and data retrieved to create a 
			//new Account object.
			while(rs.next()) {
				Integer employeeId = rs.getInt("EMPLOYEE_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String user_name = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String address = rs.getString("ADDRESS");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				Integer isManager = rs.getInt("ISMANAGER");
				user = new Employee(employeeId, firstname, lastname, user_name,
						password, address, email, phone, isManager);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}

	public int deleteEmployeeByUsername(String username) {
		int employeesDeleted = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			//Auto commit set to false to prevent uncalled commits
			con.setAutoCommit(false);
			String sql = "DELETE FROM EMPLOYEE WHERE USERNAME = ?";
			//Used PreparedStatement and filled the ? with username.
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, username);
			//PreparedStatement is executed and committed
			employeesDeleted = pStatement.executeUpdate();
			con.commit();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//returns number of rows deleted from database
		return employeesDeleted;
	}

	public int updateEmployee(Employee newAccount) {
		int accountsUpdated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			//Auto commit is set to false to prevent uncalled commits
			con.setAutoCommit(false);
			String sql = "UPDATE EMPLOYEE "
					+ "SET PASSWORD = ?, "
					+ "ADDRESS = ?, "
					+ "EMAIL = ?, "
					+ "PHONE = ?"
					+ " WHERE USERNAME = ?";
			//Used PreparedStatement and filled it with values from newAccount
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, newAccount.getPassword());
			pStatement.setString(2, newAccount.getAddress());
			pStatement.setString(3, newAccount.getEmail());
			pStatement.setString(4, newAccount.getPhone());
			pStatement.setString(5, newAccount.getUsername());
			//PreparedStatment is executed and commited.
			accountsUpdated = pStatement.executeUpdate();
			con.commit();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//returns number of rows updated in the database.
		return accountsUpdated;
	}

	//return reimbursement rows as a hashmap
	public void viewPendingById(Integer employeeId) {
		// TODO Auto-generated method stub
		
	}

	public void viewResolvedById(Integer employeeId) {
		// TODO Auto-generated method stub
		
	}

	public void approveReimbursement(int reimbursementId, String yesOrNo) {
		// TODO Auto-generated method stub
		
	}

	public void pendingReimbursementsByEmployeeId(int EmployeeId) {
		// TODO Auto-generated method stub
		
	}

}
