package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		try {
			Connection con = ConnectionUtil.getConnection();
			System.out.println(con.getMetaData().getDriverName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		List<Employee>allEmployees = edi.getEmployees();
		for(Employee e: allEmployees)
			System.out.println(e);
	}

}
