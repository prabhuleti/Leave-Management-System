package com.sutherland.lms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.repo.LeaveRequestRepository;

@Service
public class LeaveRequestServiceImplementation implements LeaveRequestService{
	@Autowired
	LeaveRequestRepository repo;

	@Override
	public int applyLeave(LeaveRequest leaveRequest) {
//		number of days should be added 
//		exceptions
		leaveRequest.setDateApplied(LocalDate.now());
		leaveRequest.setLeaveStatus("APPLIED");
		repo.save(leaveRequest);
		return leaveRequest.getId();	
	}

	@Override
	public LeaveRequest verifyLeave(long id, String mangerId, String action, String remarks) {
		Optional<LeaveRequest> optional=repo.findById(id);
		LeaveRequest leaveRequest=optional.get();
		leaveRequest.setLeaveStatus(action);
		leaveRequest.setRemarks(remarks);
		return repo.save(leaveRequest);
	}

	@Override
	public LeaveRequest cancelLeave(long id, String empId) {
		Optional<LeaveRequest> optional=repo.findById(id);
		LeaveRequest leaveRequest=optional.get();
		leaveRequest.setLeaveStatus("CANCELLED");
		return repo.save(leaveRequest);
	}

	@Override
	public LeaveRequest withdrawLeave(long id, String empId) {
		Optional<LeaveRequest> optional=repo.findById(id);
		LeaveRequest leaveRequest=optional.get();
		leaveRequest.setLeaveStatus("WITHDRAWN");
		return repo.save(leaveRequest);
	}

	@Override
	public Optional<LeaveRequest> checkLeaveRequestStatus(long id) {	
		return repo.findById(id);
	}

	@Override
	public List<LeaveRequest> getAllLeavesByEmployee() {	
		return repo.findByEmpId();
	}

}
