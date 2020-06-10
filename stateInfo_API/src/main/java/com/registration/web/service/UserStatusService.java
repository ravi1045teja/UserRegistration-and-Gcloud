package com.registration.web.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.web.model.User;
import com.registration.web.model.UserStatus;
import com.registration.web.repository.LogoutRepository;
import com.registration.web.repository.StatusRepository;

@Service
public class UserStatusService {

	@Autowired
	private LogoutRepository logoutRepository;

	@Autowired
	private StatusRepository statusRepository;

	public UserStatus fetchUserByEmailId(String email) {

		return statusRepository.findByEmailId(email);
	}

	public UserStatus saveUserStatus(UserStatus userStatus) {

		return statusRepository.save(userStatus);
	}

	public int updateStatus(String tempEmailId, String status, Timestamp ts) {

		return statusRepository.updateStaus(tempEmailId, status, ts);
	}

	@SuppressWarnings("null")
	public List<User> fetchAllStatus(String status, String emailId) {

		List<User> userList = new ArrayList<User>();
		List<UserStatus> userStatusList = statusRepository.findAllByStatus(status);

		System.out.println(userStatusList.size());

		for (UserStatus userStatus : userStatusList) {

			User user = logoutRepository.findByEmailId(userStatus.getEmailId());

			if (!user.getEmailId().equals(emailId)) {
				userList.add(user);
			}

		}

		return userList;

	}

}
