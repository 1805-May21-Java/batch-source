package com.revature.servlets;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import com.revature.dao.*;
public class LogoutServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected FullDAO service = new FullDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		session.invalidate();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		pw.write("{\"success\":true}");
		pw.close();
	}
}
