package com.revature.servlets;
import java.io.*;
import java.sql.Blob;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.revature.dao.*;
import com.revature.pojos.*;
import com.google.gson.*;
public class GetEmployeesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected FullDAO service = new FullDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		Gson gs = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false); //again, go back to false here
		User u = (User)session.getAttribute("user");
		if (u != null) {
			List<User> empList = null;
			if(u.getRole() == Role.MANAGER) {
				//we are back to this again
				empList = service.listEmployees();
				if(empList != null) { //list shouldn't be null though
					pw.write("{\"success\":true, \"employees\": " + gs.toJson(empList) +  "}");
				} else {
					pw.write("{\"success\":false,\"message\":\"ERROR: Could not get employees}");
				}
			} else {
				pw.write("{\"success\":false,\"message\":\"You are not a manager\"}");
			}
		} else {
			pw.write("{\"success\":false,\"message\":\"Not logged in\"}");
		}
		pw.close();
	}
}
