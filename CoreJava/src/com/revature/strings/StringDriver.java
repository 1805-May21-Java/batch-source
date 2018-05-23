package com.revature.strings;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class StringDriver {

	public static void main(String[] args) {
	
		//////////////STRINGS///////////////
		
		String string1 = "I'm a string!";
		String string2 = "I'm a string!";
		
		/* two strings with the same value reference the same hashcode */
//		System.out.println("string1 hashcode: "+string1.hashCode());
//		System.out.println("string2 hashcode: "+string2.hashCode());
//		System.out.println("objects are equal: "+string1.equals(string2));

		/* modifying a string's value will reference a new object */
//		String alsoString1 = string1;
//		string1 = string1 + "!";
//		System.out.println(string1);
//		System.out.println(alsoString1);
//		/* this is reflected by a new hashcode */
//		System.out.println("string1 hashcode: "+alsoString1.hashCode());
//		System.out.println("string2 hashcode: "+string1.hashCode());
//		/* also by comparing it to a variable referencing the same original object */
//		System.out.println("objects are equal: "+string1.equals(string2));

		
		//////////////STRINGBUILDERS///////////////
		
		StringBuilder stringBuilder1 = new StringBuilder("I'm a string builder object!");
		StringBuilder stringBuilder2 = new StringBuilder("I'm a string builder object!");
		
		/* two different StringBuilders have different hashcodes, regardless of their value */
//		System.out.println("stringBuilder1 hashcode: "+stringBuilder1.hashCode());
//		System.out.println("stringBuilder2 hashcode: "+stringBuilder2.hashCode());
//		System.out.println("objects are equal: "+stringBuilder1.equals(stringBuilder2));
//	
//		System.out.println();
//		/* when converted into Strings, they again will refer to the same String in the string pool */
//		System.out.println("string1 hashcode: "+stringBuilder1.toString().hashCode());
//		System.out.println("string2 hashcode: "+stringBuilder2.toString().hashCode());
//		System.out.println("objects are equal: "+stringBuilder1.toString().equals(stringBuilder2.toString()));

		/* modifying a StringBuilder's value will modify the object being referenced */
		StringBuilder alsoStringBuilder1 = stringBuilder1;
		System.out.println("stringBuilder1: "+stringBuilder1);
		System.out.println("stringBuilder1 hashcode: "+stringBuilder1.hashCode());
		stringBuilder1 = stringBuilder1.append("!");
		/* this is reflected by showing the same hashcode */
		System.out.println("stringBuilder1 after mutating: "+alsoStringBuilder1);
		System.out.println("alsoStringBuilder1 hashcode after mutating: "+alsoStringBuilder1.hashCode());
		/* also by comparing it to a variable referencing the same original object */
		System.out.println("objects are equal: "+stringBuilder1.equals(alsoStringBuilder1));
		
	}

}
