package com.college.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.entity.User;
import com.college.service.UserService;

@RestController
public class CollegeDataController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveUserInfo")
	public ResponseEntity<User> saveUserInfo(@RequestBody User user, HttpServletRequest httpServletRequest) {
		return new ResponseEntity<User>(userService.saveUserInfo(user, httpServletRequest), HttpStatus.CREATED);
	}
	
	@PostMapping("/sendMail")
	public ResponseEntity<User> sendMail(@RequestBody User user, HttpServletRequest httpServletRequest) {
		return new ResponseEntity<User>(userService.sendMail(user, httpServletRequest), HttpStatus.OK);
	}

}
