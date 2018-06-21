package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessServ
 */
public class SessServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		System.out.println(response);
		System.out.println(session);
		if(session != null) {
			pw.write("{\"EmployeeID\":\"" + request.getAttribute("E_ID") + "\", \"EmployeeName\":\"" + 
					session.getAttribute("EMP_NAME") + "\", \"Role\":\"" + session.getAttribute("E_TYPE") + 
					"\", \"EmployeeUsername\":\"" + session.getAttribute("E_USERNAME") + "\", \"EmployeePassword\":\"" + session.getAttribute("E_PASSWORD") +
					"\", \"Occupation\":\"" + session.getAttribute("E_POSITION") + "\"}");
		}else {
			pw.write("{\"Employee ID\": null, \"Employee Name\": null, \"Role\": null, \"Employee Username\": null, \"Employee Password\": null, \"Occupation\": null,}");

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
