package com.revature.servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.*;

public class LoginServlet extends HttpServlet {
	UserDaoImpl udi = new UserDaoImpl();
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		//session.invalidate();
		request.getRequestDispatcher("Login.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(udi.logIn(user, pass) != null) {
			session.setAttribute("username", "admin");
			response.sendRedirect("profile");
		} else {
			//System.out.println("login was not successful - please try again");
			response.sendRedirect("login");
		}
	}

}