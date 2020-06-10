package com.registration.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.web.model.User;
import com.registration.web.repository.LogoutRepository;

@Service
public class LoginService {

	@Autowired
	private LogoutRepository repository;

	public User fetchUserByEmailId(String email) {

		return repository.findByEmailId(email);
	}

	public User fetchUserByEmailIdAndPassword(String emailId, String password) {

		return repository.findByEmailIdAndPassword(emailId, password);

	}

}
