package com.revature.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.revature.dao.*;
import com.revature.pojos.*;
public class GetReceiptServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected FullDAO service = new FullDAOImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//doGet instead of a doPost for this one
		ServletOutputStream sos = response.getOutputStream();
		response.setContentType("image/*");
		HttpSession session = request.getSession(false); //also false
		User u = (User)session.getAttribute("user");
		try {
			if(u != null) {
				int requester_id = Integer.parseInt(request.getParameter("req_id"));
				if(u.getRole() == Role.MANAGER) {
					service.getReceipt(requester_id, sos);
				} else {
					service.getReceipt(u.getId(), requester_id, sos);
				}
			}
		} catch (Exception e) {
			
		}
		sos.close();
	}
}
