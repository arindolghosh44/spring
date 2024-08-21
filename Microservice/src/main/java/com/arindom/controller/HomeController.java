package com.arindom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
	@GetMapping("/hello")
	public String hello()
	{
		return "hello world arindol Ghosh";
	}
	
	@PostMapping("/hello")
	public String  hello(@RequestBody String name)
	{
		return "Hello" + name +"Ghosh";
	}
	
}
