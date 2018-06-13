package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet{
	private static final long serialVerisonUID =1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		String answer = (String) request.getAttribute("answer");
		pw.write("<p> The answer is: "+answer+"</p>");
		pw.write("<p><a href=\"calculator.html\">here</a></p>");
	}

}
