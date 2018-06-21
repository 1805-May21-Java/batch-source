package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.html").forward(request, response);
//		System.out.println("Get called");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		HttpSession session = request.getSession();
		
		if(edi.getEmployeeByUsername(user)==null) {
			System.out.println("Login was not successful - please try again");
			doGet(request, response);
		}else if(pass.equals(edi.getEmployeeByUsername(user).getPassword())) {
			if(edi.getEmployeeByUsername(user).getManager()==0) {
				System.out.println("Login was successful - correct credentials");
				session.setAttribute("username", user);
				response.sendRedirect("EmpHome.html");
			}else {
				System.out.println("Login was successful - correct credentials");
				session.setAttribute("username", user);
				response.sendRedirect("MngHome.html");
			}
		}else {
			System.out.println("Login was not successful - please try again");
			doGet(request, response);
		}
	}

}
