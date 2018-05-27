package com.adora.palindromes8;

import java.util.ArrayList;
import java.util.Iterator;

public class PalindromesList {

	public static void main(String[] args) {
		String[] strArray = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		ArrayList<String> strList = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String s: strArray) {
			strList.add(s);
		}
		
		Iterator<String> it = strList.iterator();
		
		while(it.hasNext()) {
			String str = it.next();
			StringBuilder strB = new StringBuilder(str);
			String strReverse = strB.reverse().toString();
			
			if(str.compareTo(strReverse) == 0 ) {
				palindromes.add(strReverse);
			}
		}
		
		System.out.println(palindromes.toString());
		
		
	}

}
