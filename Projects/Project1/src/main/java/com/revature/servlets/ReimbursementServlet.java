package com.revature.servlets;


import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Reimbursement;

public class ReimbursementServlet extends HttpServlet
{


	private static final long serialVersionUID = 2398309431164670330L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		
		if ( session!=null) {
			req.getRequestDispatcher("Reimbursement.html").forward(req, resp); 
			
		} else {
			resp.sendRedirect("login");
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		
		int requestBy = Integer.parseInt(req.getParameter("request_by"));
		int approveBy = Integer.parseInt(req.getParameter("approve_by")); 
		double amount = Double.parseDouble(req.getParameter("amount")); 
		Date dateRequest = new Date(System.currentTimeMillis());
		Date dateApprove=null;
		String status="Pending";
		String description = req.getParameter("description");
		String url = req.getParameter("url");
		ReimbursementDao rdi = new ReimbursementDaoImpl();
		rdi.createReimbursement(new Reimbursement(requestBy, amount, approveBy, dateRequest, dateApprove, status, description, url));

		
		resp.sendRedirect("reimbursement");
	}
}
