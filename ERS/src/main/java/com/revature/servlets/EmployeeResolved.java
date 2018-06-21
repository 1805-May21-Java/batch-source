package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ERSDaoImpl;
import com.revature.pojos.ReimbursementInfo;

/**
 * Servlet implementation class EmployeeResolved
 */
public class EmployeeResolved extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeResolved() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//similat to pending, just use the information gotten from the ERSDaoImpl, and print them here
		HttpSession session = request.getSession();
		ERSDaoImpl edi = new ERSDaoImpl();
		int id = (int) session.getAttribute("userid");
		List<ReimbursementInfo> rialist = new ArrayList<ReimbursementInfo>();
		rialist = edi.viewEApproved(id);
		ObjectMapper om = new ObjectMapper();
		String rialistString = om.writeValueAsString(rialist);
		rialistString = "{\"erialist\":"+rialistString+"}";
		PrintWriter pw = response.getWriter();
		pw.write(rialistString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
