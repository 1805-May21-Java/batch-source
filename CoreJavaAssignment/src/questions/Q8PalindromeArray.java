package questions;

//Program contains a method called getPalindrome(ArrayList<String> arrList)
//which takes in an ArrayList of Strings and returns a new ArrayList
//containing only String that are palindromes.
import java.util.ArrayList;
import java.util.Arrays;

public class Q8PalindromeArray {
	
	public ArrayList<String> getPalindrome(ArrayList<String> arrList) {
		//palindromeList will be used to add palindrome Strings
		ArrayList<String> palindromeList = new ArrayList<String>();
		//temp is used to compare for palindromes, since it 
		//has a built in .reverse function and is Mutable.
		StringBuilder temp;
		for(String str : arrList) {
			//temp stores str value and reverses it
			temp = new StringBuilder(str);
			temp.reverse();
			//if the statement below is true
			//str is a palindrom and added to palindromList
			if(temp.toString().equals(str)) {
				palindromeList.add(str);
			}
		}
		//palindromeList now contains all available palindromes and returns.
		return palindromeList;
	}
}
