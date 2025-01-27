package com.ride.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	
	@GetMapping("/register")
	public String register() {
		return "register";
	}

}
