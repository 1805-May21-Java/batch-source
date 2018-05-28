package com.revature.assignment;

public class Q13 {

	//Q13. Display the triangle on the console as follows using any type of loop.  
	//Do NOT use a simple group of print statements to accomplish this.
    /*0
    1 0
    0 1 0
    1 0 1 0*/
	
	String s = "";
	
	//Used for loop to alternate (even/odd numbers w/ modulus and ternary operator) between adding 1s and 0s to each new line
	public void triangle() {
		for(int i = 0 ; i < 4 ; i++) {
		    s = (i % 2 == 0 ? "1" : "0") + s;
		    System.out.println(s); 
		}
	}
		//	Driver Code
		//	Q13 q = new Q13();
		//	q.triangle();

}
