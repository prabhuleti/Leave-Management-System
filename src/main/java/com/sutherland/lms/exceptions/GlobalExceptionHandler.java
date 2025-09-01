package com.sutherland.lms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=BadRequestException.class)
	public ResponseEntity<String> badRequest(BadRequestException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FOUND);
	}
	@ExceptionHandler(value=DateRequiredException.class)
	public ResponseEntity<String> dateRequired(DateRequiredException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FOUND);
	}
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeNotFound(EmployeeNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FOUND);
	}
	@ExceptionHandler(value=LeaveRequestNotFoundException.class)
	public ResponseEntity<String> leaveRequestNotFound(LeaveRequestNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FOUND);
	}
	@ExceptionHandler(value=ManagerNotAssignedException.class)
	public ResponseEntity<String> managerNotAssigned(ManagerNotAssignedException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FOUND);
	}
	@ExceptionHandler(value=NoLeavesFoundException.class)
	public ResponseEntity<String> noLeavesFound(NoLeavesFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FOUND);
	}
	@ExceptionHandler(value=RemarksNeededForRejectionException.class)
	public ResponseEntity<String> RemarsksNeededForRejection(RemarksNeededForRejectionException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FOUND);
	}
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<String> RemarsksNeededForRejection(UserNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.FOUND);
	}
}
