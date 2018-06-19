import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Reimbursement;
//import com.revature.servlets.EmployeeServlet;


class DaoImplementsTests
{


//	@Test
//	void getEmployees()
//	{
//		List<Employee> employees = new ArrayList<>();
//		EmployeeDao dao = new EmployeeDaoImpl();
//		employees = dao.getEmployees();
//		System.out.println(employees.size());
//	}
//	
//	@Test
//	void getEmployeeById()
//	{
//		Employee employee = new Employee();
//		EmployeeDao dao = new EmployeeDaoImpl();
//		employee = dao.getEmployeeById(1);
//		System.out.println(employee.getEmpName());
//	}
//	
//	@Test
//	void getEmployeeByName()
//	{
//		EmployeeDao dao = new EmployeeDaoImpl();
//		Employee employee = dao.getEmployeeByName("Vannara Houth");
//		System.out.println(employee.getEmpName());
//	}
	
	@Test
	void isAuthenticated()
	{
		EmployeeDao dao = new EmployeeDaoImpl();
		Boolean isAuthenticated =dao.isAuthenticated("Vannara", "123");
		System.out.println(isAuthenticated);
	}
	
	
//	@Test
//	void createEmployee()
//	{
//		EmployeeDao dao = new EmployeeDaoImpl();
//		Employee employee = new Employee("James Bond", "James", "password", 1, Date.valueOf("1980-10-10"), "www.google.com" );
//		dao.createEmployee(employee);
//
//	}
//	
//	
//	@Test
//	void updateEmployee()
//	{
//		EmployeeDao dao = new EmployeeDaoImpl();
//		Employee employee = new Employee(2, "Michael Everd", "James", "password", 1, Date.valueOf("1999-10-10"), "www.google.com" );
//		dao.updateEmployee(employee);
//	}
//	
//	@Test
//	void deleteEmployeeById()
//	{
//		EmployeeDao dao = new EmployeeDaoImpl();
//		dao.deleteEmployeeById(2);
//	}
//
//	
//	@Test
//	void getReimbursements()
//	{
//		ReimbursementDao dao = new ReimbursementDaoImpl();
//		List<Reimbursement> reimbursements = dao.getReimbursements();
//		System.out.println(reimbursements.size());
//	}
//	
//	@Test
//	void getReimbursementById()
//	{
//		ReimbursementDao dao = new ReimbursementDaoImpl();
//		Reimbursement reimbursement = dao.getReimbursementById(2);
//		System.out.println(reimbursement.getAmount());
//	}
//	
//	
//	@Test
//	void createReimbursement()
//	{
//		ReimbursementDao dao = new ReimbursementDaoImpl();
//		Reimbursement reimbursement = new Reimbursement(1, 12.56, 1, Date.valueOf("1999-10-10"),  Date.valueOf("1999-10-10"), "Denied", "wwww.twitter.com");
//		dao.createReimbursement(reimbursement);
//	}
//	
//	@Test
//	void deleteReimbursement()
//	{
//		ReimbursementDao dao = new ReimbursementDaoImpl();
//		dao.deleteReimbursementById(2);
//	}
//	
//	
//	@Test
//	void updateReimbursement()
//	{
//		ReimbursementDao dao = new ReimbursementDaoImpl();
//		Reimbursement reimbursement = new Reimbursement(3, 1, 133.56, 1, Date.valueOf("1999-10-10"),  Date.valueOf("1999-10-10"), "Denied", "wwww.twitter.com");
//		dao.updateReimbursement(reimbursement);
//	}
//
//	@Test
//	void listOfReimbursenetByEmpIds()
//	{
//		ReimbursementDao dao = new ReimbursementDaoImpl();
//		List<Reimbursement> reimbursements = dao.getReimbursements();
//		
//		EmployeeDao daoEmp = new EmployeeDaoImpl();
//		List<Employee> employees = daoEmp.getEmployees();
//		
//		for(Employee reimbursement: employees)
//		{
//			System.out.println(reimbursement.getEmpName());
//		}
//		int managerId =2;
//		List<Integer> empIds =  daoEmp.getEmployeesUnderManager(employees, managerId);
//		
//		for(Integer i : empIds)
//		{
//			System.out.println(i);
//		}
//		
//		List<Reimbursement> reimbursements2=dao.getReimbursementsByEmpIds(reimbursements, empIds);
//		
//		for(Reimbursement reimbursement: reimbursements2)
//		{
//			System.out.println(reimbursement.getReimburseId());
//		}
//		
//	}

	@Test
	void getIdbyUser()
	{
		EmployeeDao edi = new EmployeeDaoImpl();
		System.out.println(edi.getIdByUser("jackson"));
		
	}
	
	
	

	

}
