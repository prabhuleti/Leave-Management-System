package com.sutherland.lms.service;

import java.util.List;
import com.sutherland.lms.entity.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);
	Employee getEmployeeById(String empId);
	List<Employee> getAllEmployees();
}
