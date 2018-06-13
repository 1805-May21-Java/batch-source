package com.revature.util;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	
	public static String process(HttpServletRequest req) {
		switch(req.getParameter("destination")) {
		case "employees":
			return "directory";
		case "locations":
			return "locDirectory";
		case "departments":
			return "deptDirectory";
		default:
			return "home";
		}
	}

}
