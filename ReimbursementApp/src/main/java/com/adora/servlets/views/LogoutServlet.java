package com.adora.servlets.views;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adora.managers.SessionManager;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionManager.isLoggedIn(request)) {
			response.sendRedirect("login");
			return;
		}
		
		SessionManager.logout(request);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.sendRedirect("login");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
