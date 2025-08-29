package com.sutherland.lms.exceptions;

@SuppressWarnings("serial")
public class NoLeavesFoundException extends RuntimeException {
	public NoLeavesFoundException(String mesg) {
		super(mesg);
	}

}
