package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;


public class EmployeeApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		ObjectMapper om = new ObjectMapper();
		String employeeString;
		
		if (idStr != null) {
			
			int id = Integer.valueOf(idStr);
			Employee e = edi.getEmployeeById(id);
			employeeString = om.writeValueAsString(e);
			
		} else {
			List<Employee> allEmployees = edi.getEmployees();
			employeeString = om.writeValueAsString(allEmployees);
			employeeString = "{\"employees\":"+employeeString+"}";
		}
		
		PrintWriter pw = response.getWriter();
		pw.print(employeeString);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
