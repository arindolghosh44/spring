package com.becoder.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.becoder.entity.User;
import com.becoder.repository.UserRepo;
import com.becoder.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	/*@GetMapping("/user/home")

	public String home() {
		return "home";
	}

	@GetMapping("/user/profile")

	public String about(Principal p,Model m) {
		String email=p.getName();
		User u=userRepo.findByEmail(email);
		m.addAttribute("user",u);
		return "profile";
	}
	
	*/
	
	
	@GetMapping("/registration")
	public String signin() {
		return "registration";
	}
	
	
	@GetMapping("/signin")
	public String login() {
		
		return "login";
	}

	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user,HttpSession session)
	{
		User u=userService.saveUser(user);
		
		
		if(u!=null)
		{
			
			
			session.setAttribute("msg","Register Successful");
			
		}
		else
		{
			session.setAttribute("msg","Something went wrong in server");
		}
		
		
		
		
		return "redirect:/registration";
	}
	
	@ModelAttribute
	public void commonUser(Principal p,Model m)
	{
		if(p!=null) {
		String email=p.getName();
		User u=userRepo.findByEmail(email);
		m.addAttribute("user",u);
		
	}
		
	
	}
	

	
	
}
