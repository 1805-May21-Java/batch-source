package com.revature.beans;

import org.springframework.stereotype.*;

@Component
public class Calculator
{
	private int result;
	public Calculator()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString()
	{
		return "Calculator [result=" + result + "]";
	}

	public int add(int x, int y)
	{
		result = x+y;
		return result;
	}
	
	public int subtract(int x, int y)
	{
		result = x-y;
		return result;
	}
	public int multiply(int x, int y)
	{
		result = x*y;
		return result;
	}
	public int divide(int x, int y)
	{
		result = x/y;
		return result;
	}
}
