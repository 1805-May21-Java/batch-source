package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.RequestDaoImpl;
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
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		ObjectMapper om = new ObjectMapper();
		String requestString;

		
		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id"); // current user id
		
		if(employeeDaoImpl.isEmployeeManager(employeeDaoImpl.getEmployeeById(id))) {
			List<Request> allRequests = requestDaoImpl.getRequests(); // get requests from all users
			requestString = om.writeValueAsString(allRequests);
			requestString = "{\"requests\":"+requestString+"}";
		} else {
			if (idString != null) {
				System.out.println("what is idString?");
				//int id = Integer.valueOf(idString);
				List<Request> reqs = requestDaoImpl.getRequestsById(id);
				requestString = om.writeValueAsString(reqs);
			} else {
				List<Request> myRequests = requestDaoImpl.getRequestsById(id);
				requestString = om.writeValueAsString(myRequests);
				requestString = "{\"requests\":"+requestString+"}";
			}
		}
		PrintWriter pWriter = response.getWriter();
		pWriter.print(requestString);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDaoImpl requestDaoImpl = new RequestDaoImpl();
		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id"); // current user id
		
		
		System.out.println(request.getParameterMap().keySet());
		
		if (request.getParameter("title") != null) {
			// create and insert new request
			String title = request.getParameter("title");
			double amount = Double.parseDouble(request.getParameter("amount"));
			String comments = request.getParameter("comments");
			
			// insert into Request database
			if((title != null) && (amount > 0.00)) {
				requestDaoImpl.createRequest(id, title, amount, comments);			
			}
			
			if (session.getAttribute("managerDash").toString().equals("inManager")) {
				response.sendRedirect("manager");
			} else {
				response.sendRedirect("dashboard");
			}
			
		} else if (request.getParameter("postAction") != null) {
			// approve or deny request
			int reqId = Integer.parseInt(request.getParameter("postValue"));
			Request currentRequest = requestDaoImpl.getRequestById(reqId);
			if (request.getParameter("postAction").equals("approve")) {
				// approved!
				Date currDate = Date.valueOf(LocalDate.now());
				String managerName = session.getAttribute("firstname") + " " + session.getAttribute("lastname");
				currentRequest.setDateApproved(currDate);
				currentRequest.setManagerId(id);
				currentRequest.setManagerName(managerName); 
				requestDaoImpl.updateRequest(reqId, id, currDate, managerName);
			} else {
				// denied! which here just means delete
				requestDaoImpl.deleteRequestById(reqId);
			}
			response.sendRedirect("manager");
		}

	}

}
