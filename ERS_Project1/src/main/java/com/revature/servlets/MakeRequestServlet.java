package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.actors.GateKeeper;
import com.revature.dao.RequestDaoImpl;
import com.revature.pojos.Request;

/**
 * Servlet implementation class MakeRequestServlet
 */
public class MakeRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeRequestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			request.getRequestDispatcher("./MakeRequest.html").forward(request, response);
		} else {
			request.getRequestDispatcher("./Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("empId"));
		int id = Integer.parseInt(request.getParameter("empId"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");
		
		Request newReq = new Request(id, amount, description);
		RequestDaoImpl rdi = new RequestDaoImpl();
		rdi.createRequest(newReq);
		
		//send to confirm
		response.sendRedirect("./Profile");
		
	}

}
