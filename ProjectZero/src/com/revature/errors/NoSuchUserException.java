package com.revature.errors;

public class NoSuchUserException extends Throwable
{

	public NoSuchUserException()
	{
		super();
	}

	public NoSuchUserException(String message)
	{
		super(message);
	}

}
