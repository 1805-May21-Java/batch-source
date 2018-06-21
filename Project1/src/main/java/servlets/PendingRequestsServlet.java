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

import dao.RequestDAOImpl;
import model.Request;


public class PendingRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDAOImpl req = new RequestDAOImpl();
		HttpSession session = request.getSession(false);
		response.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper om = new ObjectMapper();
		response.setContentType("application/json");
		
		ArrayList<Request> pendingRequests = new ArrayList<Request>();
		pendingRequests = req.getPendingRequests();
//		ArrayList<Request> approvedRequests = new ArrayList<Request>();
//		approvedRequests = req.getApprovedRequests();
		
		String requestString = om.writeValueAsString(pendingRequests);
		//requestString = "{\"pendingRequests\":"+requestString+"}";
//		String approvedString = om.writeValueAsString(approvedRequests);
//		approvedString = "approvedRequests\":"+approvedString+"}";

	
		PrintWriter pw = response.getWriter();
		pw.print(requestString);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
