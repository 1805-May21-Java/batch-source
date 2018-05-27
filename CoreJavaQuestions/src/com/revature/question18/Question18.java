package com.revature.question18;

public class Question18 extends Question18Superclass {

	public Question18() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean anyUpperCase(String s) {
	    StringBuffer buff = new StringBuffer();
	    for(int x = 0; x < s.length(); x++) {
	      char c = s.charAt(x);
	      if(Character.isUpperCase(c)) {
	    	  System.out.println("true");
	    	  return true;
	      }
	    }
	    System.out.println("false");
	    return false;
	}

	@Override
	public String toLowerCase(String s) {
		System.out.println(s.toLowerCase());
		return s.toLowerCase();
	}

	@Override
	public int convertAdd10(String s) {
		System.out.println(Integer.parseInt(s)+10);
		return Integer.parseInt(s)+10;
	}

}
