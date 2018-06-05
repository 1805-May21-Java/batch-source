package com.revature.core_java_assignment.Question18;

public class Question18Concrete extends Question18Abstract {

	@Override
	public boolean hasUppercase(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUppercase(String str) {
		return str.toUpperCase();
	}

	@Override
	public void convertToIntAndAdd10(String str) {
		int num = Integer.parseInt(str) + 10;
		System.out.println(num);
	}

}
