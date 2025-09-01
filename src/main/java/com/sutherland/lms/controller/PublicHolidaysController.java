package com.sutherland.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sutherland.lms.entity.PublicHolidays;
import com.sutherland.lms.service.PublicHolidaysService;

@RestController
@RequestMapping("/publicholidays")
@CrossOrigin(origins = "http://localhost:3000")
public class PublicHolidaysController {
	@Autowired
	PublicHolidaysService service;
	@PostMapping("/addholidaydetails")
    public ResponseEntity<PublicHolidays> addHolidayDetails(@RequestBody PublicHolidays holidays){
		PublicHolidays holiday= service.addHolidayDetails(holidays);
		return new ResponseEntity<PublicHolidays>(holiday,HttpStatus.OK);
	}
	@GetMapping("/viewholidaylist")
	public ResponseEntity<List<PublicHolidays>> viewHolidayDetails(){
		return new ResponseEntity<List<PublicHolidays>>(service.viewHolidayList(), HttpStatus.OK);		
	}
}
