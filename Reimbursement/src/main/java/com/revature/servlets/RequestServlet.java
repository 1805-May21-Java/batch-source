package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identity = request.getParameter("E_ID");
		ReimbursementDAOImpl requestme = new ReimbursementDAOImpl();
		EmployeeDAOImpl emp = new EmployeeDAOImpl();
		ObjectMapper om = new ObjectMapper();
		String reimburseString;
		
		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("e_Id");
		
		if(emp.etypeCheck(emp.getEmployeeByID(id))) {
			List<Reimbursement> allReimbursements = requestme.getReimburse();
			reimburseString = om.writeValueAsString(allReimbursements);
			reimburseString = "{\"reimburse\":"+reimburseString+"}";
		}else {
			if(identity != null) {
				List<Reimbursement> reim = requestme.getReimByID(id);
				reimburseString = om.writeValueAsString(reim);
			}else {
				List<Reimbursement> myReims = requestme.getReimByID(id);
				reimburseString = om.writeValueAsString(myReims);
				reimburseString = "{\"Reimbursements\":"+reimburseString+"}";
			}
		}
		PrintWriter pw = response.getWriter();
		pw.print(reimburseString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("submitting request");
		String title = request.getParameter("ReimburseType");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String comments = request.getParameter("comments");
		
		HttpSession session = request.getSession(false);
		int id = (Integer) session.getAttribute("id"); // current user id
		
		ReimbursementDAOImpl requestDaoImpl = new ReimbursementDAOImpl();
		
		
		// insert into Request database
		if((title != null) && (amount > 0.00)) {
			requestDaoImpl.createReim(id, amount, comments, 1, id, title);
		}
		
		response.sendRedirect("employee-page");
	}

}
