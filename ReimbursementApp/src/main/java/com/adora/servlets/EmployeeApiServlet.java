package com.adora.servlets;

import static org.hamcrest.CoreMatchers.not;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class EmployeeApiServlet
 */
public class EmployeeApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			employeeStr = "{\"employee\":" + employeeStr + "}";
		}
		
		response.getWriter().write(employeeStr);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
