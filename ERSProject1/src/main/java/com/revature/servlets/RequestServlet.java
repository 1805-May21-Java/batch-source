package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDaoImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Request;

public class RequestServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RequestServlet() {
		super();
	}
	
	// WARNING: there are two different "request" variables!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		RequestDaoImpl requestDaoImpl = new RequestDaoImpl();
		ObjectMapper om = new ObjectMapper();
		String requestString;
		
		if (request.getParameter("pending-tab") != null) {
			System.out.println("in the pending tab");
		}
		
		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id"); // current user id
		
		
		if (idString != null) {
			System.out.println("what is idString?");
			//int id = Integer.valueOf(idString);
			List<Request> reqs = requestDaoImpl.getRequestsById(id);
			requestString = om.writeValueAsString(reqs);
		} else {
			System.out.println("No idString. Pulls all requests.");
			List<Request> myRequests = requestDaoImpl.getRequestsById(id);
			requestString = om.writeValueAsString(myRequests);
			requestString = "{\"requests\":"+requestString+"}";
		}
		
		PrintWriter pWriter = response.getWriter();
		pWriter.print(requestString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		// get new reimbursement data
		System.out.println("submitting request");
		String title = request.getParameter("title");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String comments = request.getParameter("comments");
		
		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id"); // current user id
		
		RequestDaoImpl requestDaoImpl = new RequestDaoImpl();
		
		
		// insert into Request database
		if((title != null) && (amount > 0.00)) {
			requestDaoImpl.createRequest(id, title, amount, comments);			
		}
		
		response.sendRedirect("dashboard");
	}

}
