package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get list of managers
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		ObjectMapper om = new ObjectMapper();
		String managerString;

		List<Employee> managers = new ArrayList<Employee>();
		List<Employee> allEmployees = employeeDaoImpl.getEmployees();
		for (Employee e : allEmployees) {
			if (employeeDaoImpl.isEmployeeManager(e)) {
				managers.add(e);
			}
		}
		managerString = om.writeValueAsString(managers);
		managerString = "{\"managers\":"+managerString+"}";
		
		PrintWriter pWriter = response.getWriter();
		pWriter.print(managerString);
		
		//request.getRequestDispatcher("Login.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get new user info
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String user = request.getParameter("reg-username");
		String pass = request.getParameter("password1");
		String confirmPass = request.getParameter("password2");
		int managerId = Integer.parseInt(request.getParameter("manager"));
		
		HttpSession session = request.getSession();
		
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		
		
		// check that passwords match
		if(pass.equals(confirmPass)) {
			employeeDaoImpl.createEmployee(firstname, lastname, managerId, email, user, pass);
			Employee employee = employeeDaoImpl.getEmployeeByUsername(user);
			session.setAttribute("username", user);
			session.setAttribute("fullname", employee.getFirstname() + " " + employee.getLastname());
			session.setAttribute("id", employee.getId());
			session.setAttribute("manager", employee.getReportsto());
			response.sendRedirect("dashboard");
			
		} else {
			//System.out.println("login was not successful");
			response.sendRedirect("login");
		}
	}


}
