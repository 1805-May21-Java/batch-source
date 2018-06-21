package com.adora.servlets.views;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adora.managers.SessionManager;



public class NewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionManager.isLoggedIn(request)) {
			response.sendRedirect("../login");
			return;
		}
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(SessionManager.isManager(request)) {
			request.getRequestDispatcher("/view/manager/newrequests.html").forward(request, response);
		} else {
			request.getRequestDispatcher("/view/employee/newrequests.html").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
