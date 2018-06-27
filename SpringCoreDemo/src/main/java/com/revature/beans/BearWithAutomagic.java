package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BearWithAutomagic extends Bear{
	
	private int id;
	private String name;
	
	// can put @Autowired over a property, a setter, or a constructor
	@Autowired
	private Cave cave;

	@Override
	public String toString() {
		return "BearWithAutomagic [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}
	
	@Override
	public void methodInBear() {
		System.out.println("method in BearWithAutomagic. this bear is: "+toString());
	}
	

}
