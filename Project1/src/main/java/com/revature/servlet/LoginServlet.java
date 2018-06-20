package com.revature.servlet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ERSDaoImpl;
import com.revature.pojo.Employee;
import com.revature.servlet.SessionServlet.Info;
import com.revature.util.MailUtil;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 6435207802030991523L;
	ERSDaoImpl dao = new ERSDaoImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if(session != null && session.getAttribute("id") != null)
			res.sendRedirect("profile");
		else
			req.getRequestDispatcher("login.html").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		SessionServlet.clearMessagesAndErrors();
		
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		Employee empl = dao.getEmployeeByEmail(user);
		if(empl != null && pass.equals(empl.getPass())) {
			HttpSession session = req.getSession();
			SessionServlet.empl = empl;
			session.setAttribute("id", empl.getID());
			res.sendRedirect("profile");
		}
		else {
			SessionServlet.errors.add(new Info("Incorrect email and/or password", true));
			
			res.sendRedirect("login");
		}
	}
}
