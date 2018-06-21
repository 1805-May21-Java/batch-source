package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;


public class EmployeeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmployeeServlet() {
		super();
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		ObjectMapper om = new ObjectMapper();
		String employeeString;
		
		if (idString != null) {
			int id = Integer.valueOf(idString);
			Employee employee = employeeDaoImpl.getEmployeeById(id);
			employeeString = om.writeValueAsString(employee);
		} else {
			List<Employee> allEmployees = employeeDaoImpl.getEmployees();
			employeeString = om.writeValueAsString(allEmployees);
			employeeString = "{\"employees\":"+employeeString+"}";
		}
		
		PrintWriter pWriter = response.getWriter();
		pWriter.print(employeeString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// update user info
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		
		String newFirstname = request.getParameter("new-firstname");
		String newLastname = request.getParameter("new-lastname");
		String newEmail = request.getParameter("new-email");
		String newUsername = request.getParameter("new-username");
		String newPassword = request.getParameter("new-password");
		
		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id");
		
		// make sure that unfilled fields don't change during update
		if(newFirstname == "" && newLastname == "" && newEmail == "" && newUsername == "" && newPassword == "") {
			if (session.getAttribute("managerDash").equals("inManager")) {
				response.sendRedirect("manager");
			} else {
				response.sendRedirect("dashboard");
			}
		} else {
			if (newFirstname != "") {
				session.setAttribute("firstname", newFirstname);
			}
			if (newLastname != "") {
				session.setAttribute("lastname", newLastname);
			}
			if (newEmail != "") {
				session.setAttribute("email", newEmail);
			}
			if (newUsername != "") {
				session.setAttribute("username", newUsername);
			}
			if (newPassword != "") {
				session.setAttribute("password", newPassword);
			}
			employeeDaoImpl.updateEmployee(id, session.getAttribute("firstname").toString(), session.getAttribute("lastname").toString(), 
					session.getAttribute("email").toString(), session.getAttribute("username").toString(), session.getAttribute("password").toString());
			if (session.getAttribute("managerDash").toString().equals("inManager")) {
				response.sendRedirect("manager");
			} else {
				response.sendRedirect("dashboard");
			}
			
			
		}
	
	}
}
