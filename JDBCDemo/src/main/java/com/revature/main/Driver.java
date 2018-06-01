package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
//		try {
//			
//			Connection con = ConnectionUtil.getConnection();
//			System.out.println(con.getMetaData().getDriverName());
//			
//		} catch (SQLException | IOException e) {
//			e.printStackTrace();
//		}
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
//		List<Employee> allEmployees = edi.getEmployees();
//		for(Employee e: allEmployees) {
//			System.out.println(e);
//		}
		
//		System.out.println(edi.getEmployeeById(4));
		
		
		Date date = Date.valueOf("1594-09-12");
		Date hireDate = Date.valueOf("1611-10-11");
//		Employee e = new Employee("Gustavus Adolphus",date,0,1,hireDate,"King",0,1);
//		edi.createEmployee(e);
		
//		Employee e = edi.getEmployeeById(41);
//		System.out.println(e);
//		e.setMonthlySalary(10000);
//		//Employee e = new Employee(41,"Gustavus Adolphus",date,0,1,hireDate,"King",0,1);
//		edi.updateEmployee(e);
		
		edi.deleteEmployeeById(41);

	}

}
