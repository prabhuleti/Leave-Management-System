package com.sutherland.lms.exceptions;

@SuppressWarnings("serial")
public class LeaveRequestNotFoundException extends RuntimeException{
	public LeaveRequestNotFoundException(String mesg) {
		super(mesg);
	}

}
