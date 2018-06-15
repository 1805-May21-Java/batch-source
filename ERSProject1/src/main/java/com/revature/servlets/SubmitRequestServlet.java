package com.revature.servlets;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import com.revature.dao.*;
import com.revature.pojos.*;
@MultipartConfig
public class SubmitRequestServlet extends HttpServlet{
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
			try {
				double amount = Double.parseDouble(request.getParameter("amount"));
				String descript = request.getParameter("description");
				InputStream receipt = request.getPart("receipt").getInputStream();
				ReimbursementType t = ReimbursementType.valueOf(Integer.parseInt(request.getParameter("type")));
				boolean go = service.createRequest(amount, descript, receipt, u.getId(), t);
				if(go) {
					pw.write("{\"success\": true}");
				} else {
					pw.write("{\"success\": false, \"message\": \"ERROR: Failed to submit the reimbursement request. Please try again.\"}");
				}
			} catch (NumberFormatException e) {
				pw.write("{\"success\":false,\"message\":\"Invalid input\"}");
			}
		} else {
			pw.write("{\"success\":false,\"message\":\"Not logged in\"}");
		}
		pw.close();
	}
}
