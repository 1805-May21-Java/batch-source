package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import data.Employee;
import data.EmployeeDao;
import data.Reimbursement;
import data.ReimbursementDao;
import util.ConnectionUtil;

public class DatabaseConnectionTest {
	
	ConnectionUtil connection = new ConnectionUtil();
	
	@Test
	public void employeeDaoTest() throws SQLException, IOException {
		EmployeeDao employeeDao = new EmployeeDao();
		long employeeId = 1;
		Employee employee = employeeDao.getEmployeeById(connection.getConnection(), employeeId);
		if(employee == null){
			employeeDao.createEmployee(connection.getConnection(), 0, "Thomas Jansen", "password", "TJansen");
			employee = employeeDao.getEmployeeById(connection.getConnection(), employeeId);
		}
		assertNotNull(employee);
		
		assertTrue(employeeDao.checkEmployee(connection.getConnection(), "TJansen"));
		
		assertNotNull(employeeDao.getEmployeeByName(connection.getConnection(), "TJansen"));
		
		String newPassword = "password";
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
	public void reimbursementDaoTest() throws SQLException, IOException{
		ReimbursementDao reimbursementDao = new ReimbursementDao();
		long reimbursementId = 1;
		Reimbursement reimbursement = reimbursementDao.getReimbursementById(connection.getConnection(), reimbursementId);
		if(reimbursement == null) {
			reimbursementDao.createReimbursement(connection.getConnection(), 1, 10.12, 0, "reason", 1);
			reimbursement = reimbursementDao.getReimbursementById(connection.getConnection(), reimbursementId);
		}

		System.out.println(reimbursement);
		assertNotNull(reimbursement);

		System.out.println(reimbursementDao.getAllReimbursement(connection.getConnection()));
		assertNotNull(reimbursementDao.getAllReimbursement(connection.getConnection()));

		System.out.println(reimbursementDao.getReimbursementByEmployeeId(connection.getConnection(), 1));
		assertNotNull(reimbursementDao.getReimbursementByEmployeeId(connection.getConnection(), 1));
		
		int newStatus = 2;
		reimbursementDao.modifyReimbursement(connection.getConnection(), reimbursementId, 0, newStatus);
		reimbursement = reimbursementDao.getReimbursementById(connection.getConnection(), reimbursementId);
		assertEquals(reimbursement.getStatus(), newStatus);
	}

}
