package com.sutherland.lms.service;

import com.sutherland.lms.entity.Login;

public interface LoginService {
	void addUser(Login user);
	Login validateLogin(String empId, String password) ;

}
