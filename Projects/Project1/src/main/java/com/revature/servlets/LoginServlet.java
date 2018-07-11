package com.revature.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;




public class LoginServlet extends HttpServlet
{

	private static final long serialVersionUID = -7183390963466595630L;
	EmployeeDao dao = new EmployeeDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			resp.sendRedirect("reimbursement");
		}
		else
			{
			req.getRequestDispatcher("Login.html").forward(req,  resp);
			}


	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		
		System.out.println(req.getParameter("username")+req.getParameter("password"));
		String usr = req.getParameter("username");
		String pwd = req.getParameter("password");
	

		if(dao.isAuthenticated(usr, pwd))
		{
			System.out.println("Is Authenticated!");
			HttpSession session = req.getSession();
			Employee employee = dao.getEmployeeByName(usr);
			session.setAttribute("userName", employee.getUserName());
			session.setAttribute("userId", employee.getEmpId());
			session.setAttribute("userPassword", pwd);
			session.setAttribute("userFullname", employee.getEmpName());
			session.setAttribute("userBirthdate", employee.getBirthDate());
			session.setAttribute("userUrl", employee.getUrl());
			session.setAttribute("managerId", employee.getReportTo());
			resp.sendRedirect("reimbursement");
		}
		else {
			resp.sendRedirect("login");
		}
	}

}
