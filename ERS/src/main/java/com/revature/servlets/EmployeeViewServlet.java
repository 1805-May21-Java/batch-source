package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ERSDaoImpl;
import com.revature.pojos.EmployeeInfo;

/**
 * Servlet implementation class EmployeeViewServlet
 */
public class EmployeeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//similar to previous servlets, and print them gotten information into json, so javascript can get and read them
		HttpSession session = request.getSession(false);
		ERSDaoImpl edi = new ERSDaoImpl();
		String user = (String) session.getAttribute("username");
		String pass = (String) session.getAttribute("pass");
		EmployeeInfo ei = edi.findEmpByUP(user, pass);
		ObjectMapper om = new ObjectMapper();
		String ce = om.writeValueAsString(ei);
		ce = "{\"views\":"+ce+"}";
		PrintWriter pw = response.getWriter();
		pw.write(ce);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
