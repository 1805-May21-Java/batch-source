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

public class DepartmentDAOImpl implements DepartmentDAO {

	public List<Department> getDepartments() {
		List<Department> dList = new ArrayList<Department>();
		
		try {
			
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM DEPARTMENT";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int deptId = rs.getInt("DEPT_ID");
				String deptName = rs.getString("DEPT_NAME");
				int monthlyBudget = rs.getInt("MONTHLY_BUDGET");
				dList.add(new Department(deptId, deptName, monthlyBudget));
			}
			con.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dList;
	}

	public Department getDepartmentById(int id) {

		Department d = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM DEPARTMENT WHERE DEPT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int deptId = rs.getInt("DEPT_ID");
				String deptName = rs.getString("DEPT_NAME");
				int monthlyBudget = rs.getInt("MONTHLY_BUDGET");
				d = new Department(deptId, deptName, monthlyBudget);
				
			}
			con.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return d;
	}

	public void increaseBudget(int dept, int val) {
		
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "{call INCREASE_BUDGET(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1,  dept);
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
