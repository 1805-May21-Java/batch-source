package com.revature.servlets;
import java.io.*;
import java.sql.Blob;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.revature.dao.*;
import com.revature.pojos.*;
import com.google.gson.*;
public class GetCurrentUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected FullDAO service = new FullDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//doGet instead of a doPost for this one
		PrintWriter pw = response.getWriter();
		Gson gs = new Gson();
		//now to REALLY make use of that GSON
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(); //no need to set this now
		User u = (User)session.getAttribute("user");
		if (u != null) {
			pw.write("{\"success\":true, \"user\": " + gs.toJson(u) + "}");
		} else {
			pw.write("{\"success\":false,\"message\":\"Not logged in\"}");
		}
		pw.close();
	}
}
