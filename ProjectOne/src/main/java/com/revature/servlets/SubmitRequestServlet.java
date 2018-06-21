package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.EmployeeDaoImpl;
import com.revature.daos.ReimbursementRequestDaoImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class SubmitRequestServlet
 */
public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementRequestDaoImpl rdi = new ReimbursementRequestDaoImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int loggedInID = (int)request.getSession().getAttribute("id");
		
		String description = request.getParameter("reason");
		double value = Double.parseDouble(request.getParameter("value"));
		
		rdi.createRiR(loggedInID, description, value);
		
		response.sendRedirect("request");
	}

}
