package com.revature.dao;

import java.io.IOException;

import java.sql.*;
import java.util.*;

import com.revature.pojos.Employee;
import com.revature.pojos.Request;
import com.revature.utils.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "SELECT * FROM ERS_EMPLOYEE";
			PreparedStatement s = conn.prepareStatement(sql);
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("EMPL_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PWD");
				int managerId = rs.getInt("MANAGER_ID");
				List<Employee> staff = this.getEmployeesByManager(id);
				RequestDaoImpl rdi = new RequestDaoImpl();
				List<Request> requests = rdi.getRequestsByEmployeeId(id);
				
				
				employeeList.add(new Employee(id, firstName, lastName, email, password, managerId, staff, requests));
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeList;
	}
	
	public List<Employee> getEmployeesByManager(int managerId) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_EMPLOYEE WHERE MANAGER_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, managerId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("EMPL_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				RequestDaoImpl rdi = new RequestDaoImpl();
				List<Request> requests = rdi.getRequestsByEmployeeId(id);
				
				employeeList.add(new Employee(id, firstName, lastName, email, managerId, requests));
			}
			//Don't close because this is being used in the other get methods
			//conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}

	public Employee getEmployeeById(int emplId) {
		Employee emp = new Employee();
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_EMPLOYEE WHERE EMPL_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emplId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PWD");
				int managerId = rs.getInt("MANAGER_ID");
				List<Employee> staff = this.getEmployeesByManager(emplId);
				RequestDaoImpl rdi = new RequestDaoImpl();
				List<Request> requests = rdi.getRequestsByEmployeeId(emplId);
				
				emp = new Employee(emplId, firstName, lastName, email, password, managerId, staff, requests);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public Employee getEmployeeByEmail(String email) {
		Employee emp = new Employee();
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_EMPLOYEE WHERE EMAIL=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("EMPL_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String password = rs.getString("PWD");
				int managerId = rs.getInt("MANAGER_ID");
				List<Employee> staff = this.getEmployeesByManager(id);
				RequestDaoImpl rdi = new RequestDaoImpl();
				List<Request> requests = rdi.getRequestsByEmployeeId(id);
				
				emp = new Employee(id, firstName, lastName, email, password, managerId, staff, requests);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	public int createEmployee(Employee employee) {
		int employeesCreated = 0;
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql ="INSERT INTO ERS_EMPLOYEE (FIRSTNAME, LASTNAME, EMAIL, PWD, MANAGER_ID) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getFirstName());
			ps.setString(2,  employee.getLastName());
			ps.setString(3,  employee.getEmail());
			ps.setString(4,  employee.getPassword());
			ps.setInt(5,  employee.getManager());
			employeesCreated = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeesCreated;
	}

	public int updateEmployeeInfo(Employee employee) {
		int employeesUpdated = 0;
	
		try {
			Connection conn = ConnectionUtil.getConnection();
			//System.out.println(employee);
			String sql = "UPDATE ERS_EMPLOYEE "
					+ "SET FIRSTNAME = ?, "
					+ "LASTNAME = ?, "
					+ "EMAIL = ? "
					+ "WHERE EMPL_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  employee.getFirstName().toUpperCase());
			ps.setString(2,  employee.getLastName().toUpperCase());
			ps.setString(3, employee.getEmail().toUpperCase());
			ps.setInt(4,  employee.getId());
			employeesUpdated = ps.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return employeesUpdated;
	}
	
	public int updateEmployeePassword(int emplId, String password) {
		int passwordsUpdated = 0;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "UPDATE ERS_EMPLOYEE "
					+ "SET PWD = ? "
					+ "WHERE EMPL_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  password);
			ps.setInt(2, emplId);
			passwordsUpdated = ps.executeUpdate();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return passwordsUpdated;
	}

	public int removeEmployee(int emplId) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

	
}
