package com.becoder.service;



import com.becoder.entity.User;


public interface UserService {

	public User saveUser(User user,String url);
	
	
	public void remeoveMsg();
	
	
	
	public void sendEmail(User user,String path);
	
	
	public boolean verifyaccount(String verificationcode);
	
	
	
	
	
}
