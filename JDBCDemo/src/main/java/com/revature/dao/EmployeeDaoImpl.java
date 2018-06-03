package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int employeeId = rs.getInt("EMP_ID");
				String name = rs.getString("EMP_NAME");
				Date birthday = rs.getDate("BIRTHDAY");
				int monthlySalary = rs.getInt("MONTHLY_SALARY");
				int departmentId = rs.getInt("DEPT_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				String position = rs.getString("POSITION");
				int managerId = rs.getInt("MANAGER_ID");
				int locationId = rs.getInt("EMP_LOCATION");
				employeeList.add( new Employee(employeeId, name, birthday, monthlySalary, departmentId, hireDate, position, managerId, locationId));
			}
			
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int employeeId = rs.getInt("EMP_ID");
				String name = rs.getString("EMP_NAME");
				Date birthday = rs.getDate("BIRTHDAY");
				int monthlySalary = rs.getInt("MONTHLY_SALARY");
				int departmentId = rs.getInt("DEPT_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				String position = rs.getString("POSITION");
				int managerId = rs.getInt("MANAGER_ID");
				int locationId = rs.getInt("EMP_LOCATION");
				e = new Employee(employeeId, name, birthday, monthlySalary, departmentId, hireDate, position, managerId, locationId);
			}
			
			con.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return e;
	}

	@Override
	public int createEmployee(Employee employee) {
		int employeeCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO EMPLOYEE (EMP_NAME, BIRTHDAY, MONTHLY_SALARY, DEPT_ID, HIRE_DATE, POSITION, MANAGER_ID, EMP_LOCATION) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ps.setDate(2, employee.getBirthday());
			ps.setInt(3, employee.getMonthlySalary());
			ps.setInt(4, employee.getDepartmentId());
			ps.setDate(5, employee.getHireDate());
			ps.setString(6, employee.getPosition());
			ps.setInt(7, employee.getManagerId());
			ps.setInt(8, employee.getLocationId());
			employeeCreated = ps.executeUpdate();
			con.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeCreated;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int employeesUpdated = 0;
		String sql = "UPDATE EMPLOYEE "
				+ "SET EMP_NAME = ?, "
				+ "BIRTHDAY = ?, "
				+ "MONTHLY_SALARY = ?, "
				+ "DEPT_ID = ?, "
				+ "HIRE_DATE = ?, "
				+ "POSITION = ?, "
				+ "MANAGER_ID = ?, "
				+ "EMP_LOCATION = ?"
				+ "WHERE EMP_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, employee.getName());
			pstatement.setDate(2, employee.getBirthday());
			pstatement.setInt(3, employee.getMonthlySalary());
			pstatement.setInt(4, employee.getDepartmentId());
			pstatement.setDate(5, employee.getHireDate());
			pstatement.setString(6, employee.getPosition());
			pstatement.setInt(7, employee.getManagerId());
			pstatement.setInt(8, employee.getLocationId());
			pstatement.setInt(9, employee.getId());
			employeesUpdated = pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeesUpdated;
	}

	@Override
	public int deleteEmployeeById(int id) {
		int rowsUpdated = 0;
		
		String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setInt(1, id);	
			rowsUpdated = pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

}
