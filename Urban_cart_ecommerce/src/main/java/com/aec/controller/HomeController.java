package com.aec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Index() {
	 return "index";
	}
	
	@GetMapping("/login")
	public String login() {
	 return "login";
	}
	
	
	@GetMapping("/register")
	public String register() {
	 return "register";
	}
	
	@GetMapping("/product")
	public String product() {
	 return "product";
	}
	
	@GetMapping("/view_details")
	public String deatils() {
	 return "view_product";
	}
	
	
}
