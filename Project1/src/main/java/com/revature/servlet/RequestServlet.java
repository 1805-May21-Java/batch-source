package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RequestDaoImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Request;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RequestDaoImpl rdi = new RequestDaoImpl();

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
		Employee current = (Employee) request.getSession().getAttribute("curEmployee");
		List<Request> requests;
		if(Boolean.parseBoolean(request.getParameter("Approve"))) {
			requests = rdi.getAllRequestsByManager(current);
		} else {
			//get employee requests
			requests = rdi.getAllRequestsByEmployee(current);
		}
		ObjectMapper om = new ObjectMapper();
		String reqString = om.writeValueAsString(requests);
		reqString = "{\"requests\":"+reqString+"}";

		PrintWriter pw = response.getWriter();
		pw.write(reqString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		String requestBodyText = request.getReader().readLine();
		Employee curEmp = (Employee) request.getSession().getAttribute("curEmployee");
		System.out.println(requestBodyText);
		String[] strings = requestBodyText.split("&");
		if(requestBodyText.contains("amount")) {
			Request req = new Request();
			req.setAmount(Integer.parseInt(strings[0].substring(7)));
			req.setComments(strings[1].substring(9).replace('+', ' '));
			req.setEmployeeId(curEmp.getEmployeeId());
			req.setStatus(0);
			rdi.createRequest(req);
			if(curEmp.isManager()) {
				//send to manager home
				response.sendRedirect("managerHome.html");
			} else {
				//send to employee home
				response.sendRedirect("employeeHome.html");
			}
		} else {

			int reqId = Integer.parseInt(strings[0].substring(10));
			int status = Integer.parseInt(strings[1].substring(7));
			rdi.updateRequest(reqId,status);
		}
	}

}
