package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ERSDaoImpl;
import com.revature.pojos.EmployeeInfo;

/**
 * Servlet implementation class PassResetServlet
 */
public class PassResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassResetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("ResetPassword.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//just gets the password input from the user, make sure the old one entered matches, and confirmation is correct,
		//then run the update information for passwords
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		String opass = request.getParameter("opass");
		String npass = request.getParameter("npass");
		String cpass = request.getParameter("cpass");
		EmployeeInfo ei = new EmployeeInfo();
		ERSDaoImpl edi = new ERSDaoImpl();
		ei = edi.findEmpByUP(user, opass);
		if(ei != null && npass.equals(cpass)) {
			ei.setPassword(npass);
			edi.updateEmployee(ei);
		}
		doGet(request, response);
	}

}
