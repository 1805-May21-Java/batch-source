package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EmployeeDaoImpl edi = new EmployeeDaoImpl();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");

		HttpSession session = request.getSession();
		Employee emp = edi.getEmployeeByUsername(user);
		if(emp == null) {
			//username does not exist
			response.sendRedirect("index.html");
		} else {
			if(pass.equals(emp.getPassword())) {
				session.setAttribute("curEmployee", emp);
				System.out.println(emp.isManager());
				if(emp.isManager()) {
					//send to manager home
					response.sendRedirect("managerHome.html");
				} else {
					//send to employee home
					response.sendRedirect("employeeHome.html");
				}
			} else {
				response.sendRedirect("index.html");
			}
		}
	}

}
