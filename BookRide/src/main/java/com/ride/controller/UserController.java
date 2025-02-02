package com.ride.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@GetMapping("/reserve")
	public String office23() {
		return "reserve";
	}
	
	
	@GetMapping("/office_signup")
	public String office_signup() {
		return "office_signup";
	}
	
	

	@GetMapping("/customerhome")
	public String customerhome() {
		return "customerhome";
	}
	

}
