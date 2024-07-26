package com.josh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.josh.model.User;
import com.josh.repository.UserRepository;

@Service
//@Component
public class CustomerUserServiceImplimentation implements UserDetailsService {

	//@Autowired
	private UserRepository userRepository;

	public CustomerUserServiceImplimentation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("User Not Found With Email-" + username);
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
