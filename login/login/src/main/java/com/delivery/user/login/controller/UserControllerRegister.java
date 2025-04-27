package com.delivery.user.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.user.login.entity.User;
import com.delivery.user.login.service.UserRegister;

@RestController
public class UserControllerRegister
{
	@Autowired
	UserRegister registration ;
	
	@PostMapping("/register")
	public ResponseEntity<?> register( @RequestBody User dto)
	{
	        return ResponseEntity.ok(registration.register(dto));
	   
	}

}
