package com.adora.servlets;


import java.io.IOException;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adora.access.RequestDaoImpl;
import com.adora.managers.SessionManager;
import com.adora.pojos.Request;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class RequestApiServlet
 */
public class RequestApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		String requestStr = "";
		ObjectMapper om = new ObjectMapper(); 
		RequestDaoImpl rdi = new RequestDaoImpl();
		
		int employeeId = SessionManager.getEmployeeId(request);
		int status = 0;
		int requestId = 0;
		
		
		try {
			status = Integer.parseInt(request.getParameter("status"));
		} catch(NumberFormatException e) {
			//keep it moving
		} try {
			requestId = Integer.parseInt(request.getParameter("request_id"));
		} catch (NumberFormatException e) {
			//moving along
		}
		
		if(SessionManager.isManager(request)) {		
			
			if(status == 1) {
				
				List<Request> requestList = rdi.getAllPendingRequestsByManager(SessionManager.getEmployeeId(request));
				requestStr = om.writeValueAsString(requestList);
				requestStr = "{\"requests\":" + requestStr + "}";
			} else if(requestId > 0) {
				Request currentRequest = rdi.getRequestById(requestId);
				requestStr = om.writeValueAsString(currentRequest);
				requestStr = "{\"requests\":" + requestStr + "}";
				
			} else {
				
				List<Request> requestList = rdi.getAllRequests(SessionManager.getEmployeeId(request));
				requestStr = om.writeValueAsString(requestList);
				requestStr = "{\"requests\":" + requestStr + "}";
			}
			
		} else {
			System.out.println(status);
			if(status == 1) {
				
				//get all the pending requests
				List<Request> requestList = rdi.getAllPendingRequestsByEmployee(employeeId);
				requestStr = om.writeValueAsString(requestList);
				requestStr = "{\"requests\":"  + requestStr + "}";
			
			} else {
				//get the all requests for that employee only
				List<Request> requestList = rdi.getAllRequestsByEmployee(employeeId);
				
				requestStr = om.writeValueAsString(requestList);
				requestStr = "{\"requests\":" + requestStr + "}";
			}
					
		}
		response.getWriter().write(requestStr);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
