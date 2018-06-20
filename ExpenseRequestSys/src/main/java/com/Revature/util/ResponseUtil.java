package com.Revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	public static void setResponse(HttpServletResponse response, int status, String contentType, String content)
			throws IOException {
		response.setStatus(status);
		response.setContentType(contentType);
		response.getWriter().write(content);
	}
}
