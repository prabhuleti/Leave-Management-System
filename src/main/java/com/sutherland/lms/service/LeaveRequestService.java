package com.sutherland.lms.service;

import java.util.List;

import com.sutherland.lms.dto.LeaveRequestDto;
import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.exceptions.BadRequestException;
import com.sutherland.lms.exceptions.DateRequiredException;
import com.sutherland.lms.exceptions.EmployeeNotFoundException;
import com.sutherland.lms.exceptions.LeaveRequestNotFoundException;

import com.sutherland.lms.exceptions.ManagerNotAssignedException;
import com.sutherland.lms.exceptions.NoLeavesFoundException;
import com.sutherland.lms.exceptions.RemarksNeededForRejectionException;

public interface LeaveRequestService {
	void applyLeave(LeaveRequestDto leaveRequest) throws EmployeeNotFoundException,ManagerNotAssignedException, DateRequiredException;
	LeaveRequest verifyLeave(long id,String action,String remarks) throws LeaveRequestNotFoundException,BadRequestException,RemarksNeededForRejectionException;
	LeaveRequest cancelLeave(long id)throws LeaveRequestNotFoundException,BadRequestException;
	LeaveRequest withdrawLeave(long id)throws LeaveRequestNotFoundException,BadRequestException;
	LeaveRequest checkLeaveRequestStatus(long id)throws LeaveRequestNotFoundException;
	List<LeaveRequest> getLeaveRequestByEmpId(String empID)throws  EmployeeNotFoundException,NoLeavesFoundException;
}
