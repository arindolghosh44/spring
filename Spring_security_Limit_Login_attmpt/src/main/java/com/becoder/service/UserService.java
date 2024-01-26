package com.becoder.service;



import com.becoder.entity.User;


public interface UserService {

	public User saveUser(User user,String url);
	
	
	public void remeoveMsg();
	
	
	
	public void sendEmail(User user,String path);
	
	
	public boolean verifyaccount(String verificationcode);
	
	
	public void increasedFailedAttempt(User user);
	
	public void resetAttempt(String email);
	
	
	
	public void lock(User user);
	
	
	public boolean unLockedAccountTimeExpired(User user);
	
	
}
