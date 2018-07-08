package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<Department>();
		
		String sql = "SELECT * FROM DEPARTMENT";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int employeeId = rs.getInt("DEPT_ID");
				String name = rs.getString("DEPT_NAME");
				int budget = rs.getInt("MONTHLY_BUDGET");
				departments.add(new Department(employeeId, name, budget));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return departments;
	}

	public Department getDepartmentById(int id) {
		Department d = null;

		String sql = "SELECT * FROM DEPARTMENT WHERE DEPT_ID = ?";

		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setInt(1, id);
			ResultSet rs = pstatement.executeQuery();

			while (rs.next()) {
				int employeeId = rs.getInt("DEPT_ID");
				String name = rs.getString("DEPT_NAME");
				int budget = rs.getInt("MONTHLY_BUDGET");
				d = new Department(employeeId, name, budget);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return d;
	}

	public Department getDepartmentByName(String name) {
		Department d = null;

		String sql = "SELECT * FROM DEPARTMENT WHERE DPT_NAME = ?";

		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, name);
			ResultSet rs = pstatement.executeQuery();

			while (rs.next()) {
				int employeeId = rs.getInt("DEPT_ID");
				String dptName = rs.getString("DEPT_NAME");
				int budget = rs.getInt("MONTHLY_BUDGET");
				d = new Department(employeeId, dptName, budget);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return d;
	}

	public int createDepartment(Department department) {
		int departmentsCreated = 0;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO DEPARTMENT (DEPT_NAME, MONTHLY_BUDGET) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, department.getName());
			ps.setInt(2, department.getMonthlyBudget());
			departmentsCreated = ps.executeUpdate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departmentsCreated;
	}

	
	public int updateDepartment(Department department) {
		int departmentsUpdated = 0;
		String sql = "UPDATE DEPARTMENT "
				+ "SET DEPT_NAME = ?, "
				+ "MONTHLY_BUDGET = ? "
				+ "WHERE DEPT_ID = ?";
		try {
			Connection con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setString(1, department.getName());
			pstatement.setInt(2, department.getMonthlyBudget());
			pstatement.setInt(3, department.getId());
			departmentsUpdated = pstatement.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentsUpdated;
	}

	
	public int deleteDepartmentById(int id) {
		int rowsUpdated = 0;
		String sql = "DELETE FROM DEPARTMENT WHERE DEPT_ID = ?";
		
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement pstatement = con.prepareStatement(sql);
			pstatement.setInt(1, id);
			rowsUpdated = pstatement.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return rowsUpdated;
	}

	@Override
	public void increaseBudget(int dept, int val) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "{call INCREASE_BUDGET(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, dept);
			cs.setInt(2, val);
			cs.execute();
			con.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
