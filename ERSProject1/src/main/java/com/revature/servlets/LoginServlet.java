package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Login.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// go to registration page
		// TODO: outdated code?
		if (request.getParameter("register-button") != null) { 
			response.sendRedirect("register");
		} else {
			// check user input credentials
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			
			HttpSession session = request.getSession();
			
			// check that an employee already exists
			EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
			Employee employee = employeeDaoImpl.getEmployeeByUsername(user);
			
			if(employee != null && pass.equals(employee.getPassword())) {
				session.setAttribute("username", user);
				session.setAttribute("firstname", employee.getFirstname());
				session.setAttribute("lastname", employee.getLastname());
				session.setAttribute("id", employee.getId());
				session.setAttribute("manager", employee.getReportsto());
				session.setAttribute("email", employee.getEmail());
				session.setAttribute("password", pass);
				if (employeeDaoImpl.isEmployeeManager(employee)) {
					session.setAttribute("managerDash", "inManager");
					response.sendRedirect("manager");
				} else {
					session.setAttribute("managerDash", "notManager");
					response.sendRedirect("dashboard");
				}
				
			} else {
				response.sendRedirect("login");
			}
		}
	}
	
	//TODO: delete?
//	// check that username and password are valid
//	protected boolean validation(String user, String pass, HttpSession session) {
//		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
//		List<Employee> allEmployees = employeeDaoImpl.getEmployees(); // get all employees
//		// iterate thru employees
//		for (Employee employee : allEmployees) {
//			if (employee.getUsername().equals(user) && employee.getPassword().equals(pass)) {
//				session.setAttribute("id", employee.getId());
//				return true;
//			}
//		}
//		return false;
//		
//	}


}
