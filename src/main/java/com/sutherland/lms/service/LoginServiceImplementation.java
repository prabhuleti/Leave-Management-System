package com.sutherland.lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutherland.lms.entity.Login;
import com.sutherland.lms.exceptions.UserNotFoundException;
import com.sutherland.lms.repo.LoginRepository;

@Service
public class LoginServiceImplementation implements LoginService {
	@Autowired
	LoginRepository repo;
	@Override
	public Login validateLogin(String empId, String password) {
		Optional<Login> opUser= repo.findByEmpIdAndPassword(empId, password);
		if(opUser.isEmpty())
			throw new UserNotFoundException();
		return opUser.get();
	}
	@Override
	public void addUser(Login user) {
		repo.save(user);
		
	}
	

}
