package utilities;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.EmployeeDAOImpl;
import dao.ManagerDAOImpl;
import dao.RequestDAOImpl;
import model.Employee;
import model.Manager;
import model.Request;

public class Driver {

	public static void main(String[] args) {
		
//		ManagerDAOImpl man1 = new ManagerDAOImpl();
//		ArrayList<Manager> mans = man1.getManagers();
//		System.out.println(mans.get(2));
		
//		ManagerDAOImpl manCheck = new ManagerDAOImpl();
//        String passcheck = manCheck.getManagerByEmail("dirk@mavs.com");
//        System.out.println(passcheck);
		
		EmployeeDAOImpl em1 = new EmployeeDAOImpl();
		System.out.println(em1.getEmployeeByEmail("dame@blazers.com"));
		
//		RequestDAOImpl r = new RequestDAOImpl();
//		r.submitNewRequest(100.00, 4);
		

	}

}
