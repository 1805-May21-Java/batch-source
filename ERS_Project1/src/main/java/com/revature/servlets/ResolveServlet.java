package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.RequestDaoImpl;

/**
 * Servlet implementation class ResolveServlet
 */
public class ResolveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResolveServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./ManageRequests");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer requestId = Integer.parseInt(request.getParameter("reqId"));
		String status = request.getParameter(requestId.toString());
		String manager = request.getParameter("manager");
		HttpSession session = request.getSession(false);
		if(session != null) {
			RequestDaoImpl rdi = new RequestDaoImpl();
			rdi.resolveRequest(requestId, status, manager);
			
		} else {
			//TODO: send message that failed
		}
		response.sendRedirect("./ManageRequests");
	}

}
