package com.adora.servlets.api;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.adora.managers.SessionManager;
import com.adora.services.api.RequestApiService;


public class RequestApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get parameters from request
		int employeeId = SessionManager.getEmployeeId(request);
		String status = request.getParameter("status");
		String requestId = request.getParameter("request_id");
		String role = SessionManager.isManager(request)? "manager" : "employee";
		String type = request.getParameter("type");
		
		//get the requested data
		String requestStr = RequestApiService.requestData(role, type, employeeId, status, requestId);
		requestStr = "{\"requests\":"  + requestStr + "}";
		response.getWriter().write(requestStr);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters from request
		String subject = request.getParameter("subject");
		String reqAmount = request.getParameter("amount");
		String action = request.getParameter("action");
		String appAmount = request.getParameter("approved_amount");
		String requestId = request.getParameter("request_id");
		
		int employeeId = SessionManager.getEmployeeId(request);
		int managerId = SessionManager.getManagerId(request);

		// attempt to serve request
		RequestApiService.validateRequestPostData(action, subject, appAmount, reqAmount, employeeId, managerId, requestId);
			
		//redirect to home when done
		response.sendRedirect("../home");
		
	}

}
