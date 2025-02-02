package com.ride.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ride.model.Category;
import com.ride.model.UserDtls;
import com.ride.service.CategoryService;
import com.ride.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@GetMapping("/reserve")
	public String office23() {
		return "reserve";
	}
	
	
	@GetMapping("/office_signup")
	public String office_signup() {
		return "office_signup";
	}
	
	

	@GetMapping("/customerhome")
	public String customerhome() {
		return "customerhome";
	}
	
	
	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}
	
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute
	public void getUserDetails(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			UserDtls userDtls = userService.getUserByEmail(email);
			m.addAttribute("user", userDtls);

			/*Integer countCart = cartService.getCountCart(userDtls.getId());
			m.addAttribute("countCart", countCart);*/
		}

		List<Category> allActiveCategory = categoryService.getAllActiveCategory();
		m.addAttribute("categorys", allActiveCategory);
	}
	
	

}
