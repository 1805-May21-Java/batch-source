package com.adora.getFloats11;

import com.adora.hasfloats11.HasFloats;

public class GetFloats {

	public static void main(String[] args) {
		HasFloats hasFloats = new HasFloats();
		
		float float1 = hasFloats.getFloatOne();
		float float2 = hasFloats.getFloatTwo();
		
		System.out.println("float 1: " + float1 + " floatTwo: " + float2);

	}

}
