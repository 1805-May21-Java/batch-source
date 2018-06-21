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

public class MngResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public MngResolvedServlet() {
        super();
    }

    String user = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get called");
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		List<Reimbursement> resolved = rdi.getResolved();
		System.out.println(resolved);
		ObjectMapper om = new ObjectMapper();
		String reimbursementStr = om.writeValueAsString(resolved);
		reimbursementStr = "{\"reimbursements\":"+reimbursementStr+"}";
		PrintWriter pw = response.getWriter();
		pw.write(reimbursementStr);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
