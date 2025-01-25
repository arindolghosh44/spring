package com.ride.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/addcar")
	public String addcar() {
		return "addcar";
	}
	
	@GetMapping("/adminhome")
	public String adminhome() {
		return "adminhome";
	}
	
	
	@GetMapping("/advancedsearch")
	public String advanced() {
		return "advancedsearch";
	}
	
	@GetMapping("/car_res_search")
	public String advanced1() {
		return "car_res_search";
	}
	
	
	
	@GetMapping("/carstatus")
	public String carstatus() {
		return "carstatus";
	}
	
	

	@GetMapping("/customerhome")
	public String customerhome() {
		return "customerhome";
	}
	
	
	@GetMapping("/customer_res_search")
	public String customer_res_search() {
		return "customer_res_search";
	}
	
	
	@GetMapping("/office_home")
	public String office_home() {
		return "office_home";
	}
	

	@GetMapping("/office_signup")
	public String office_signup() {
		return "office_signup";
	}
	
	
	@GetMapping("/payment_report_search")
	public String office() {
		return "payment_report_search";
	}
	
	@GetMapping("/search")
	public String office2() {
		return "search";
	}
	
	

	@GetMapping("/reserve")
	public String office23() {
		return "reserve";
	}
	
	
	
}
