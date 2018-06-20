package com.revature.dao;

import static org.junit.Assert.*;



import org.junit.Test;

import com.revature.pojos.Employee;
import com.revature.pojos.Manager;

public class DaoEmployeeImplTest {
	static DaoEmployeeImpl dImplE = new DaoEmployeeImpl();

	@Test
	public void saveNewEmployee() {
		int id = dImplE.insertNewEmployee(new Employee("Bob","hello@gmail.com","password",1));
		assertEquals(dImplE.getEmployeeById(id).getName(), "Bob");
		dImplE.deleteEmployeeById(id);
	}
	@Test
	public void getEmployeeExistingId() {
		//known employee
		Employee employee= dImplE.getEmployeeById(2);
		assertEquals("Jeffrey Terrasse",employee.getName());
	}
	@Test
	public void loginEmployeeCredentials() {
		Employee employee= dImplE.employeeLogin("insert@java.com", "password");
		assertEquals(employee.getName(),"Jeffrey Terrasse");
	}
	@Test
	public void loginManagerCredentials() {
		Manager manager= (Manager) dImplE.employeeLogin("holly.reimbursements@gmail.com", "password");
	
		assertTrue(manager.getEmployeeList().size() > 0);
	}
	@Test
	public void getAllEmployeesExistantManager() {
		//Know that Holly is a manager of at least one employee
		Employee employee = dImplE.getEmployeesByManagerId(1).get(0);
		assertEquals(1, employee.getManagerId());
	}
	@Test
	public void getAllEmployeesNonExistingManager() {
		assertEquals(0,dImplE.getEmployeesByManagerId(-5).size());
	}
	@Test
	public void deleteEmployeeExistingId() {
		Employee employee= new Employee("Hi","dummy","pass",1);
		int id = dImplE.insertNewEmployee(employee);
		assertEquals(1, dImplE.deleteEmployeeById(id));
	}
	@Test
	public void deleteEmployeeNonexistentId() {
		assertEquals(0,dImplE.deleteEmployeeById(-5));
	}
	
	
}
