package com.revature.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Employee;
import com.revature.util.BCrypt;

public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 8549104311958533089L;
	ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		HttpSession session = request.getSession(false);
		String employeeEmail = (String) session.getAttribute("email");
		Employee employee = edi.getEmployee(employeeEmail);
		ObjectMapper om = new ObjectMapper();
		String employeeString = om.writeValueAsString(employee);
		employeeString = "{\"employee\":" + employeeString+"}";
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.write(employeeString);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amount = null;
		String reason = null;
		HttpSession session = request.getSession(false);
		String employeeEmail = (String) session.getAttribute("email");
	    try {
	        ArrayList<FileItem> items = (ArrayList<FileItem>) new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	        for (FileItem item : items) {
	            if (item.isFormField()) {
	                String fieldName = item.getFieldName();
	                if(fieldName.equals("amount")) {
	                	amount = item.getString();
	                }
	                if(fieldName.equals("reason")) {
	                	reason = item.getString();
	                }

	            } else {          		            	
	                String fileName = FilenameUtils.getName(item.getName());
	                InputStream fileContent = item.getInputStream();
	                String bucket_name = "revature-project-1";
	                File file = new File(fileName);
	                FileUtils.copyInputStreamToFile(fileContent, file);
	                final AmazonS3 s3 = AmazonS3Client.builder().withRegion("us-east-1").build();
	                String reasonURL = reason.replaceAll("\\s","");
	                String key_name = amount + reasonURL + employeeEmail;
	                String key_name_hash = new StringBuilder(BCrypt.hashpw(key_name, "$2a$10$UoN1BeeYXiuBPKtefJ8Qx.")).reverse().toString();
	                try {
	                    s3.putObject(bucket_name, key_name_hash, file);
		        		int result = rdi.createReimbursement(amount, reason, employeeEmail, key_name_hash);
		        		if(result == 1) {
		        			System.out.println("Reimbursement request created succesfully");
		        			response.sendRedirect("employee.html");
		        		}
		        		else {
		        			System.out.println("Could not create reimbursement request.");
		        			response.sendRedirect("employee.html");
		        		}
	                } catch (AmazonServiceException e) {
	                    System.err.println(e.getErrorMessage());
	                    System.exit(1);
	                }
	            }
	        }
	    } catch (FileUploadException e) {
	        throw new ServletException("Cannot parse multipart request.", e);
	    }
	}
}
