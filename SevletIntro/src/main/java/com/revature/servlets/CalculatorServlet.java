package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CalculatorServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get Handle activated successfully");
//		PrintWriter ow = response.getWriter();
//		ow.write("<p>Calculator Page</p><br><a href=\"calculator.html\">here</a>");
		RequestDispatcher rd = request.getRequestDispatcher("calculator.html");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		String op = request.getParameter("operation");
		System.out.println(n1+ " "+op+" "+n2);
		
		String result = "";
		Double first = Double.parseDouble(n1);
		Double second = Double.parseDouble(n2);
		switch(op){
		case "add":
			result = ""+ (first + second);
			break;
		case "multiply":
			result = ""+ (first*second);
			break;
		case "subtract":
			result = ""+ (first-second);
			break;
		case "divide":
			result = ""+ (first/second);
			break;
		default:
			result = "invalid operation";
		}
//		PrintWriter pw = response.getWriter();
//		pw.write("<p> The answer is: "+result+"</p>");
//		pw.write("<p><a href=\"calculator.html\">here</a></p>");
		
		request.setAttribute("answer", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/answer");
		rd.forward(request, response);
	}
}
