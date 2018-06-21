package com.revature.htulipan.Project1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.htulipan.Project1.daos.EmployeeDaoImpl;
import com.revature.htulipan.Project1.pojos.Employee;

public class EmployeeQueryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String idStr = req.getParameter("id");
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		StringBuffer result = new StringBuffer();
		
		if (idStr == null) {
			result = getAll();
		} else {
			try {
				int id = Integer.parseInt(idStr);
				result = getOne(id);
			} catch (NumberFormatException nfe) {
				result.append("{\"employees\":[]}");
			}
		}
		
		pw.write(result.toString());
	}
	
	private StringBuffer getAll() {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		ObjectMapper om = new ObjectMapper();
		
		StringBuffer result = new StringBuffer();
		ArrayList<Employee> list = edi.getAllEmployees();
		
		try {
			String objectString;
			if (list == null) objectString = "";
			else objectString = om.writeValueAsString(list);
			result.append("{\"employees\":" + objectString + "}");
		} catch (JsonProcessingException jpe) {
			System.out.println(jpe.getMessage());
			result.delete(0, result.length());
			result.append("{\"employees\": []");
		}
		
		return result;
	}
	
	private StringBuffer getOne(int id) {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		ObjectMapper om = new ObjectMapper();
		
		StringBuffer result = new StringBuffer();
		Employee employee = edi.getEmployeeById(id);
		
		try {
			String objectString;
			if (employee == null) objectString = "";
			else objectString = om.writeValueAsString(employee);
			result.append("{\"employees\":[" + objectString + "]}");
		} catch (JsonProcessingException jpe) {
			System.out.println(jpe.getMessage());
			result.delete(0, result.length());
			result.append("{\"employees\": []");
		}
		
		return result;
	}

}
