package com.adora.servlets.api;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adora.access.EmployeeDao;
import com.adora.access.EmployeeDaoImpl;
import com.adora.managers.SessionManager;
import com.adora.pojos.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;


public class EmployeeApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao edi = new EmployeeDaoImpl();
		Boolean profile = false;
		int employeeId = 0;
		
		try {
			profile = Boolean.parseBoolean(request.getParameter("profile"));
		} catch (Exception e) {}
		try {
			employeeId = Integer.parseInt(request.getParameter("employee_id"));
		} catch (Exception e) {}
		
		String employeeStr = "";
		ObjectMapper om = new ObjectMapper(); 
		
		//get employee id
		
		if(profile) {
			Employee employee = edi.getEmployeeById(SessionManager.getEmployeeId(request));
			employeeStr = om.writeValueAsString(employee);
			employeeStr = "{\"employee\":" + employeeStr + "}";
		} else if(employeeId > 0){
			Employee employee = edi.getEmployeeById(employeeId);
			employeeStr = om.writeValueAsString(employee);
			employeeStr = "{\"employee\":" + employeeStr + "}";
			
		} else {
			// if not employee id	
			List<Employee> employeeList = edi.getEmployees();
			employeeStr = om.writeValueAsString(employeeList);
			employeeStr = "{\"employees\":" + employeeStr + "}";
		}
		
		response.getWriter().write(employeeStr);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("update")) {
			String employeeId = request.getParameter("employee_id");
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			
			System.out.println(employeeId + " " + firstName + lastName + " " + email);
			
		}
	}

}
