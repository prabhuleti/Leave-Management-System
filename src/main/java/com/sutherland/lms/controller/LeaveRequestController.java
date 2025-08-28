package com.sutherland.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.service.LeaveRequestService;

@RestController
@RequestMapping("/leaverequest")
public class LeaveRequestController {
	@Autowired
	LeaveRequestService service;
	@PostMapping("/applyleaverequest ")
	public ResponseEntity<String> applyLeave(@RequestBody LeaveRequest leaveRequest){
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@GetMapping("/verifyleaverequest/{id}")
	public ResponseEntity<LeaveRequest> verifyLeave(@PathVariable long id,@PathVariable String managerId,@PathVariable String action,@PathVariable String remarks){
		LeaveRequest mesg = service.verifyLeave(id,managerId,action,remarks);
		return new ResponseEntity<LeaveRequest>(mesg,HttpStatus.OK);
	}
	@GetMapping("/checkleaverequeststatus/{id}")
	public ResponseEntity<Optional<LeaveRequest>> checkLeaveRequestStatus(@PathVariable long id) {
	   return new ResponseEntity<Optional<LeaveRequest>>(service.checkLeaveRequestStatus(id),HttpStatus.OK);		   
	}
    @PostMapping("/canceleave")
    public ResponseEntity<LeaveRequest> cancelLeave(@RequestBody long id,@RequestBody String empId){
       	LeaveRequest lr = service.cancelLeave(id,empId);
       	return new ResponseEntity<LeaveRequest>(lr,HttpStatus.OK);
    }
    @PostMapping("/withdrawleave")
    public ResponseEntity<LeaveRequest> withdrawLeave(@RequestBody long id,@RequestBody String empId){
       	LeaveRequest leave = service.withdrawLeave(id,empId);
       	return new ResponseEntity<LeaveRequest>(leave,HttpStatus.OK);
    }
    @GetMapping("/viewleavehistory/{empId}")
    public ResponseEntity<List<LeaveRequest>> getAllLeavesByEmployee(){
    	return new ResponseEntity<List<LeaveRequest>>(service.getAllLeavesByEmployee(),HttpStatus.OK);
    }
}
