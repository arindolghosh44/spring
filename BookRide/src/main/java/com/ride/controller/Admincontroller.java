package com.ride.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Admincontroller {
	
	
	@GetMapping("/")
	public String index() {
		
		return "admin/index";
	}
	
	
	@GetMapping("/loadAddProduct")
	public String loadAddProduct() {
		
		return "admin/add_new_car";
	}

 
	
	@GetMapping("/category")
	public String category() {
		
		return "admin/category";
	}


}
