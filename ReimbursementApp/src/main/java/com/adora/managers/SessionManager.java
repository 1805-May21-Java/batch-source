package com.adora.managers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.adora.access.EmployeeDaoImpl;
import com.adora.pojos.Credential;
import com.adora.pojos.Employee;
import com.adora.pojos.Request;

public class SessionManager {

	private static SessionManager session;
	

	
	private SessionManager() {
		super();
	}
	
	public static SessionManager getInstance() {
		if(session == null) {
			session = new SessionManager();
		}
		return session;
	}
	
	public static boolean isLoggedIn(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("employee_id") != null) {
			return true;
		}
		return false;
	}
	
	public static void logIn(HttpServletRequest request, Credential credential) {
		HttpSession session = request.getSession();
		
		//get employee info
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee employee = edi.getEmployeeById(credential.getEmployee_id());
		
		session.setAttribute("employee_id", employee.getEmployeeId());
		session.setAttribute("role", employee.getRoleId());
		session.setAttribute("manager_id", employee.getManagerId());
	}
	
	public static void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
	}
	
	public static boolean isManager(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if((Integer) session.getAttribute("role") > 1) {
			return true;
		}
		return false;
	}
	
	public static int getEmployeeId( HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return (Integer) session.getAttribute("employee_id");	
	}
	
	public static int getManagerId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return (Integer) session.getAttribute("manager_id");
	}
	
	public static void setRequestId(HttpServletRequest request, int requestId) {
		HttpSession session = request.getSession(false);
		session.setAttribute("request_id", requestId);
	}
	
	public static void getRequestId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.getAttribute("request_id");
	}
	
	

}
