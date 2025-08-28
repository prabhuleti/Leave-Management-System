package com.sutherland.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.repo.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	@Autowired
	EmployeeRepository repo;

	@Override
	public Employee addEmployee(Employee employee) {	
		return repo.save(employee);
	}

	@Override
	public Employee getEmployeeById(String empId) {
		Optional<Employee> employee=repo.findById(empId);
		return employee.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

}
