package com.revature.pojos;

//Interface AccountActions is used to ensure users will be able to carry
//out requested actions. Methods logOn() and logOff() will be used to
//allow users to access their account.
public interface AccountActions {
	
	public void depositFunds(double amount, String checkingOrSavings);
	
	public void withDrawFunds(double amount, String checkingOrSavings);
	
	public void viewBalance();
	
	public void logOn();
	
	public void logOff();

	

}
