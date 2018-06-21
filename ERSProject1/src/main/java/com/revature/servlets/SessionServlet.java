package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pWriter = response.getWriter();
		response.setContentType("application/json");
		if (session != null) {
			pWriter.write("{\"username\":\"" + session.getAttribute("username") + "\", \"firstname\":\"" + 
						session.getAttribute("firstname") + "\", \"lastname\":\"" + session.getAttribute("lastname") + 
						"\", \"id\":\"" + session.getAttribute("id") + "\", \"email\":\"" + session.getAttribute("email") +
						"\", \"password\":\"" + session.getAttribute("password") + "\", \"manager\":\"" + session.getAttribute("manager") + "\"}");
		} else {
			pWriter.write("{\"user\": null, \"firstname\": null, \"lastname\": null, \"id\": null, \"email\": null, \"password\": null, \"manager\": null,}");
		}
	}

}
