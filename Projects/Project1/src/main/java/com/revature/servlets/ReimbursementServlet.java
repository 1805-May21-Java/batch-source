package com.revature.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReimbursementServlet extends HttpServlet
{


	private static final long serialVersionUID = 2398309431164670330L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		
		if ( session!=null && session.getAttribute("userName") != null) {
		    System.out.println("THIS IS YOUR USERNAME: "+ session.getAttribute("userName").toString());
			req.getRequestDispatcher("Reimbursement.html").forward(req, resp); 
			
		} else {
			resp.sendRedirect("login");
		}	
	}

	
}
