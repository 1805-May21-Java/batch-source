package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public String add(int one, int two) {
		return one+"+"+two+"="+(one+two);
		 
	}
	
	public String sub(int one, int two) {
		return one+"-"+two+"="+(one-two);
	}
	
	public String mul(int one, int two) {
		return one+"*"+two+"="+(one*two);
	}
	
	public String div(int one, int two) {
		return one+"/"+two+"="+(one/two);
	}
	
}
