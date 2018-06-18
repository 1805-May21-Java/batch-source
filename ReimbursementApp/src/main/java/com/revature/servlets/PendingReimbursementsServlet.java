package com.revature.servlets;
//url is: /pendingReimbursements
import java.io.IOException;
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
 * Servlet implementation class PendingReimbursementsServlet
 */
public class PendingReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingReimbursementsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("PendingReimbursements.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Integer reimbursementId = Integer.parseInt(request.getParameter("id"));
		String radioVal = request.getParameter("choice");
		ReimbursementDaoImpl rd1 = new ReimbursementDaoImpl();
		ObjectMapper om = new ObjectMapper();
		if(session != null && "Approved".equals(radioVal)) {
			Reimbursement currentReimbursement = rd1.getReimbursementById(reimbursementId);
			currentReimbursement.setStatus("Approved");
			Integer managerId = Integer.parseInt(session.getAttribute("id").toString());
			currentReimbursement.setReviewer_id(managerId);
			rd1.updateReimbursement(currentReimbursement);
			List<Reimbursement> updatedList = rd1.getReimbursements();
			String newData = om.writeValueAsString(updatedList);
			session.setAttribute("allReimbursements", newData);
			response.sendRedirect("pendingReimbursements");
			
		}else if(session != null && "Denied".equals(radioVal)) {
			Reimbursement currentReimbursement = rd1.getReimbursementById(reimbursementId);
			currentReimbursement.setStatus("Denied");
			Integer managerId = Integer.parseInt(session.getAttribute("id").toString());
			currentReimbursement.setReviewer_id(managerId);
			rd1.updateReimbursement(currentReimbursement);
			List<Reimbursement> updatedList = rd1.getReimbursements();
			String newData = om.writeValueAsString(updatedList);
			session.setAttribute("allReimbursements", newData);
			response.sendRedirect("pendingReimbursements");
		}else {
			request.getRequestDispatcher("PendingReimbursements.html").forward(request, response);
		}
		
	}

}
