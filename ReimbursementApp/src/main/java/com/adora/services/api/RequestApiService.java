package com.adora.services.api;



import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.adora.access.RequestDaoImpl;

import com.adora.pojos.Request;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestApiService {
	
	public static String requestData(String role, String type,  int employeeId, String status, String requestId ) throws IOException {
		RequestDaoImpl rdi = new RequestDaoImpl();
		ObjectMapper om = new ObjectMapper();
		
		int statusInt = 0;
		int requestInt = 0;
		String requestStr = "";
		
		try {
			statusInt =  Integer.parseInt(status);
		} catch (NumberFormatException | NullPointerException e) {
			// do nothing
		}
		try {
			requestInt = Integer.parseInt(requestId);
		} catch(NumberFormatException | NullPointerException e) {
			//do nothing
		}
		
		if(role == "manager") {
			System.out.println("the type is " + type);
			if(type != null) {
				System.out.println("the type is not null");
				if(type.equals("personal")) {
					System.out.println("the type is personal");
				}
			}
			
			if(type != null && type.equals("personal")) {
				System.out.println("i am a manager getting a request");
				List<Request> requestList = rdi.getAllRequestsByEmployee(employeeId);
				requestStr = om.writeValueAsString(requestList);
			}
			else if(statusInt > 0 ) {
				List<Request> requestList = rdi.getAllStatusRequestsByManager(employeeId, statusInt);
				requestStr = om.writeValueAsString(requestList);
			} 
			else if(requestInt > 0 ) {
				Request currentRequest = new Request();
				currentRequest.setRequestId(requestInt);
				currentRequest = rdi.getRequest(currentRequest);
				requestStr = om.writeValueAsString(currentRequest);
			} 
			else {
				List<Request> requestList = rdi.getAllRequests(employeeId);
				requestStr = om.writeValueAsString(requestList);
			}
		} else if (role == "employee") {
			if(statusInt > 0) {
				List<Request> requestList = rdi.getAllStatusRequestsByEmployee(employeeId, statusInt);
				requestStr = om.writeValueAsString(requestList);
			} else {
				List<Request> requestList = rdi.getAllRequestsByEmployee(employeeId);
				requestStr = om.writeValueAsString(requestList);
			}
		}
		
		return requestStr;
		
	}
	
	
	public static void validateRequestPostData(String action, String subject, String appAmount, String reqAmount, int employeeId, int managerId, String reqId) {
		
		double requestedAmount = 0;
		double approvedAmount = 0;
		int requestId = 0;
		
		//data validation
		if(subject!= null) {
			if(subject.length() <= 8) {
				//TODO messaging: cant 
				return;
			}
		}
		try {
			requestedAmount = Double.parseDouble(reqAmount);
			if(requestedAmount > 9999.99)  {
				//TODO messaging : cant request more than 9999.99
				return;
			}
			if((requestedAmount * 100 % 1) != 0) {
				//TODO messaging : cant add partial cents
				return;
			}
			if(requestedAmount <= 0) {
				//TODO messaging : cant request partial cents
			}
			
		} catch (NumberFormatException  | NullPointerException e) {
				//TODO messaging
			System.out.println("cant parse requested amount");
		}
		try {
			approvedAmount = Double.parseDouble(appAmount);
			if(approvedAmount > 9999.99)  {
				//TODO messaging : cant request more than 9999.99
				return;
			}
			if((approvedAmount * 100 % 1) != 0) {
				//TODO messaging : cant add partial cents
				return;
			}
			if(approvedAmount <= 0) {
				//TODO messaging : cant request partial cents
			}
			
		} catch (NumberFormatException | NullPointerException e) {
			
			//TODO messaging
			System.out.println("cant parse approved amount");
		}
		try {
			requestId = Integer.parseInt(reqId);
		} catch(NumberFormatException | NullPointerException e) {
			System.out.println("cant parse request id");
		}
		
		
		switch(action) {
		case "submit":
			submitRequest(subject, requestedAmount, employeeId, managerId);
			break;
		case "approve":
			approveDenyRequest(requestId, approvedAmount, 2);
			break;
		case "deny":
			approveDenyRequest(requestId, approvedAmount, 3);
			break;
		default:
			System.out.println("error message");
			break;
		}
		
	}

	public static void submitRequest(String subject, double requestedAmount, int employeeId, int managerId) {
		
		RequestDaoImpl rdImpl = new RequestDaoImpl();
		Request request = new Request();
		request.setDateSubmitted(new Date(Calendar.getInstance().getTimeInMillis()));
		request.setEmployeeId(employeeId);
		request.setManagerId(managerId);
		request.setStatus(1);
		request.setSubject(subject);
		request.setRequestedAmount(requestedAmount);
		
		System.out.println(request.toString());
		
		rdImpl.createRequest(request);
	}

	public static void approveDenyRequest(int requestId, double approvedAmount, int status) {
		
		RequestDaoImpl rdi = new RequestDaoImpl();
		Request request = new Request();
		request.setRequestId(requestId);
		request = rdi.getRequest(request);
		request.setApprovedAmount(approvedAmount);
		request.setStatus(status);
		request.setDateApproved( new Date(Calendar.getInstance().getTimeInMillis()));
		
		
		rdi.updateRequest(request);
	}
}
