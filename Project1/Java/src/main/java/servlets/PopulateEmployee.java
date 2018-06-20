package servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class PopulateEmployee
 */
public class PopulateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateEmployee() {
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
			Employee employee = (Employee) session.getAttribute("employee");
			ObjectMapper objectMapper = new ObjectMapper();
			String employeeString ="";
			if(employee != null) {
				employeeString = objectMapper.writeValueAsString(employee);
			}
			PrintWriter printWriter = response.getWriter();
			if(session != null) { 
				printWriter.print(employeeString);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
