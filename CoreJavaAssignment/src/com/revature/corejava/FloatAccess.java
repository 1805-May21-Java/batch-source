package com.revature.corejava;

import com.revature.other.OtherStuff;

//Q11
public class FloatAccess {

	public static void main(String[] args) {
		OtherStuff otherStuff = new OtherStuff();  //OtherStuff class is in another package
		otherStuff.setNum1(32.25f);//Cannot access variables directly, must use getters and setters
		otherStuff.setNum2(984.52f);
		System.out.println("Num 1: "+otherStuff.getNum1());
		System.out.println("Num 2: "+otherStuff.getNum2());
		

	}

}
