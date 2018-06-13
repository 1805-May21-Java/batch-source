package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet{
	private static final long serialVersionUID = -6426094775000334662L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		if(session != null)
			pw.write("{\"username\":\"" + session.getAttribute("username") + "\"}");
		else
			pw.write("{\"username\": null}");
		pw.close();
	}
}
