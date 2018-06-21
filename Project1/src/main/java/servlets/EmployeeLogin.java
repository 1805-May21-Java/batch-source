package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAOImpl;
import dao.ManagerDAOImpl;


public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//get user credentials
		String email = request.getParameter("email");
        String password = request.getParameter("password");
 
        HttpSession session = request.getSession();
        
        EmployeeDAOImpl emp1 = new EmployeeDAOImpl();
        
        String passcheck = emp1.getEmployeeByEmail(email).getPassword();
        
        // checks credentials
        if(password.equals(passcheck)) {
            System.out.println("login was successful");
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            response.sendRedirect("employeehome.html");
            
        } else {
            System.out.println("login was unsuccessful, please try again");
            response.sendRedirect("index.html");
        }
	
	}

}
