package com.registration.web.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.registration.web.model.User;
import com.registration.web.model.UserStatus;
import com.registration.web.service.LoginService;
import com.registration.web.service.UserStatusService;

@CrossOrigin
@RestController
public class LogoutController {

	@Autowired
	private LoginService service;

	@Autowired
	private UserStatusService userStatusService;

	@PostMapping("/logout/{emailId}")
	public void loginUser(@PathVariable String emailId) {

		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);

		userStatusService.updateStatus(emailId, "offline", ts);

	}

	@GetMapping("/onlineUsers/{emailId}")
	public List<User> fetchAllOnlineUsers(@PathVariable String emailId) {

		List<User> onlineUsers = null;
		onlineUsers = userStatusService.fetchAllStatus("online", emailId);
		return onlineUsers;

	}

}
