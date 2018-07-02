package com.Revature.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="That tree has been killed by Climate Change")
public class TreeNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TreeNotFound() {
		super();
	}
	
}
