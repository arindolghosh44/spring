package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.becoder.entity.User;

public interface UserRepo  extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
	public User findByVerificationCode(String code);
	
	
	//custom query
	@Query("update User u set u.failedAttempt=?1 where email=?2")
	@Modifying
	public void updateFailedAttpemt(int attempt,String email);
	
}
