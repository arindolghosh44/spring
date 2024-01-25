package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.entity.User;

public interface UserRepo  extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
	public User findByVerificationCode(String code);
	
}
