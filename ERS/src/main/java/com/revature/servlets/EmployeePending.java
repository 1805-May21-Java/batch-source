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
 * Servlet implementation class EmployeePending
 */
public class EmployeePending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeePending() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//when the web loads in, get the reimbursement list from the function view all employee pending, then
		// store them in the list. Next, use object mapper to turn list into string, and prints them out to the site
		HttpSession session = request.getSession();
		ERSDaoImpl edi = new ERSDaoImpl();
		int id = (int) session.getAttribute("userid");
		List<ReimbursementInfo> riplist = new ArrayList<ReimbursementInfo>();
		riplist = edi.viewEPending(id);
		ObjectMapper om = new ObjectMapper();
		String riplistString = om.writeValueAsString(riplist);
		riplistString = "{\"eriplist\":"+riplistString+"}";
		PrintWriter pw = response.getWriter();
		pw.write(riplistString);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

