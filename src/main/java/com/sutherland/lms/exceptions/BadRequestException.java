package com.sutherland.lms.exceptions;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {
	public BadRequestException(String mesg) {
		super(mesg);
	}

}
