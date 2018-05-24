package questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Q8PalindromeArray {
	
	public ArrayList<String> getPalindrome(ArrayList<String> arrList) {
		ArrayList<String> palindromeList = new ArrayList<String>();
		StringBuilder temp;
		for(String str : arrList) {
			temp = new StringBuilder(str);
			temp.reverse();
			if(temp.toString().equals(str)) {
				palindromeList.add(str);
			}
		}
		
		return palindromeList;
	}
}
