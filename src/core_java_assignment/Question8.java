package core_java_assignment;

import java.util.ArrayList;

public class Question8 {
	private ArrayList<String> palindromeList = new ArrayList();
	private StringBuffer reverseString;
	public ArrayList<String> palindrome(ArrayList<String> list){
		palindromeList.clear();
		for(String string:list){
			if(reverseString(string).toLowerCase().equals(string.toLowerCase())){
				palindromeList.add(string);
			}
		}
		return palindromeList;
		
	}
	public String reverseString(String string){
		reverseString = new StringBuffer(string);
		return reverseString.reverse().toString();
	}
}
