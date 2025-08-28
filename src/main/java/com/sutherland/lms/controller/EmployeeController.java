package com.sutherland.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@PostMapping("/addemployee")
	 public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp = service.addEmployee(employee);
        return new ResponseEntity<Employee>(emp,HttpStatus.OK);
    }
	@GetMapping("/getemployeebyid/{empId")
	 public ResponseEntity<Employee> getEmployeeById(@PathVariable String empId) {
        return new ResponseEntity<Employee>(service.getEmployeeById(empId),HttpStatus.OK);
    }
	@GetMapping("/getallemployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(service.getAllEmployees(), HttpStatus.OK);
	}
	
}
