package com.becoder.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.becoder.model.UserDtls;
import com.becoder.service.UserService;

@Controller
public class HomeController {

	
	
	@Autowired
	private UserService userService;
	
	
	
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@GetMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user)
	{
		
		//System.out.print(user);
	UserDtls usre=	userService.createUser(user);
		
	if(usre!=null)
	{
		System.out.print("Register Successfully");
	}
		
	else
	{
		System.out.print("Register InSuccessfully");
	}
		return "register successfully";
	}
	
	
	
	
	
	
}
