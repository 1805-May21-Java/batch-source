package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;


public class EmployeeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmployeeServlet() {
		super();
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		ObjectMapper om = new ObjectMapper();
		String employeeString;
		
		if (idString != null) {
			int id = Integer.valueOf(idString);
			Employee employee = employeeDaoImpl.getEmployeeById(id);
			employeeString = om.writeValueAsString(employee);
		} else {
			List<Employee> allEmployees = employeeDaoImpl.getEmployees();
			employeeString = om.writeValueAsString(allEmployees);
			employeeString = "{\"employees\":"+employeeString+"}";
		}
		
		PrintWriter pWriter = response.getWriter();
		pWriter.print(employeeString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
