package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Info Servlet
 * 
 * Takes list of messages and errors from the SessionServlet and
 * writes them to the url path in JSON format for the frontend to use
 */
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.setContentType("application/json");
		
		pw.write("{\"errors\":[");
		for(int i = 0; i < SessionServlet.errors.size(); i++) {
			if(i != 0) {
				pw.write(",");
			}
			pw.write("{\"message\":\"" + SessionServlet.errors.get(i).getMessage() +
					"\", \"type\":" + SessionServlet.errors.get(i).getCanShow() + "}");
		}
		pw.write("],\"messages\":[");
		for(int i = 0; i < SessionServlet.messages.size(); i++) {
			if(i != 0) {
				pw.write(",");
			}
			pw.write("{\"message\":\"" + SessionServlet.messages.get(i).getMessage() +
					"\", \"type\":" + SessionServlet.messages.get(i).getCanShow() + "}");
		}
		pw.write("]}");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(SessionServlet.messages.size() != 0) {
			for(int i = SessionServlet.messages.size()-1; i >= 0; i--) {
				SessionServlet.messages.get(i).setCanShow(false);
			}
		}
		if(SessionServlet.errors.size() != 0) {
			for(int i = SessionServlet.errors.size()-1; i >= 0; i--) {
				SessionServlet.errors.get(i).setCanShow(false);
			}
		}
		doGet(req, res);
	}

}
