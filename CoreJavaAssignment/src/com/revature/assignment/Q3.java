package com.revature.assignment;

public class Q3 {

	//Q3. Reverse a string without using a temporary variable.  
	//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	
	
	String revature = "Revature!";
	//Loop takes character by character substring and reverses String
	public void reverse() {
	for (int i = 0; i < revature.length(); i++) {
	    revature = revature.substring(1, revature.length() - i)
	        + revature.substring(0, 1)
	        + revature.substring(revature.length() - i, revature.length());
	 } System.out.println(revature);
	}
}

		//Driver code
		//Q3 q = new Q3();
		//q.reverse();