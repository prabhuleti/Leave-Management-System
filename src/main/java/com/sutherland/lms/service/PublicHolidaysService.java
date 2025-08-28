package com.sutherland.lms.service;

import java.util.List;

import com.sutherland.lms.entity.PublicHolidays;

public interface PublicHolidaysService {
	PublicHolidays addHolidayDetails(PublicHolidays holidays);
	List<PublicHolidays> viewHolidayList();
}
