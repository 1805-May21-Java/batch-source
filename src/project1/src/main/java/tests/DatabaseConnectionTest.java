package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import data.Employee;
import data.EmployeeDao;
import util.ConnectionUtil;

public class DatabaseConnectionTest {
	
	ConnectionUtil connection = new ConnectionUtil();
	
	@Test
	public void employeeDaoTest() throws SQLException, IOException {
		EmployeeDao employeeDao = new EmployeeDao();
		long employeeId = 1;
		Employee employee = employeeDao.getEmployeeById(connection.getConnection(), employeeId);
		if(employee == null){
			employeeDao.createEmployee(connection.getConnection(), employeeId, 0, "Thomas Jansen", "password", "TJansen");
			employee = employeeDao.getEmployeeById(connection.getConnection(), employeeId);
		}
		assertNotNull(employee);
		
		assertTrue(employeeDao.checkEmployee(connection.getConnection(), "TJansen"));
		
		assertNotNull(employeeDao.getEmployeeByName(connection.getConnection(), "TJansen"));
		
		String newPassword = "password12";
		employeeDao.updateEmployeePassword(connection.getConnection(), employeeId, newPassword);
		PreparedStatement ps = connection.getConnection().prepareStatement("SELECT * FROM EMPLOYEE WHERE password = ?");
		ps.setString(1, newPassword);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			employee = new Employee(rs.getLong("employeeId"), rs.getLong("reportsTo"), rs.getString("employeeName"), rs.getString("password"), rs.getString("username"));
		}
		assertEquals(employee.getPassword(), newPassword);
		
		assertNotNull(employeeDao.getAllEmployee(connection.getConnection()));
//		System.out.println(employeeDao.getAllEmployee(connection.getConnection()));
	}
	
	@Test
	public void reimbursementDaoTest(){
		
	}

}
