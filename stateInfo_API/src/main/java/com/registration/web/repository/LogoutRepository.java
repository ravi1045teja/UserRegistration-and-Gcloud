package com.registration.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.web.model.User;

public interface LogoutRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String emailId);

	public User findByEmailIdAndPassword(String emailId, String password);

}
