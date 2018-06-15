package com.revature.servlets;
import java.io.*;
import java.sql.Blob;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.revature.dao.*;
import com.revature.pojos.*;
import com.google.gson.*;
public class GetPendingRequestsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected FullDAO service = new FullDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//doGet instead of a doPost for this one
		PrintWriter pw = response.getWriter();
		Gson gs = new Gson();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false); //also false
		User u = (User)session.getAttribute("user");
		if (u != null) {
			List<Reimbursement> reimList = null;
			if(u.getRole() == Role.EMPLOYEE) {
				reimList = service.getPendings(u.getId());
			} else if(u.getRole() == Role.MANAGER) {
				reimList = service.getPendings(); //manager has it better, no need to get id
			}
			if(reimList != null) { // list MUST NOT BE NULL
				pw.write("{\"success\":true, \"requests\": " + gs.toJson(reimList) + "}");
			} else {
				pw.write("{\"success\":false,\"message\":\"ERROR: Could not get requests\" }");
			}
			pw.close();
		}
	}
}
