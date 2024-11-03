package com.aec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aec.model.UserDtls;

public interface UserRepository  extends JpaRepository<UserDtls, Integer>{
	public UserDtls findByEmail(String email);
}
