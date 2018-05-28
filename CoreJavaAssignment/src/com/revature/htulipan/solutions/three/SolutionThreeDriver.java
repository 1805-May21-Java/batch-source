package com.revature.htulipan.solutions.three;

/*
 * Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */

public class SolutionThreeDriver {

	// Yes it's ridiculous, but so are the restrictions
	public static void main(String[] args) {
		String revIt = "reverse this string";
		
		System.out.println("The original String: " + revIt);
		
		// Append to the string each one-character\-long substring starting at the end and working to the start
		// Do For-Loop variables count as temporaries?
		for (int i = 0, length = revIt.length(); i < length; i++) {
			revIt = revIt.concat(revIt.substring(length-i-1, length-i));
		}
		
		// Cut the now-mirrored string in half and Voila!
		revIt = revIt.substring(revIt.length() / 2);
		
		System.out.println("The reversed String: " + revIt);
	}

}
