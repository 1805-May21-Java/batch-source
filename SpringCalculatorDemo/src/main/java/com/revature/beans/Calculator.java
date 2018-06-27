package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	private Integer x = 0;
	private Integer y = 0;
	
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public int add() {
		int result = this.x + this.y;
		return result;
	}
	
	public int subtract() {
		int result = this.x - this.y;
		return result;
	}
	
	public int multiplication() {
		int result = this.x * this.y;
		return result;
	}
	
	public int division() throws Exception{
		int result = this.x / this.y;
		return result;
	}

}
