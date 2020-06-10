package com.registration.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.web.model.User;
import com.registration.web.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repository;

	public User saveUser(User user) {

		return repository.save(user);

	}

	public User fetchUserByEmailId(String email) {

		return repository.findByEmailId(email);
	}

}
