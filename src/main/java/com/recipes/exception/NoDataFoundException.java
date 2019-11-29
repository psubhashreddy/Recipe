package com.recipes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDataFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String message) {
		super(message);
	}
	
	public NoDataFoundException(String message, Throwable t) {
		super(message, t);
	}
}
