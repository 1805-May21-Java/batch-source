package com.revature.htulipan.Project1.servlets;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.htulipan.Project1.daos.EmployeeDaoImpl;
import com.revature.htulipan.Project1.daos.RequestDaoImpl;
import com.revature.htulipan.Project1.pojos.Employee;

public class RequestApprovalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = 0;
		try {
			HttpSession session = req.getSession(false);
			if (session == null || session.getAttribute("employeeId") == null) {
				throw new NullPointerException();
			}

			id = (Integer) session.getAttribute("employeeId");
		} catch (NullPointerException npe) {
			res.sendRedirect("logout");
			return;
		}
		
		PrintWriter pw = res.getWriter();
		ClassLoader cl = getClass().getClassLoader();
		File html = new File(cl.getResource("templates/RequestApproval.html").getFile());
		Employee emp = new EmployeeDaoImpl().getEmployeeById(id);
		if (!emp.isManager()) {
			res.sendRedirect("home");
			return;
		} 
		writeHtml(pw, html, id);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = 0;
		try {
			HttpSession session = req.getSession(false);
			if (session == null || session.getAttribute("employeeId") == null) {
				throw new NullPointerException();
			}

			id = (Integer) session.getAttribute("employeeId");
		} catch (NullPointerException npe) {
			res.sendRedirect("logout");
			return;
		}
		
		Employee emp = new EmployeeDaoImpl().getEmployeeById(id);
		if (!emp.isManager()) {
			res.sendRedirect("home");
			return;
		}
		
		RequestDaoImpl rdi = new RequestDaoImpl();
		int rid = 0;
		String result = "";
		try {
			Enumeration<String> paramNames = req.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String name = paramNames.nextElement();
				String value = req.getParameter(name);
				if (value.equals(""))
					continue;
				switch (name) {
				case "rid":
					rid = Integer.parseInt(value);
					break;
				case "approve":
					result = value;
					break;
				case "deny":
					result = value;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("requestapproval");
			return;
		}
		if (rid != 0 && !result.equals("")) {
			rdi.updateRequest(rid, id, result.equals("Approve")?1:-1);
		}
		
		res.sendRedirect("requestapproval");
	}
	
	private void writeHtml(PrintWriter pw, File html, int id) throws IOException {
		
		FileReader fr = new FileReader(html);
		
		int cint = fr.read();
		while (cint >= 0) {
			if (Character.valueOf((char)cint) == '%') {
				pw.write(String.valueOf(id));
			} else {
				pw.write(cint);
			}
			cint = fr.read();
		}
	}
	
}
	
	