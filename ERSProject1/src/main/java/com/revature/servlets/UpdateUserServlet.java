package com.revature.servlets;
import java.io.*;
import java.sql.Blob;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.revature.dao.*;
import com.revature.pojos.*;
import com.google.gson.*;
public class UpdateUserServlet extends HttpServlet{
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
			u.setUsername(request.getParameter("username"));
			u.setFname(request.getParameter("firstname"));
			u.setLname(request.getParameter("lastname"));
			u.setEmail(request.getParameter("email"));
			boolean go = service.updateUser(u);
			if(go) {
				pw.write("{\"success\": true}");
			} else {
				pw.write("{\"success\": false, \"message\": \"ERROR: Failed to update user\"}");
			}
		} else {
			pw.write("{\"success\":false,\"message\":\"Not logged in\"}");
		}
		pw.close();
	}
}
