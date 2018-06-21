package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Reimbursement;

public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubmitServlet() {
        super();
    }
    
    String username = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Submit.html").forward(request, response);
		System.out.println("get called");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post called");
		HttpSession session = request.getSession(false);
		username = (String) session.getAttribute("username");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int empId = edi.getEmployeeByUsername(username).getEmpId();
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		
		if(amount != "" && description != "") {
			rdi.createReimbursement(new Reimbursement(0,"Pending", empId, 0, description, amount));
			response.sendRedirect("EmpHome.html");
		}	
		//doGet(request, response);
	}

}
