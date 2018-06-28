package com.revature.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cave {

	@Value("12")
	private Integer id;
	
	@Value("Loray Caverns")
	private String name;

	public Cave() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
