package com.revature.hw2;

public class q18p2 extends q18abst{

	public boolean upperCheck(String string) {
		// TODO Auto-generated method stub
		boolean hasUpCase = false;
		char[] mine = string.toCharArray();
		
		for(int x = 0; x < mine[x] - 1 ;x++) {
			if(Character.isUpperCase(mine[x])) {
				hasUpCase = true;
				break;
			}
		}
		return hasUpCase;
	}

	public String lowerConvert(String string) {
		// TODO Auto-generated method stub
		string = string.toLowerCase();
		return string;
	}

	public int intConverter(String string) {
		// TODO Auto-generated method stub
		int x = Integer.parseInt(string) + 10;
		return x;
	}
}