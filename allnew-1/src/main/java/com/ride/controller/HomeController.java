package com.ride.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/")
	public String [] home() {
		
		String [] str= {"rtrtry","gjjjg","ryrur"};
		return str;
	}

}
