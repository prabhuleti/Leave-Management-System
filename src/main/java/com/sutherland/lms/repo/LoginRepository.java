package com.sutherland.lms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sutherland.lms.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{
	Optional<Login> findByEmpIdAndPassword(String empId, String password);

}
