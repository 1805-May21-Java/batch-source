package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAOImpl;
import dao.RequestDAOImpl;


public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAOImpl emp = new EmployeeDAOImpl();
		RequestDAOImpl req = new RequestDAOImpl();
		
		HttpSession session = request.getSession();
		String empemail = session.getAttribute("email").toString();
		int id = emp.getEmployeeIdByEmail(empemail);
		System.out.println(empemail);
		System.out.println(id);
		
		double amount = Double.parseDouble(request.getParameter("request"));
		String description = request.getParameter("description");
		
		if (amount > 0) {
		req.submitNewRequest(amount, id, description);
		System.out.println("new request submitted");
		response.sendRedirect("employeehome.html");
		} else { response.sendRedirect("employeesubmitrequest.html");
		
	}

}
}
