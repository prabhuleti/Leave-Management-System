package com.sutherland.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PublicHolidays {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column
	private LocalDate date;
	@Column
	private String holidayDetails;
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getHolidayDetails() {
		return holidayDetails;
	}
	public void setHolidayDetails(String holidayDetails) {
		this.holidayDetails = holidayDetails;
	}
}
