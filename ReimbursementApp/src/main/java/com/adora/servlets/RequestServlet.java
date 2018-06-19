package com.adora.servlets;


import java.io.Console;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adora.access.RequestDaoImpl;
import com.adora.managers.SessionManager;
import com.adora.pojos.Request;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("is a manager " + SessionManager.isManager(request));
		// employee requests
		if(SessionManager.isManager(request)) {
			request.getRequestDispatcher("/view/managerrequests.html").forward(request, response);
		} else {
			request.getRequestDispatcher("/view/employeerequests.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(SessionManager.isManager(request)) {
			
			RequestDaoImpl rdi = new RequestDaoImpl();
			String action = request.getParameter("action");
			int approvedAmount = 0;
			int managerId = SessionManager.getEmployeeId(request);
			int requestId = 0;
			
			try {
				approvedAmount = Integer.parseInt(request.getParameter("approved_amount"));
			} catch(NumberFormatException e) {}
			try {
				requestId = Integer.parseInt(request.getParameter("request_id"));
			} catch(NumberFormatException e) {}
			
			System.out.println(requestId);
			
			if(action.equals("approve")) {
				System.out.println("approving");
				rdi.approveRequest(requestId, managerId, approvedAmount);
				
			} else if(action.equals("deny")) {
				System.out.println("denying");
				rdi.denyRequest(requestId, managerId);
			}
		}
	}

}
