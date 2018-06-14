package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet{
	private static final long serialVersionUID = -6426094775000334662L;
	public static class Info{
		private String message;
		private boolean canShow;
		
		public Info() {
			this.message = "default";
			this.canShow = true;
		}
		
		public Info(String message, boolean canShow) {
			this.message = message;
			this.canShow = canShow;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public boolean getCanShow() {
			return canShow;
		}

		public void setCanShow(boolean canShow) {
			this.canShow = canShow;
		}
	}
	public static ArrayList<Info> messages = new ArrayList<Info>();
	public static ArrayList<Info> errors = new ArrayList<Info>();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		if(session != null)
			pw.write("{\"username\":\"" + session.getAttribute("username") + "\"}");
		else
			pw.write("{\"username\": null}");
		pw.close();
	}
	
	public static void clearMessagesAndErrors() {
		if(messages.size() != 0) {
			for(int i = messages.size()-1; i >= 0; i--) {
				messages.remove(i);
			}
		}
		if(errors.size() != 0) {
			for(int i = errors.size()-1; i >= 0; i--) {
				errors.remove(i);
			}
		}
	}
}
