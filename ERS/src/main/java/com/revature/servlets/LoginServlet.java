package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ERSDaoImpl;
import com.revature.pojos.EmployeeInfo;
import com.revature.pojos.ManagerInfo;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forward to the login.html
		HttpSession session = request.getSession();
		request.getRequestDispatcher("Login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//after clicking login buttoon, check if the input matches the database for employee and manager, employee first
		String user = request.getParameter("username");
		String pass = request.getParameter("pwd");
		response.setContentType("application/json");
		ERSDaoImpl edi = new ERSDaoImpl();
		EmployeeInfo ei = edi.findEmpByUP(user, pass);
		ManagerInfo mi = edi.findManByUP(user, pass);
		HttpSession session = request.getSession();
		//if it matches either employee or manager, set down the attributes of the user information into the session, and redirect to
		//the employee or manager website
		if(ei != null && user.equals(ei.getUsername()) && pass.equals(ei.getPassword())) {
			//System.out.println("login was successful - correct credentials");
			session.setAttribute("username", ei.getUsername());
			session.setAttribute("userid", ei.getUserid());
			session.setAttribute("pass", ei.getPassword());
			session.setAttribute("name", ei.getName());
			session.setAttribute("birthday", ei.getBirthday());
			session.setAttribute("phone", ei.getPhone());
			session.setAttribute("email", ei.getEmail());
			session.setAttribute("street", ei.getStreet());
			session.setAttribute("city", ei.getCity());
			session.setAttribute("state", ei.getState());
			session.setAttribute("zipcode", ei.getZipcode());
			response.sendRedirect("employee");
		} else if (mi != null && user.equals(mi.getUsername()) && pass.equals(mi.getPassword())) {
			session.setAttribute("username", mi.getUsername());
			session.setAttribute("userid", mi.getManagerid());
			session.setAttribute("pass", mi.getPassword());
			session.setAttribute("name", mi.getName());
			session.setAttribute("birthday", mi.getBirthday());
			session.setAttribute("phone", mi.getPhone());
			session.setAttribute("email", mi.getEmail());
			session.setAttribute("street", mi.getStreet());
			session.setAttribute("city", mi.getCity());
			session.setAttribute("state", mi.getState());
			session.setAttribute("zipcode", mi.getZipcode());
			response.sendRedirect("manager");
			
		} else {
			//System.out.println("login was not successful - please try again");
			response.sendRedirect("login");
		}
	}

}
