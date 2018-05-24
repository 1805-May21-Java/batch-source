package com.revature.algorithms;

public class QuestionEighteen extends AbstractExample {

	public QuestionEighteen() {
		super();
	}

	// implementations of abstract methods from AbstractExample
	@Override
	boolean checkUppercase(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i)))
				return true;
		}
		return false;
	}

	@Override
	String lowerToUpper(String str) {
		StringBuffer newStr = new StringBuffer(str);
		
		for(int i = 0; i < newStr.length(); i++) {
			if(Character.isLowerCase(newStr.charAt(i)))
				newStr.setCharAt(i, Character.toUpperCase(newStr.charAt(i)));
		}
		
		return newStr.toString();
	}

	@Override
	int addTen(String str) {
		int addTen = Integer.parseInt(str);
		addTen += 10;
		return addTen;
	}

}
