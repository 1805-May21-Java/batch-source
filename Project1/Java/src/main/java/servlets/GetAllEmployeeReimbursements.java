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
import com.revature.pojos.Employee;
import com.revature.pojos.Manager;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class GetAllEmployeeReimbursements
 */
public class GetAllEmployeeReimbursements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllEmployeeReimbursements() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("employee") == null) {
			request.getRequestDispatcher("Logout").forward(request, response);
			response.setStatus(404);
		}else {
			ArrayList<Employee> employeeList;
			ArrayList<Reimbursement> reimbursementList = new ArrayList<>();
			//If this tab is accessible, then employee is a manager
			Manager manager = (Manager) session.getAttribute("employee");
			employeeList = manager.getEmployeeList();
			for(Employee employee : employeeList) {
				reimbursementList.addAll(employee.findEmpolyeeReimbursements());
			}
			
			PrintWriter printWriter = response.getWriter();
			ObjectMapper objectMapper = new ObjectMapper();
			String reimbursementString = objectMapper.writeValueAsString(reimbursementList);
			reimbursementString = "{\"reimbursements\":"+reimbursementString+"}";
			printWriter.write(reimbursementString);
			
		}
	}
	
	//Currently unused, could work to recursively get employees
	private static ArrayList<Reimbursement> getAllReimbursements(ArrayList<Employee> employees, 
			ArrayList<Reimbursement> reimbursements){
		ArrayList<Employee> subEmployees = new ArrayList<>();
		for(Employee employee : employees ) {
			reimbursements.addAll(employee.findEmpolyeeReimbursements());
			subEmployees.addAll(employee.getEmployeesUnderManager());
		}
		if(subEmployees.size() > 0) {
			getAllReimbursements(subEmployees, reimbursements);
		}
		else {
			return reimbursements;
		}
		return null;
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
