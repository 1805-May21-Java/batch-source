package com.revature.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.revature.dao.*;
import com.revature.pojos.*;
import com.google.gson.*;
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected FullDAO service = new FullDAOImpl();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = service.verify(username, password);
		Gson gs = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if(u != null) {
			HttpSession session = request.getSession(true); //make this one true
			session.setAttribute("user", u);
			pw.write("{\"success\":true, \"user\": " + gs.toJson(u) + "}");
		} else {
			pw.write("{\"success\":false,\"message\":\"Invalid username/password. Try again.\"}");
		}
		pw.close();
	}
}
