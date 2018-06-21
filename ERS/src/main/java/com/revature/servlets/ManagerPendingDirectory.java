package com.revature.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ERSDaoImpl;

/**
 * Servlet implementation class ManagerPendingDirectory
 */
public class ManagerPendingDirectory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerPendingDirectory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("ManagerPendingRequest.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ERSDaoImpl edi = new ERSDaoImpl();
		String[] check =  request.getParameterValues("myTextEditBox");
		String accept = request.getParameter("accept");
		String deny = request.getParameter("deny");
		String name = (String) session.getAttribute("name");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date aday1 = new java.util.Date();
		Date aday2 = new Date(aday1.getTime());
		//set up a checkbox with the same name in the html, so when getting the values, store them in an array, and check which button
		//accept or deny is pressed, and act accodingly
		if(accept != null) {
			for (int i = 0; i < check.length; i++) {
				//if accept is pressed, use the information gotten to run the approve function there
				//then use the reimbursement id to find employee id then the employee email
				//and redirect it to sendemail servlet
				if (check[i] != null) {
					int a = Integer.parseInt(check[i]);
					edi.approve(a, name, aday2);
					int b = edi.idfromId(a);
					String subemail = edi.emailfromId(b);
					session.setAttribute("sube", subemail);
					session.setAttribute("subid", a);
					
				}
				response.sendRedirect("submitemail");
			}
			//if it is deny then refresh the page after operation done
		} else if(deny != null) {
			for (int i = 0; i < check.length; i++) {
				if (check[i] != null) {
					int a = Integer.parseInt(check[i]);
					edi.deny(a);
				} 
			}
			doGet(request, response);
		}
		
		
	}

}
