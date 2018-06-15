package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransactionServlet extends HttpServlet
{


	private static final long serialVersionUID = 2398309431164670330L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		System.out.println(session);
		if(session == null) System.out.println("session is null");
		else System.out.println("session is not null");
		if ( session!=null && session.getAttribute("username") != null) {
			System.out.println(session.getAttribute("username"));
			System.out.println("transaction running..");
			req.getRequestDispatcher("Transaction.html").forward(req, resp); 
			
		} else {
			resp.sendRedirect("login");
		}	
	}

	
}
