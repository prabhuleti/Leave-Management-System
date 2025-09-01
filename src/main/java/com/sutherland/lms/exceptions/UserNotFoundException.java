package com.sutherland.lms.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
		super("employee not found");
	}

}
