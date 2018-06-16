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
		
		boolean managerAvailable = false;
		int registrationNumber = -1;
		try {
			registrationNumber = Integer.parseInt(registration);
		} catch (NumberFormatException e) {
			
		}
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		List<Employee> completeList = edi.getEmployees();
		for(Employee emp : completeList) {
			//TODO : Check if email is taken
			if(emp.getEmail().equals(email.toUpperCase())) {
				warning = "That email is already being used for an account";
				return false;
			}
			if(emp.getId() == registrationNumber) {
				managerAvailable = true;
				break;
			}
		}
		if(!managerAvailable) {
			warning = "Invalid Registration Code";
			return false;
		}
		
		
		
		//TODO : if all passes, add user to db
		Employee newbie = new Employee(firstName.toUpperCase(), lastName.toUpperCase(), email.toUpperCase(), password, registrationNumber);
		edi.createEmployee(newbie);
		
		return true;	
	}
	
	public static boolean attemptUpdateInfo(Employee emp) {
		if(emp.getFirstName().equals("") || emp.getLastName().equals("") || emp.getEmail().equals("")) {
			warning = "No field can be left blank";
			return false;
		}
		if(!isValidEmail(emp.getEmail())) {
			warning = "Invalid email address";
			return false;
		}
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.updateEmployeeInfo(emp);
		warning = "Update success";
		return true;
		
	}
	
	public static boolean attemptPasswordChange(int id, String oldPassword, String newPassword, String confirmPassword) {
		if(oldPassword.equals("") || newPassword.equals("") || confirmPassword.equals("")) {
			warning = "All fields must be completed";
			return false;
		}
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee emp = edi.getEmployeeById(id);
		if(!emp.getPassword().equals(oldPassword)) {
			warning = "Current password incorrectly entered";
			return false;
		}
		
		if(!newPassword.equals(confirmPassword)) {
			warning = "New password and confirmation didn't match";
			return false;
		}
		
		edi.updateEmployeePassword(id, newPassword);
		warning = "Successful password change";
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
