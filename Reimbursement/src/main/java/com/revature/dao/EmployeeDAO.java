package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.employee;
import com.revature.util.*;

public class EmployeeDAO implements EmployeeDAOImpl {

	public List<employee> getEmployees() {
		List<employee> employeeList = new ArrayList<employee>();
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}

	public employee getEmployeeByID(int e_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createEmployee(employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateInfo(employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeEmp(int e_Id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
