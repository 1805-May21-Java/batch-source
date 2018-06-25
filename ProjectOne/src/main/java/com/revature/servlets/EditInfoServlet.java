package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.EmployeeDaoImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class EditInfoServlet
 */
public class EditInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int id = (Integer)request.getSession().getAttribute("id");
		Employee loggedIn = edi.getEmployeeById(id);
		
		if(!loggedIn.isManager()) {
			request.getRequestDispatcher("Views/EditInfoEmployee.html").forward(request, response);			
		}
		else if(!loggedIn.isHeadHoncho()) {
			request.getRequestDispatcher("Views/EditInfoManager.html").forward(request, response);
		}
		else {
			request.getRequestDispatcher("Views/EditInfoHead.html").forward(request, response);;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
