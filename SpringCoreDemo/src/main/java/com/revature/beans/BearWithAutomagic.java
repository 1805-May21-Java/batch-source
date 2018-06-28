package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BearWithAutomagic {
	
	private int id;
	private String name;
	
	@Autowired
	private Cave cave;
	
	@Override
	public void methodInBear() {
		System.out.println();
	}

}
