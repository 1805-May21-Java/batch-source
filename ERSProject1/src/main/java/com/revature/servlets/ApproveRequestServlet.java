package com.revature.servlets;
import java.io.*;
import java.sql.Blob;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.revature.dao.*;
import com.revature.pojos.*;
import com.google.gson.*;
public class ApproveRequestServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected FullDAO service = new FullDAOImpl();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		//now to make use of that GSON
		//creating a new instance of GSON is actually optional
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false); //set this to false
		User u = (User)session.getAttribute("user");
		if (u != null) {
			if(u.getRole() == Role.MANAGER) { //check role if it is a manager
				try {
					int requester_id = Integer.parseInt(request.getParameter("request_id"));
					boolean go = service.approveRequest(requester_id, u.getId()); //tests for success
					if(go) {
						pw.write("{\"success\": true}");
					} else {
						pw.write("{\"success\":false,\"message\":\"Invalid input\"}");
					}
				} catch (Exception e) {
					pw.write("{\"success\":false,\"message\":\"Invalid input\"}");
				}
			} else {
				pw.write("{\"success\":false,\"message\":\"Not a manager\"}");
			}
		} else {
			pw.write("{\"success\":false,\"message\":\"Not logged in\"}");
		}
		pw.close();
	}
}
