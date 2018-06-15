package com.revature.servlets;
import java.io.*;
import java.sql.Blob;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.revature.dao.*;
import com.revature.pojos.*;
import com.google.gson.*;
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected FullDAO service = new FullDAOImpl();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		User u = (User)session.getAttribute("user");
		if(u != null) {
			if(u.getRole() == Role.MANAGER) {
				try{
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					String fname = request.getParameter("firstname");
					String lname = request.getParameter("lastname");
					String email = request.getParameter("email");
					int userRole = Integer.parseInt(request.getParameter("role"));
					boolean go = service.createUser(username, password, fname, lname, email, Role.valueOf(userRole));
					if(go) {
						pw.write("{\"success\": true}");
					} else {
						pw.write("{\"success\": false, \"message\": \"Error: Failed to create new user. Please try again.\"}");
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
