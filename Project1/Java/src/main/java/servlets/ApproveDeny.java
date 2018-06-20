package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DaoReimbursementImpl;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class ApproveDeny
 */
public class ApproveDeny extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveDeny() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reads in updated reimbursement and saves to database
		DaoReimbursementImpl daoReimbursementImplTest = new DaoReimbursementImpl();
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		System.out.println(daoReimbursementImplTest.updateOldReimbursement(
				mapper.readValue(request.getReader().readLine(), Reimbursement.class)));
		request.getRequestDispatcher("GetAllEmployeeReimbursements").forward(request, response);
		
	}

}
