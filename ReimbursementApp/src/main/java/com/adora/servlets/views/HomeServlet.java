package com.adora.servlets.views;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adora.managers.SessionManager;


public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(SessionManager.isLoggedIn(request)) {
			if(SessionManager.isManager(request)) {
				//if a manager
				request.getRequestDispatcher("/view/manager/home.html").forward(request, response);
			} else {
				//if an employee
				request.getRequestDispatcher("/view/employee/home.html").forward(request, response);
			}
		} else {
			// go to login page
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
