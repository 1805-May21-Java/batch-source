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
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Reimbursement;

public class MngPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MngPendingServlet() {
        super();
    }

    String user = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		List<Reimbursement> pendings = rdi.getPendings();
		ObjectMapper om = new ObjectMapper();
		String reimbursementStr = om.writeValueAsString(pendings);
		reimbursementStr = "{\"reimbursements\":"+reimbursementStr+"}";
		PrintWriter pw = response.getWriter();
		pw.write(reimbursementStr);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
