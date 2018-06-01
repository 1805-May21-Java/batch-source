package com.revature.errors;

public class InvalidLoginException extends Throwable
{

	public InvalidLoginException()
	{
		super();
	}

	public InvalidLoginException(String message)
	{
		super(message);
	}

}
