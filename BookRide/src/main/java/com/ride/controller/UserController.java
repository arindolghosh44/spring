package com.ride.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ride.model.Category;
import com.ride.model.Feedback;
import com.ride.model.UserDtls;
import com.ride.service.CategoryService;
import com.ride.service.FeedbackService;
import com.ride.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private FeedbackService feedbackService;
	
	
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
	
	
	@PostMapping("/saveFeedback")
	public String saveFeedback(@ModelAttribute Feedback feedback,HttpSession session) throws IOException{
		
	Feedback feedback1=feedbackService.saveProduct(feedback);
	
	if(feedback1!=null) {
		session.setAttribute("succMsg", "Your feedback saved successfully");
	}
	else {
		session.setAttribute("errorMsg", "something wrong on server");
	}
	
	
	return "feedback";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
