package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");

		pw.write("{\"username\":\""+session.getAttribute("userName")+"\", \"userid\":\""+session.getAttribute("userId")+"\", \"fullname\":\""+session.getAttribute("userFullname") +"\", \"birthdate\":\""+session.getAttribute("userBirthdate")+"\", \"userurl\":\""+session.getAttribute("userUrl")+"\"}");

		pw.close();
	}

}
