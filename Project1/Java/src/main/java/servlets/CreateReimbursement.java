package servlets;

import java.io.IOException;
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
 * Servlet implementation class CreateReimbursement
 */
public class CreateReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReimbursement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("employee") != null) {
			request.getRequestDispatcher("emplRemb.html").forward(request, response);
		}else {
			request.getRequestDispatcher("Logout").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//Inserts new reimbursement
		DaoReimbursementImpl daoReimbursementImpl = new DaoReimbursementImpl();
		//Gets body info from Ajax
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimbursement = mapper.readValue(request.getReader().readLine(), Reimbursement.class);
		//Gets employeeId to add to new reimbursement
		HttpSession session = request.getSession();
		System.out.println((Employee)session.getAttribute("employee"));
		System.out.println(((Employee)session.getAttribute("employee")).getIdNumber()  );
		reimbursement.setEmployeeId(((Employee) session.getAttribute("employee")).getIdNumber());
		session.setAttribute("newReimbursement", reimbursement);
		daoReimbursementImpl.insertNewReimbursement(reimbursement);
		response.sendRedirect("NewReimbursementEmail");
	}

}
