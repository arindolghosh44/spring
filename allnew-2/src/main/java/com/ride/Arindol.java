package com.ride;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Arindol {
	
	
	//here in the RestController @Component Present
	
	//@RequestMapping(value = "home",method = RequestMethod.GET)
	//or
	@GetMapping("/home")
	public String home() {
		
		
		return "heklll";
	}

	public Arindol() {
		System.err.println("Arindol Component Created");
	}
	
	
	
	
	

}
