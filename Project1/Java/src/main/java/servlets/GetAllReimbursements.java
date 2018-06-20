package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DaoReimbursementImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class GetAllReimbursements
 */
public class GetAllReimbursements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllReimbursements() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("employee") == null) {
			request.getRequestDispatcher("Logout").forward(request, response);
		}else {
			ArrayList<Reimbursement> reimbursementList;
			DaoReimbursementImpl daoReimbursementImpl = new DaoReimbursementImpl();
			reimbursementList = daoReimbursementImpl.getReimbursementByEmployee(((Employee) session.
					getAttribute("employee")).getIdNumber());
			ObjectMapper objectMapper = new ObjectMapper();
			String reimbursementString ="";
			reimbursementString = objectMapper.writeValueAsString(reimbursementList);
			reimbursementString = "{\"reimbursements\":"+reimbursementString+"}";
			
			PrintWriter printWriter = response.getWriter();
			printWriter.print(reimbursementString);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
