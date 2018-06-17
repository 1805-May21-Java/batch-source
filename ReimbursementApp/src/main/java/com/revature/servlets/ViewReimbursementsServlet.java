package com.revature.servlets;
//url: /viewReimbursements
//Fix ReimbursementDao!!!!
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class ViewReimbursementsServlet
 */
public class ViewReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReimbursementsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("ViewReimbursements.html").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String radioVal = request.getParameter("listChoice");
		//System.out.println(radioVal);
		if(session != null && "pending".equals(radioVal)) {
			ReimbursementDaoImpl rd1 = new ReimbursementDaoImpl();
			//Complete pending and resolved method in DAO implementation
			Integer eid = (Integer) session.getAttribute("id");
			List<Reimbursement> pendingList = rd1.getPendingByEmployeeId(eid);
			ObjectMapper om = new ObjectMapper();
			String pendingStr = om.writeValueAsString(pendingList);
			//System.out.println(pendingStr);
			session.setAttribute("viewList", pendingStr);
			response.sendRedirect("viewReimbursements");
		}else if(session != null && "resolved".equals(radioVal)) {
			ReimbursementDaoImpl rd1 = new ReimbursementDaoImpl();
			//Complete pending and resolved method in DAO implementation
			Integer eid = (Integer) session.getAttribute("id");
			List<Reimbursement> pendingList = rd1.getResolvedByEmployeeId(eid);
			ObjectMapper om = new ObjectMapper();
			String pendingStr = om.writeValueAsString(pendingList);
			session.setAttribute("viewList", pendingStr);
			response.sendRedirect("viewReimbursements");
		}else {
			request.getRequestDispatcher("ViewReimbursements.html").forward(request, response);
			
		}
	}

}
