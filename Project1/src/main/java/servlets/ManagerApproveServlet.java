package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagerDAOImpl;
import dao.RequestDAOImpl;

public class ManagerApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ManagerDAOImpl mdi = new ManagerDAOImpl();
		HttpSession session = request.getSession();
		String manemail = session.getAttribute("email").toString();
		int manid = mdi.getManagerIdByEmail(manemail);
		
		int id = Integer.parseInt(request.getParameter("id"));
		RequestDAOImpl rdi = new RequestDAOImpl();
		
		
		rdi.updateRequest(id, manid);
		System.out.println("request approved");
		response.sendRedirect("managerhome.html");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ManagerDAOImpl mdi = new ManagerDAOImpl();
		HttpSession session = request.getSession();
		String manemail = session.getAttribute("email").toString();
		int manid = mdi.getManagerIdByEmail(manemail);
		
		int id = Integer.parseInt(request.getParameter("id"));
		RequestDAOImpl rdi = new RequestDAOImpl();
		
		System.out.println("req id: "+ id);
		System.out.println("manid: " + manid);
		
		rdi.updateRequest(id, manid);
		System.out.println("request approved");
		response.sendRedirect("managerhome.html");
		
	}

}
