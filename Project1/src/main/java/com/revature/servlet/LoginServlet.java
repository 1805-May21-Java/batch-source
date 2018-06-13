package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 6435207802030991523L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		// dummy cred check
		if(user.equals("admin") && pass.equals("passw0rd")) {
//			System.out.println("success");
			session.setAttribute("username", "admin");
			res.sendRedirect("profile"); // profile when the servlet is made
		} else {
			System.out.println("fail");
			
			res.sendRedirect("login");
		}
	}
}
