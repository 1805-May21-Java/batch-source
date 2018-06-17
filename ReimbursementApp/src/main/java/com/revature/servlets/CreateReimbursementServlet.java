package com.revature.servlets;

//name is createReimbursement
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class CreateReimbursementServlet
 */
public class CreateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.getRequestDispatcher("CreateReimbursement.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amount = request.getParameter("amount");
		//String userData;
		HttpSession session = request.getSession(false);
		EmployeeDaoImpl ed1 = new EmployeeDaoImpl();
		if(session != null && amount != null) {
			Employee current = ed1.getEmployeeByUsername(session.getAttribute("username").toString());
			//System.out.println(current);
			Integer eid = current.getEmployee_id();
			ReimbursementDaoImpl rd1 = new ReimbursementDaoImpl();
			Reimbursement application = new Reimbursement(null, Double.parseDouble(amount), eid, "Pending", null);
			rd1.createReimbursement(application);
			System.out.println("Reimbursement request received");
			response.sendRedirect("createReimbursement");
		}else {
			System.out.println("Something is wrong, username attribute not in session");
		}
		
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
