package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagerDAOImpl;


public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //get user credentials from request
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        
        ManagerDAOImpl manCheck = new ManagerDAOImpl();
        String passcheck = manCheck.getManagerByEmail(email);
        
        // checks credentials
        if(password.equals(passcheck)) {
            System.out.println("login was successful");
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            response.sendRedirect("managerhome.html");
            
        } else {
            System.out.println("login was unsuccessful, please try again");
            response.sendRedirect("index.html");
        }
	}

}
