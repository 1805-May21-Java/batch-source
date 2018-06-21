package com.revature.htulipan.Project1.servlets;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.htulipan.Project1.daos.EmployeeDaoImpl;
import com.revature.htulipan.Project1.daos.RequestDaoImpl;
import com.revature.htulipan.Project1.pojos.Employee;
import com.revature.htulipan.Project1.pojos.Request;

public class RequestServlet extends HttpServlet {

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
		}
		
		PrintWriter pw = res.getWriter();
		ClassLoader cl = getClass().getClassLoader();
		File html = new File(cl.getResource("templates/Requests.html").getFile());
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
		}
		
		RequestDaoImpl rdi = new RequestDaoImpl();
		float amount = 0.0f;
		String text = "";
		try {
			Enumeration<String> paramNames = req.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String name = paramNames.nextElement();
				String value = req.getParameter(name);
				if (value.equals(""))
					continue;
				switch (name) {
				case "amount":
					amount = Float.parseFloat(value);
					break;
				case "requesttext":
					text = value;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Redirecting to profile.");
			res.sendRedirect("requests");
			return;
		}

		rdi.createRequest(id, amount, text, 0);
		res.sendRedirect("requests");
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
