package com.sutherland.lms.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutherland.lms.dto.LeaveRequestDto;
import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.exceptions.BadRequestException;
import com.sutherland.lms.exceptions.DateRequiredException;
import com.sutherland.lms.exceptions.EmployeeNotFoundException;
import com.sutherland.lms.exceptions.LeaveRequestNotFoundException;
import com.sutherland.lms.exceptions.ManagerNotAssignedException;
import com.sutherland.lms.exceptions.NoLeavesFoundException;
import com.sutherland.lms.exceptions.RemarksNeededForRejectionException;
import com.sutherland.lms.repo.EmployeeRepository;
import com.sutherland.lms.repo.LeaveRequestRepository;

@Service
public class LeaveRequestServiceImplementation implements LeaveRequestService{
	@Autowired
	LeaveRequestRepository repo;
	@Autowired
	EmployeeRepository rep;

	@Override
	public void applyLeave(LeaveRequestDto leaveRequestDto) {	
		if(!rep.existsByEmpId(leaveRequestDto.getEmpId())) {
			throw new EmployeeNotFoundException("employee not found");
		}
		Employee emp=rep.findById(leaveRequestDto.getEmpId()).get();
		String managerId=emp.getManagerId();
		if(managerId==null || managerId.isBlank()) {
			throw new ManagerNotAssignedException("Manager not assigned");
		}
		leaveRequestDto.setManagerId(managerId);
		if(leaveRequestDto.getFromDate()==null|| leaveRequestDto.getToDate()==null) {
			throw new DateRequiredException("Both fromdate and todate is required");
		}
		long numberOfDays = ChronoUnit.DAYS.between(leaveRequestDto.getFromDate(), leaveRequestDto.getToDate()) + 1;
		LeaveRequest leaveRequest = new LeaveRequest();
		leaveRequest.setEmpId(emp);
	    leaveRequest.setManagerId(emp.getManagerId());
	    leaveRequest.setFromDate(leaveRequestDto.getFromDate());
	    leaveRequest.setToDate(leaveRequestDto.getToDate());
	    leaveRequest.setLeaveType(leaveRequestDto.getLeaveType());
	        
	    leaveRequest.setNumberOfDays((int) numberOfDays);
	    leaveRequest.setDateApplied(LocalDate.now());
	    leaveRequest.setLeaveStatus("APPLIED");	
		repo.save(leaveRequest);
			
	}

	@Override
	public LeaveRequest verifyLeave(long id, String action, String remarks) {
		Optional<LeaveRequest> optional=repo.findById(id);
		if(!optional.isPresent()) {
			throw new LeaveRequestNotFoundException("leave request not found with id");
		}
		LeaveRequest leaveRequest=optional.get();
		if(!"APPLIED".equalsIgnoreCase(leaveRequest.getLeaveStatus())) {
			throw new BadRequestException("only applied leave requests can be verified");
		}
		String takeAction=action.trim().toUpperCase();
		if("APPROVE".equals(takeAction)) {
			leaveRequest.setLeaveStatus("APPROVED");
			leaveRequest.setRemarks(remarks != null && !remarks.isBlank() ? remarks:"Approved by manager");
		}else if("REJECT".equals(takeAction)) {
			if(remarks==null || remarks.isBlank()) {
				throw new RemarksNeededForRejectionException("reason for rejection");
			}
			leaveRequest.setLeaveStatus("REJECTED");
		}else {
			throw new BadRequestException("invalid action:"+ action);
		}
		return repo.save(leaveRequest);
	}

	@Override
	public LeaveRequest cancelLeave(long id) {
		Optional<LeaveRequest> optional=repo.findById(id);
		if(!optional.isPresent()) {
			throw new LeaveRequestNotFoundException("leave request not found");
		}
		LeaveRequest leaveRequest=optional.get();
		if(!"APPROVED".equalsIgnoreCase(leaveRequest.getLeaveStatus())) {
			throw new BadRequestException("only approved leave requests can be cancelled");
		}
		leaveRequest.setLeaveStatus("CANCELLED");
		return repo.save(leaveRequest);
	}

	@Override
	public LeaveRequest withdrawLeave(long id) {
		Optional<LeaveRequest> optional=repo.findById(id);
		if(!optional.isPresent()) {
			throw new LeaveRequestNotFoundException("leave request not found");
		}
		LeaveRequest leaveRequest=optional.get();
		if(!"APPLIED".equalsIgnoreCase(leaveRequest.getLeaveStatus())) {
			throw new BadRequestException("only applied leave requests can be withdrawn");
		}
		leaveRequest.setLeaveStatus("WITHDRAWN");
		return repo.save(leaveRequest);
	}

	@Override
	public LeaveRequest checkLeaveRequestStatus(long id) {
		Optional<LeaveRequest> optional=repo.findById(id);
		if(!optional.isPresent()) {
			throw new LeaveRequestNotFoundException("leave request not found");
		}
		
		return optional.get();
	}


	@Override
	public List<LeaveRequest>getLeaveRequestByEmpId(String empId) {
		 return repo.findByEmployee_EmpId(empId);
	}

}
