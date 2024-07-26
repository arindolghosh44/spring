package com.arindom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/view")
	public String view() {
		return "<h1>NewFile</h1>";
	}
	
	
	

}
