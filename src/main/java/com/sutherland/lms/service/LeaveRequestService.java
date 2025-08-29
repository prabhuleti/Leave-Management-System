package com.sutherland.lms.service;

import java.util.List;
import java.util.Optional;

import com.sutherland.lms.entity.LeaveRequest;

public interface LeaveRequestService {
	public int applyLeave(LeaveRequest leaveRequest);
	LeaveRequest verifyLeave(long id,String action,String remarks);
	LeaveRequest cancelLeave(long id);
	LeaveRequest withdrawLeave(long id);
	Optional<LeaveRequest> checkLeaveRequestStatus(long id);
	List<LeaveRequest> getAllLeaveRequest(String empID);
}
