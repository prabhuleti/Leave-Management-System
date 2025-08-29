package com.sutherland.lms.exceptions;

@SuppressWarnings("serial")
public class EmployeeNotFoundException  extends RuntimeException{
	public EmployeeNotFoundException(String mesg) {
		super(mesg);
	}

}
