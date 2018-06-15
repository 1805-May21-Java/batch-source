package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomepageServlet
 */
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomepageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Success, login works!
		//But make you pass the database table data to your session!
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("username") != null && 
				(Integer)session.getAttribute("isManager") == 0) {
			request.getRequestDispatcher("EmployeeHomepage.html").forward(request, response);
		}else if(session != null && session.getAttribute("username") != null &&
				(Integer)session.getAttribute("isManager") == 1){
			request.getRequestDispatcher("ManagerHomepage.html").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	/*
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	*/

}
