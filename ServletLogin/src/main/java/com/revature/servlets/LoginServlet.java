package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("Login.html").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Check user input credentials
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(user.equals("admin")&& pass.equals("pass123")) {
//			System.out.println("login was successful - correct credentials");
			session.setAttribute("username", "admin");
			response.sendRedirect("profile");
		}else {
//			System.out.println("WRONG");
			response.sendRedirect("login");
		}
	}
}
