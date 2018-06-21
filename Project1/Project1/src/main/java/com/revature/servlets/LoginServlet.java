package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDaoImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Manager;
import com.revature.util.BCrypt;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -8792255599105839358L;
	
	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	ManagerDaoImpl mdi = new ManagerDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		password = BCrypt.hashpw(password, "$2a$10$UoN1BeeYXiuBPKtefJ8Qx.");
		HttpSession session = request.getSession();

		Employee employee = edi.getEmployee(email, password);
		if(employee != null) {
			session.setAttribute("email", email);
			session.setAttribute("type", "employee");
			response.sendRedirect("employee.html");
			return;
		}

		Manager	manager = mdi.getManager(email, password);
		if(manager != null) {
			session.setAttribute("email", email);
			session.setAttribute("type", "manager");
			response.sendRedirect("manager.html");
			return;
		}
		
		response.sendRedirect("login");
	}
}
