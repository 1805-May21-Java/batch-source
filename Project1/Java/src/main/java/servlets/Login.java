package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DaoEmployeeImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("index.html").forward(request, response);	
		HttpSession session = request.getSession();
		PrintWriter printWriter = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		if(session.getAttribute("login") != null && session.getAttribute("login").equals("incorrect")){
			//sees if the session has an attribute login, and if that attribute is incorrect.  
			//If so, user has tried and failed to login
			jsonObject.put("credentials", "incorrect");
			jsonObject.put("employee", session.getAttribute("employee"));
			printWriter.println(jsonObject);
		}else {
			//User has not logged in at all
			jsonObject.put("credentials", "empty");
			printWriter.println(jsonObject);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoEmployeeImpl daoEmployeeImpl = new DaoEmployeeImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Employee employee = daoEmployeeImpl.employeeLogin(username, password);
		
		if(employee == null) {
			//login failed, set the attribute incorrect to display error message when next logged in
			session.setAttribute("login", "incorrect");
			response.sendRedirect("index.html");
		}else {
			//login success, set the employee for the session and redirect to employee home page
			session.setAttribute("login", "correct");
			session.setAttribute("employee", employee);
			response.sendRedirect("CreateReimbursement");
		}
		
	}

}
