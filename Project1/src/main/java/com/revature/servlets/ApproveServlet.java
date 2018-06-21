package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;

public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ApproveServlet() {
        super();
    }

    String user = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		user = (String) session.getAttribute("username");
		Integer reimbursementId = Integer.parseInt(request.getParameter("reimbursementId"));
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int mngId = edi.getEmployeeByUsername(user).getEmpId();
		rdi.approveReimbursement(reimbursementId, mngId);
		response.sendRedirect("MngHome.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("approve post");
//		doGet(request, response);
	}

}
