package com.registration.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.web.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String emailId);

}
