package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.DepartmentDAOImpl;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.pojos.Department;
import com.revature.pojos.Employee;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		DepartmentDAOImpl ddi = new DepartmentDAOImpl();
		ddi.increaseBudget(4, 6000);
		
		
//		EmployeeDAOImpl edi = new EmployeeDAOImpl();
//	// 	System.out.println(edi.getEmployeeById(4));
//		Date date = Date.valueOf("1594-09-12");
//		Date hireDate = Date.valueOf("1611-10-11");
//		Employee e = new Employee("Gustavus Adolphus", date, 0, 1, hireDate, "King", 0, 2);
//		edi.createEmployee(e);
		
		// creates a DDAOImpl object ddi
//		DepartmentDAOImpl ddi = new DepartmentDAOImpl();
		// calls .getDepartments on ddi, saves it to a List named allDepts
//		List<Department> allDepts = ddi.getDepartments();
//		iterates through each department in allDepts and prints the lien
//		for (Department d : allDepts) {
//			System.out.println(d);
//		}
		// if this is run with line creating ddi object, prints dept info for specified dept id
//		Department queryDept = ddi.getDepartmentById(3);
//		System.out.println(queryDept);
		
		
//		EmployeeDAOImpl edi = new EmployeeDAOImpl();
//		List<Employee> allEmployees = edi.getEmployees();
//		
//		for (Employee e : allEmployees) {
//			System.out.println(e);
//		}
		
		
//		try {
//			
//			Connection con = ConnectionUtil.getConnection();
//			System.out.println(con.getMetaData().getDriverName());
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
