package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.pojos.*;
import com.revature.dao.EmployeeDAOImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FindManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAOImpl employ = new EmployeeDAOImpl();
		ObjectMapper om = new ObjectMapper();
		String managers;
		//Get list of managers
		List<employee> management = new ArrayList<employee>();
		//Get list of all employees using the 
		List<employee> employeelisting = employ.getEmployees();
		//Iterate through array checking for managers and add to manager list
		for(employee w: employeelisting) {
			if(employ.etypeCheck(w)) {
				management.add(w);
			}
		}
		//Puts the management as a string in the string from earlier
		managers = om.writeValueAsString(management);
		managers = "{\"managers\":"+managers+"}";
		PrintWriter pWriter = response.getWriter();
		pWriter.print(managers);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
