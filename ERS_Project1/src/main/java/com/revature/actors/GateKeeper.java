package com.revature.actors;

import java.util.List;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

public class GateKeeper {
	private static String warning = "";
	public static String getWarning() {
		return warning;
	}
	public static void setWarning(String warning) {
		GateKeeper.warning = warning;
	}

	public static boolean validLogin(String email, String password) {
		if(email.equals("") || password.equals("")) {
			warning = "All fields must be completed";
			return false;
		}

		if(!isValidEmail(email)) {
			warning ="Invalid email";
			return false;
		}
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		List<Employee> completeList = edi.getEmployees();
		for(Employee emp : completeList) {
			if(emp.getEmail().equals(email.toUpperCase()) && emp.getPassword().equals(password)) {
				return true;
			}
		}
		
		GateKeeper.warning = "Email and password didn't match any of our clients.";
		return false;
	}
	
	public static boolean attemptRegistration(
			String firstName, String lastName, String email, String registration, String password, String confirmPassword) {
		if(firstName.equals("") || lastName.equals("") || email.equals("") || registration.equals("") || password.equals("") || confirmPassword.equals("")) {
			warning = "All fields must be completed.";
			return false;
		}
		
		if(!password.equals(confirmPassword)) {
			warning = "Confirmation password didn't match.";
			return false;
		}

		if(!isValidEmail(email)) {
			warning = "Invalid email";
			return false;
		}
		//TODO : Check if email is taken
		//TODO : Check for manager id
		//TODO : if all passes, add user to db
		return true;	
	}
	
	private static boolean isValidEmail(String str) {
		int at = str.indexOf('@');
		int dot = str.lastIndexOf('.');
		
		if(dot >= 0 && at > 0 && dot < str.length()-1 && at < dot) {
			return true;
		}
		return false;
	}
}
