package com.sutherland.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutherland.lms.entity.PublicHolidays;
import com.sutherland.lms.repo.PublicHolidaysRepository;

@Service
public class PublicHolidaysServiceImplementation implements PublicHolidaysService{
	@Autowired
	PublicHolidaysRepository repo;

	@Override
	public PublicHolidays addHolidayDetails(PublicHolidays holidays) {	
		return repo.save(holidays);
	}

	@Override
	public List<PublicHolidays> viewHolidayList() {	
		return repo.findAll();
	}

}
