package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.UserInfo;


public class HomeServlet extends HttpServlet 
{
	private ReimbursementDaoImpl redi = new ReimbursementDaoImpl();
	private static final long serialVersionUID = 1L;
       

    public HomeServlet() 
    {
        super();

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("user") != null)
		{
			request.getRequestDispatcher("Home Page.html").forward(request, response);
		}
		else
		{
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		ObjectMapper om = new ObjectMapper();
		UserInfo ui = om.readValue(session.getAttribute("user").toString(), UserInfo.class);
		if(request.getParameter("reason") != "" && request.getParameter("amount") != "")
		{
			String reason = request.getParameter("reason");
			Double amount = Double.parseDouble(request.getParameter("amount"));
			Reimbursement re = new Reimbursement(reason, amount, ui.getId());
			redi.createReimbursement(re);
		}
		
		request.getRequestDispatcher("Home Page.html").forward(request, response);
	}

}
