package com.sutherland.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.exceptions.EmployeeNotFoundException;
import com.sutherland.lms.repo.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	@Autowired
	EmployeeRepository repo;

	@Override
	public Employee addEmployee(Employee emp) {
	        Employee employee = new Employee();
	        if ("manager".equalsIgnoreCase(emp.getJob())) {
	            employee.setManagerId(null);
	        } else {
	            if (emp.getManagerId() == null) {
	                throw new EmployeeNotFoundException("Employee must have a manager unless they are Manager role");
	            }
	            repo.findById(emp.getManagerId())
	                .orElseThrow(() -> new EmployeeNotFoundException("Manager not found..."));
	            employee.setManagerId(emp.getManagerId());
	        }

	       
		return repo.save(employee);
	}

	@Override
	public Employee getEmployeeById(String empId) {
		Optional<Employee> employee=repo.findById(empId);
		if(employee.isEmpty()) {
			throw new EmployeeNotFoundException("employee not found"); 
		}
		return employee.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

}
