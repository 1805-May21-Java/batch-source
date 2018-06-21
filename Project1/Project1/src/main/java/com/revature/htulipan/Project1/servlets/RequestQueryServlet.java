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
import com.revature.htulipan.Project1.daos.RequestDaoImpl;
import com.revature.htulipan.Project1.pojos.Request;

public class RequestQueryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String eidStr = req.getParameter("employeeId");
		String idStr = req.getParameter("id");
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		StringBuffer result = new StringBuffer();
		
		if (idStr == null) {
			if (eidStr == null) result = getAll();
			else {
				try {
					int eid = Integer.parseInt(eidStr);
					result = getByEmployee(eid);
				} catch (NumberFormatException nfe) {
					result.append("{\"requests\":[]}");
				}
			}
		} else {
			try {
				int id = Integer.parseInt(idStr);
				result = getOne(id);
			} catch (NumberFormatException nfe) {
				result.append("{\"requests\":[]}");
			}
		}
		
		pw.write(result.toString());
	}
	
	private StringBuffer getAll() {
		RequestDaoImpl rdi = new RequestDaoImpl();
		ObjectMapper om = new ObjectMapper();
		
		StringBuffer result = new StringBuffer();
		ArrayList<Request> list = rdi.getAllRequests();
		
		try {
			String objectString;
			if (list == null) objectString = "";
			else objectString = om.writeValueAsString(list);
			result.append("{\"requests\":" + objectString + "}");
		} catch (JsonProcessingException jpe) {
			System.out.println(jpe.getMessage());
			result.delete(0, result.length());
			result.append("{\"requests\": []");
		}
		
		return result;
	}
	
	private StringBuffer getOne(int id) {
		RequestDaoImpl rdi = new RequestDaoImpl();
		ObjectMapper om = new ObjectMapper();
		
		StringBuffer result = new StringBuffer();
		Request request = rdi.getRequestById(id);
		
		try {
			String objectString;
			if (request == null) objectString = "";
			else objectString = om.writeValueAsString(request);
			result.append("{\"requests\":[" + objectString + "]}");
		} catch (JsonProcessingException jpe) {
			System.out.println(jpe.getMessage());
			result.delete(0, result.length());
			result.append("{\"requests\": []");
		}
		
		return result;
	}

	private StringBuffer getByEmployee(int eid) {
		RequestDaoImpl rdi = new RequestDaoImpl();
		ObjectMapper om = new ObjectMapper();
		
		StringBuffer result = new StringBuffer();
		ArrayList<Request> list = rdi.getRequestsByEmployeeId(eid);
		
		try {
			String objectString;
			if (list == null) objectString = "";
			else objectString = om.writeValueAsString(list);
			result.append("{\"requests\":" + objectString + "}");
		} catch (JsonProcessingException jpe) {
			System.out.println(jpe.getMessage());
			result.delete(0, result.length());
			result.append("{\"requests\": []");
		}
		
		return result;
	}
}
