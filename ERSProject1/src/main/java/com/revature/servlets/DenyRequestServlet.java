package com.revature.servlets;

import java.io.*;
import java.sql.Blob;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.revature.dao.*;
import com.revature.pojos.*;
import com.google.gson.*;
//****THIS MAY NOT WORK***
public class DenyRequestServlet extends HttpServlet {
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
					int request_id = Integer.parseInt(request.getParameter("request_id"));
					boolean go = service.rejectRequest(request_id, u.getId());
					if(go) {
						pw.write("{\"success\": true}");
					} else {
						pw.write("{\"success\": false, \"message\": \"Error: Invalid. Please try again.\"}");
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
