package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = -5095172352805670544L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		if(session != null) {
			pw.write("{\"email\": \"" + session.getAttribute("email") + "\",\"type\": \"" + session.getAttribute("type") +"\"}");
		} else {
			pw.write("{\"email\": null}");
		}
	}
}

