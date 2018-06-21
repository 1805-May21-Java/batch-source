package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	//Gets list of Employees and returns a list of the users
	public List<employee> getEmployees() {
		List<employee> employeeList = new ArrayList<employee>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("E_ID");
				String name = rs.getString("EMP_NAME");
				String jobType = rs.getString("E_TYPE");
				String userName = rs.getString("E_USERNAME");
				String pass = rs.getString("E_PASSWORD");
				String position = rs.getString("E_POSITION");
				
				employeeList.add(new employee(id,name,jobType,userName,pass,position));
				
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}
	//Gets list of employees whose Type ID = manager so they can get directed to the manager page at login
	public boolean etypeCheck(employee emp) {
		List<employee> employeemanage = new ArrayList<employee>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE E_TYPE = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Manager");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int eID = rs.getInt("E_ID");
				String name = rs.getString("EMP_NAME");
				String eType = rs.getString("E_TYPE");
				String euser = rs.getString("E_USERNAME");
				String epass = rs.getString("E_PASSWORD");
				String eposit = rs.getString("E_POSITION");
				
				employeemanage.add(new employee(eID,name,eType,euser,epass,eposit));
			}
			conn.close();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		for(employee person : employeemanage) {
			if(emp.getE_Id() == person.getE_Id()) {
				return true;
			}
		}
		
		return false;
	}
	
	//Gets employee by username 
	public employee getEmployeeByUser(String user) {
		employee employ= null;
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE E_USERNAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empid = rs.getInt("E_ID");
				String name = rs.getString("EMP_NAME");
				String type = rs.getString("E_TYPE");
				String pass = rs.getString("E_PASSWORD");
				String posit = rs.getString("E_POSITION");
				
			
			employ= new employee(empid,name,type,user,pass,posit);
			}
			conn.close();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employ;
		
	}
	//Gets the employee's by ID's and returns the employee record
	public employee getEmployeeByID(int e_Id) {
		employee e = new employee();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE E_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e_Id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("EMP_NAME");
				String jobRole = rs.getString("E_TYPE");
				String uName = rs.getString("E_USERNAME");
				String pass = rs.getString("E_PASSWORD");
				String jobType = rs.getString("E_POSITION");
				
				e = new employee(e_Id,name,jobRole,uName,pass,jobType);
			}
			conn.close();
		}catch(SQLException g) {
			g.printStackTrace();
		}catch(IOException g) {
			g.printStackTrace();
		}
		
		return e;
	}
	//Creates Employees and puts them in the DB
	public int createEmployee(employee emp) {
		int creationNum = 0;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "INSERT INTO EMPLOYEE (EMP_NAME,E_TYPE,E_USERNAME,E_PASSWORD,E_POSITION) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getEmpName());
			ps.setString(2, emp.getEmpType());
			ps.setString(3, emp.getuName());
			ps.setString(4, emp.getuPass());
			ps.setString(5, emp.getePosition());
			creationNum = ps.executeUpdate();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return creationNum;
	}
	//Update basic Employee Info: Name, Username
	public int updateInfo(employee emp) {
		int updateNum = 0;
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "UPDATE EMPLOYEE" + "SET EMP_NAME = ?" + "E_USERNAME = ?" + "WHERE E_ID =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  emp.getEmpName().toUpperCase());
			ps.setString(2, emp.getuName().toUpperCase());
			ps.setInt(3, emp.getE_Id());
			
			updateNum = ps.executeUpdate();
			
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return updateNum;
	}

}
