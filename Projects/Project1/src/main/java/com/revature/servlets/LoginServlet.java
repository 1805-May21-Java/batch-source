package com.revature.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;



public class LoginServlet extends HttpServlet
{

	private static final long serialVersionUID = -7183390963466595630L;
	EmployeeDao dao = new EmployeeDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{

		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		HttpSession session = req.getSession();
		System.out.println(req.getParameter("username")+req.getParameter("password"));
		String usr = req.getParameter("username");
		String pwd = req.getParameter("password");
		
		if(dao.isAuthenticated(usr, pwd))
		{
			
			session.setAttribute("userName", usr);
			resp.sendRedirect("Reimbursement");
		}
		else {
			resp.sendRedirect("login");
		}
	}

}
