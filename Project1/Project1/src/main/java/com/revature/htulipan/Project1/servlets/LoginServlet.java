package com.revature.htulipan.Project1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.htulipan.Project1.daos.EmployeeDaoImpl;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("employeeId") != null) {
			Integer eid = (Integer) session.getAttribute("employeeId");
			res.sendRedirect("home");
		} else {
			req.getRequestDispatcher("templates/Login.html").forward(req, res);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Get post parameters, check credentials, create a session and redirect to home, or redirect to here if invalid.
		// What to do if a session already exists?
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("employeeId") != null) {
			session.invalidate(); // If attempting to login while already logged in, log out. Then attempt to login.
		}
		
		String un = req.getParameter("username");
		String pw = req.getParameter("password");

		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int id = edi.checkLoginCredentials(un, pw);

		if (id == 0) { // Failed login, redirect to login
			System.out.println("Redirecting to login.");
			res.sendRedirect("login");
		} else { // Successful login, set session data, redirect to home page
			session = req.getSession(true);
			session.setAttribute("employeeId", new Integer(id));
			System.out.println("Redirecting to home.");
			res.sendRedirect("home");
		}
	}

}
