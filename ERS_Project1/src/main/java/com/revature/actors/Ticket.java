package com.revature.actors;

import com.revature.dao.RequestDaoImpl;
import com.revature.pojos.Request;

public class Ticket {
	public static boolean checkComplete(int id, String amount, String description) {
		
		if(amount.equals("") || description.equals("")) {
			GateKeeper.setWarning("All fields must be completed.");
			return false;
		}
		double myAmount;
		try {
			myAmount = Double.parseDouble(amount);
		} catch (NumberFormatException e) {
			GateKeeper.setWarning("That wasn't a valid money amount.");
			return false;
		}
		
		if(myAmount < 0) {
			GateKeeper.setWarning("Can't request negative money.");
			return false;
		}
		
		Request newReq = new Request(id, myAmount, description);
		RequestDaoImpl rdi = new RequestDaoImpl();
		rdi.createRequest(newReq);
		GateKeeper.setWarning("Request successfully sent");
		return true;
	}
}
