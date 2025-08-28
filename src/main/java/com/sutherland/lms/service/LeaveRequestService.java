package com.sutherland.lms.service;

import java.util.List;
import java.util.Optional;

import com.sutherland.lms.entity.LeaveRequest;

public interface LeaveRequestService {
	public int applyLeave(LeaveRequest leaveRequest);
	LeaveRequest verifyLeave(long id,String mangerId,String action,String remarks);
	LeaveRequest cancelLeave(long id,String empId);
	LeaveRequest withdrawLeave(long id,String empId);
	Optional<LeaveRequest> checkLeaveRequestStatus(long id);
	List<LeaveRequest> getAllLeavesByEmployee();
}
