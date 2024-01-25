package com.becoder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.becoder.entity.*;
import com.becoder.repository.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		

		User user=userRepo.findByEmail(email);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("user name is not matched");
		}
		else {
			return new CustomUser(user);
			
			
		}
	
	}
	
	
	
	
	
	
	
	
}
