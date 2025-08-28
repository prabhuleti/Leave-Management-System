package com.sutherland.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sutherland.lms.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
