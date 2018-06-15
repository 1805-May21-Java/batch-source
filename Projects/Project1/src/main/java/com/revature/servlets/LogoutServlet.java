package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = -3331112539417027975L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession	session = req.getSession(false);
		if(session != null)
		{
			
			System.out.println(session.getAttribute("username"));
			System.out.println("invalidating..req...");
			session.invalidate();
			System.out.println("session just invalidated");
		}
		resp.sendRedirect("login");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doGet(req, resp);
	}
	
}
