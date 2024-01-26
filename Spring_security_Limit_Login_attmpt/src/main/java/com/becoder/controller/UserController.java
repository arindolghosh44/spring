package com.becoder.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.becoder.entity.User;
import com.becoder.repository.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserRepo userRepo;
	
	
	
	@GetMapping("/profile")
	public String profile()
	{
		return "profile";
	}
	
	
	
	@ModelAttribute
	public void commonUser(Principal p,Model m)
	{
		if(p!=null) {
		String email=p.getName();
		User u=userRepo.findByEmail(email);
		m.addAttribute("user",u);
		
	}
		
	
	}
	
	
	
	
	
}
