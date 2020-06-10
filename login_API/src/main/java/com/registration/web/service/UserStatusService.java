package com.registration.web.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.web.model.UserStatus;
import com.registration.web.repository.StatusRepository;

@Service
public class UserStatusService {

	@Autowired
	private StatusRepository statusRepository;

	public UserStatus fetchUserByEmailId(String email) {

		return statusRepository.findByEmailId(email);
	}

	public UserStatus saveUserStatus(UserStatus userStatus) {

		return statusRepository.save(userStatus);
	}

	public int updateStatus(String tempEmailId, String status, Timestamp ts) {
		// TODO Auto-generated method stub
		return statusRepository.updateStaus(tempEmailId, status, ts);
	}

}
