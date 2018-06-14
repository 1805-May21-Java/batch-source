package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Register.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check user input credentials
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(user.equals("admin") && pass.equals("pass123")) {
			//System.out.println("Logingg was successful");
			session.setAttribute("username", "admin");
			response.sendRedirect("dashboard");
		} else {
			//System.out.println("login was not successful");
			response.sendRedirect("login");
		}
	}


}
