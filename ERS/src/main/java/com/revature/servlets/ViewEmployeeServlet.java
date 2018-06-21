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
import com.revature.pojos.EmployeeInfo;
import com.revature.pojos.ReimbursementInfo;

/**
 * Servlet implementation class ViewEmployeeServlet
 */
public class ViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the needed info from database and print them out as strings using om
		HttpSession session = request.getSession();
		ERSDaoImpl edi = new ERSDaoImpl();
		List<EmployeeInfo> ei  = new ArrayList<EmployeeInfo>();
		ei = edi.empList();
		ObjectMapper om = new ObjectMapper();
		String eiString = om.writeValueAsString(ei);
		eiString = "{\"eilist\":"+eiString+"}";
		PrintWriter pw = response.getWriter();
		pw.write(eiString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
