package com.revature.htulipan.Project1.servlets;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("employeeId") == null ) {
			System.out.println("Redirecting to login.");
			res.sendRedirect("login");
		}
		
		int id = (Integer) session.getAttribute("employeeId");
		PrintWriter pw = res.getWriter();
		ClassLoader cl = getClass().getClassLoader();
		File html = new File(cl.getResource("templates/Home.html").getFile());
		writeHtml(pw, html, id);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
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
