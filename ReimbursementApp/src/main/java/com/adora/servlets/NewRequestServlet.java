package com.adora.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adora.access.RequestDaoImpl;
import com.adora.managers.SessionManager;
import com.adora.pojos.Request;

/**
 * Servlet implementation class NewRequest
 */
public class NewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/view/newrequest.html").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String amount = request.getParameter("amount");
		String action = request.getParameter("action");
		
		System.out.println(action);
		
		
		// save new request to database
		Request newRequest = new Request();
		newRequest.setSubject(subject);
		newRequest.setRequestedAmount(Double.parseDouble(amount));
		newRequest.setDateSubmitted(new Date(Calendar.getInstance().getTimeInMillis()));
		newRequest.setEmployeeId(SessionManager.getEmployeeId(request));
		newRequest.setManagerId(SessionManager.getManagerId(request));
		
		if(action == "save") {
			newRequest.setStatus(0);
		} else {
			newRequest.setStatus(1);
		}
		
		System.out.println(newRequest.toString());
		
		RequestDaoImpl rdi = new RequestDaoImpl();
		int status = rdi.createRequest(newRequest);
		// TODO check status
		
		
		response.sendRedirect("../home");
	}

}
