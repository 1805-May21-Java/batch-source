package core.revature.assignment;

import java.util.ArrayList;

//Q8. Write a program that stores the following strings in an ArrayList
//and saves all the palindromes in another ArrayList.
//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
public class Q8 {
	public static boolean checkPalindrome(String str) { //function for checking palindrome
		return str.equals(new StringBuilder(str).reverse().toString());
	}
	public static void main(String[] args) {
		/*
		 * madam, civic, radar, kayak, refer, and did are the palindromes
		 */
		ArrayList<String> stringList = new ArrayList<String>(); //two ArrayLists
		ArrayList<String> palindromeList = new ArrayList<String>();
		stringList.add("karan"); // not palindrome
		stringList.add("madam"); // palindrome
		stringList.add("tom");   // not palindrome
		stringList.add("civic"); // palindrome
		stringList.add("radar"); // palindrome
		stringList.add("jimmy"); // not palindrome
		stringList.add("kayak"); // palindrome
		stringList.add("john");  // not palindrome
		stringList.add("refer"); // palindrome
		stringList.add("billy"); // not palindrome
		stringList.add("did");   // palindrome
		System.out.println("Strings in ArrayList:");
		for (int i = 0; i < stringList.size(); i++) {
			System.out.println(stringList.get(i)); //display first ArrayList
			boolean pal = checkPalindrome(stringList.get(i)); // call checkPalindrome
			//System.out.println(pal);
			if(pal == true) {
				palindromeList.add(stringList.get(i)); // add palindrome from first ArrayList if pal = true
			}
		}
		System.out.println();
		System.out.println("Strings that are palindromes:");
		for (int i = 0; i < palindromeList.size(); i++) {
			System.out.println(palindromeList.get(i)); // display palindrome ArrayList
		}
	}
}
