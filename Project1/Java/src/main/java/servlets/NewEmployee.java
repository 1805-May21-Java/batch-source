package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DaoEmployeeImpl;
import com.revature.dao.DaoReimbursementImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class NewEmployee
 */
public class NewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployee() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insert new employee
		HttpSession session = request.getSession();
		DaoEmployeeImpl daoEmployeeImpl = new DaoEmployeeImpl();
				//Gets body info from Ajax
				ObjectMapper mapper = new ObjectMapper();
				Employee employee= mapper.readValue(request.getReader().readLine(), Employee.class);
				//checks for unique email
				if(daoEmployeeImpl.emailExists(employee.getEmail())) {
					//email already exists, don't insert and send error
					session.setAttribute("emailInvalid", true);
					response.sendRedirect("ValidInvalid");
				}else {
					//email unique, insert
					//Gets manager to add to new reimbursement
					employee.setManagerId(((Employee) session.getAttribute("employee")).getIdNumber());
					daoEmployeeImpl.insertNewEmployee(employee);
					session.setAttribute("emailInvalid", false);
					session.setAttribute("newEmployee", employee);
					response.sendRedirect("NewEmployeeEmail");
				}
				
	}
				

}
