<<<<<<< HEAD
package com.revature.q8;

public class ReversedString {
	
	public String reverseString(String inputString) {
		String str = inputString;
		String reverseStr = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + str.charAt(i);
		}
		
		return reverseStr;

	}

	
}
=======
package com.revature.q8;

public class ReversedString {
	
	public String reverseString(String inputString) {
		String str = inputString;
		String reverseStr = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + str.charAt(i);
		}
		
		return reverseStr;

	}

	
}
>>>>>>> 70ec7955e736c9c2ea644fea4703f6f75b046dac
