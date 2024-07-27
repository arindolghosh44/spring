package com.becoder.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.becoder.entity.User;

import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(Model m)
	
	{
		m.addAttribute("today",new Date());
		
		User u1=new User(1,"Suraj","India");
		User u2=new User(2,"Sures","UK");
		
		m.addAttribute("user",u1);
		m.addAttribute("user2",u2);
		m.addAttribute("status",true);
		m.addAttribute("msg","Suraj");
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile(Model m)
	
	{
		User u1=new User(1,"Suraj","India");
		User u2=new User(2,"Sures","UK");	
		User u3=new User(3,"jaggy","London");
		User u4=new User(4,"rakesh","kolkata");	
		User u5=new User(5,"soumen","wb");
		User u6=new User(6,"Sourav","up");	
		
		List<User>list=new ArrayList<>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		list.add(u5);
		list.add(u6);
		
		m.addAttribute("userList",list);
		return "profile";
	}


}
