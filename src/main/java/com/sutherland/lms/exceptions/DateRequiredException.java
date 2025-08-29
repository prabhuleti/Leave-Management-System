package com.sutherland.lms.exceptions;

@SuppressWarnings("serial")
public class DateRequiredException extends RuntimeException{
	public DateRequiredException(String mesg) {
		super(mesg);
	}

}
