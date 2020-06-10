package com.registration.web.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserStatus {

	@Id
	@GeneratedValue
	private int id;
	private String emailId;
	private String status;
	private Timestamp timestamp;

	public UserStatus() {

	}

	public UserStatus(int id, String emailId, String status, Timestamp timestamp) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.status = status;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
