package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		ObjectMapper om = new ObjectMapper();
		String requestString;
		
		if (idString != null) {
			int id = Integer.valueOf(idString);
			Request req = requestDaoImpl.getRequestById(id);
			requestString = om.writeValueAsString(req);
		} else {
			List<Request> allRequests = requestDaoImpl.getRequests();
			requestString = om.writeValueAsString(allRequests);
			requestString = "{\"requests\":"+requestString+"}";
		}
		
		PrintWriter pWriter = response.getWriter();
		pWriter.print(requestString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
