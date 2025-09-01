package com.sutherland.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LeaveRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="empId", referencedColumnName = "empId")
	private Employee employee;
	@Column
	private String managerId;
	@Column(length=10)
	private LocalDate fromDate;
	@Column(length=10)
	private LocalDate toDate;
	@Column(length=20)
	private String leaveType;
	@Column(length=20)
	private long numberOfDays;
	@Column
	private LocalDate dateApplied;
	@Column
	private String leaveStatus;
	@Column
	private String remarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getEmpId() {
		return employee;
	}
	public void setEmpId(Employee empId) {
		this.employee = empId;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public long getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(long numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public LocalDate getDateApplied() {
		return dateApplied;
	}
	public void setDateApplied(LocalDate dateApplied) {
		this.dateApplied = dateApplied;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}
