package com.aec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.aec.model.UserDtls;
import com.aec.repository.UserRepository;
import com.aec.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDtls saveUser(UserDtls user) {

		user.setRole("ROLE_USER");

		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		UserDtls saveUser = userRepository.save(user);
		return saveUser;
	}

}
