package com.registration.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.registration.web.model.User;
import com.registration.web.model.UserStatus;
import com.registration.web.service.LoginService;
import com.registration.web.service.UserStatusService;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@Autowired
	private UserStatusService userStatusService;

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {

		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userObjUser = null;
		if (tempEmailId != null && tempPassword != null) {

			userObjUser = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if (userObjUser == null) {

			throw new Exception("Bad Credentials");
		}

		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);

		UserStatus statusObj = userStatusService.fetchUserByEmailId(tempEmailId);
		if (statusObj == null) {

			UserStatus sUserStatus = new UserStatus();
			sUserStatus.setEmailId(tempEmailId);
			sUserStatus.setStatus("online");
			sUserStatus.setTimestamp(ts);

			userStatusService.saveUserStatus(sUserStatus);
		} else {

			userStatusService.updateStatus(tempEmailId, "online", ts);
		}

		return userObjUser;

	}

}
