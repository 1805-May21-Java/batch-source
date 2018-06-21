package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
			request.getRequestDispatcher("Views/Home Page.html").forward(request, response);
		}
		else
		{
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		ReimbursementDaoImpl redi = new ReimbursementDaoImpl();
		HttpSession session = request.getSession(false);
		ObjectMapper om = new ObjectMapper();
		String str =session.getAttribute("user").toString();
		str = str.substring(0,str.indexOf("}")+1);
		str = str.replace("[", "");
		UserInfo ui = om.readValue(str, UserInfo.class);
		
		if(request.getParameter("reason") != "" && request.getParameter("amount") != "")
		{
			String reason = request.getParameter("reason");
			Double amount = Double.parseDouble(request.getParameter("amount"));
			Reimbursement re = new Reimbursement(reason, amount, ui.getId());
			redi.createReimbursement(re);
			
			List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
			reimbList = redi.getReimbursementInfo();
			String temp = "";
			String userString = "[";

			temp = om.writeValueAsString(reimbList);
			temp = temp.replace("[", ",");
			userString += str+temp;
		
			
			session.setAttribute("user", userString);
			request.getRequestDispatcher("Views/RequestSubmitted.html").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("Views/InvalidInput.html").forward(request, response);
		}
		
	}

}
