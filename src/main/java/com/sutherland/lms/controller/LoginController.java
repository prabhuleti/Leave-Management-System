package com.sutherland.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sutherland.lms.entity.Login;
import com.sutherland.lms.service.LoginService;

@RestController
@RequestMapping("/loginemp")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	@Autowired
	LoginService service;
	@PostMapping("/validate")
	public ResponseEntity<Login> validateLogin(@RequestParam String empId,@RequestParam String password) {
		Login login=service.validateLogin(empId, password);
		return ResponseEntity.ok(login);
	}
	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody Login user) {
		service.addUser(user);
		return new ResponseEntity<String>("user created... ",HttpStatus.OK);
	}
	@GetMapping("/logout")
	public String logout() {
	
		return "Session invalidated";
	}
	

}
