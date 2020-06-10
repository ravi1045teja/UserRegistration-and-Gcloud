package com.registration.web.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.registration.web.model.UserStatus;

public interface StatusRepository extends JpaRepository<UserStatus, Integer> {

	public UserStatus findByEmailId(String emailId);

	@Modifying
	@Transactional
	@Query("UPDATE UserStatus u SET u.status= :status, u.timestamp= :timeStamp WHERE u.emailId= :emailId")
	int updateStaus(@Param("emailId") String emailId, @Param("status") String status,
			@Param("timeStamp") Timestamp timeStamp);

	public List<UserStatus> findAllByStatus(String status);

}
