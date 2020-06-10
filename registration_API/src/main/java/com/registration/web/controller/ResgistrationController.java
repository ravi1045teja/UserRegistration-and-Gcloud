package com.registration.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.registration.web.model.User;
import com.registration.web.service.RegistrationService;

@CrossOrigin
@RestController
public class ResgistrationController {

	@Autowired
	private RegistrationService service;

	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) throws Exception {

		String tempEmailId = user.getEmailId();

		if (tempEmailId != null && !"".equals(tempEmailId)) {

			User userObjUser = service.fetchUserByEmailId(tempEmailId);
			if (userObjUser != null) {

				throw new Exception("User already exists");
			}

		}

		User userObjUser = null;
		userObjUser = service.saveUser(user);
		return userObjUser;

	}

}
