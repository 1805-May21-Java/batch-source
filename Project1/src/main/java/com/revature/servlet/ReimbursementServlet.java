package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ERSDaoImpl;
import com.revature.pojo.Employee;
import com.revature.pojo.Reimbursement;

/*
 * Reimbursement Servlet
 * 
 * Persists the Reimbursement data from the Employee in the session with 2 JSON arrays
 * 
 * The first one represents the requests submitting by the Employee, while the second
 * one represents the requests submitted by the Employees they manage
 */
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ERSDaoImpl dao = new ERSDaoImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter pw = res.getWriter();
		res.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper om = new ObjectMapper();
		res.setContentType("application/json");
		
		@SuppressWarnings("unchecked")
		LinkedList<Reimbursement>[] reimbursements = new LinkedList[2];
		reimbursements[0] = dao.getReimbursementsByEmplID(SessionServlet.empl.getID());
		reimbursements[1] = dao.getReimbursementsByManagerID(SessionServlet.empl.getID());
		
		if(session != null)
			om.writeValue(pw, reimbursements);
		else
			om.writeValue(pw, new LinkedList[2]);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
