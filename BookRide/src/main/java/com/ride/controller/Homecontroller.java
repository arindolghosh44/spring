package com.ride.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ride.model.Category;
import com.ride.model.Feedback;
import com.ride.model.UserDtls;
import com.ride.service.CategoryService;
import com.ride.service.FeedbackService;
import com.ride.service.UserService;
import com.ride.util.CommonUtil;
import com.ride.service.CarService;

import com.ride.model.Car;

import io.micrometer.common.util.StringUtils;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Homecontroller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CarService productService;
	
	
	@Autowired
	private FeedbackService feedbackService;
	
	
	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	
	
	
	@ModelAttribute
	public void carsouleProduct(Model m) {
	    // Get list of users with role "ROLE_USER"
	    List<UserDtls> users = userService.getUsers("ROLE_USER");
	    m.addAttribute("users", users);

	    // Get all feedback
	    List<Feedback> feedbacks = feedbackService.getFeedback();
	   
	    
	    // If feedback is empty, provide an empty list (just a safeguard)
	    if (feedbacks == null) {
	        feedbacks = Collections.emptyList();
	    }
	    
	    m.addAttribute("feedbacks", feedbacks);
	}

	
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
		
		
		 // Send email notification
        try {
            String recipientEmail = feedback.getEmail();
            String emailContent = "Thank you, " + feedback.getFullName() + ", for your valuable feedback!";
            commonUtil.sendMailWithCustomContent(recipientEmail, "Feedback Received", emailContent);
        } catch (UnsupportedEncodingException | MessagingException e) {
            session.setAttribute("errorMsg", "Feedback saved but email failed to send.");
        }
	}
	else {
		session.setAttribute("errorMsg", "something wrong on server");
	}
	
	
	return "feedback";
		
	}

	
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	
	@GetMapping("/products")
	public String products(Model m, @RequestParam(value = "category", defaultValue = "") String category,
			@RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(name = "pageSize", defaultValue = "8") Integer pageSize,
			@RequestParam(defaultValue = "") String ch) {

		List<Category> categories = categoryService.getAllActiveCategory();
		m.addAttribute("paramValue", category);
		m.addAttribute("categories", categories);

	List<Car> products = productService.getAllActiveProducts(category);
	m.addAttribute("products", products);
		Page<Car> page = null;
		if (StringUtils.isEmpty(ch)) {
			page = productService.getAllActiveProductPagination(pageNo, pageSize, category);
		} else {
			page = productService.searchActiveProductPagination(pageNo, pageSize, category, ch);
		}

		List<Car> products1 = page.getContent();
		m.addAttribute("car", products1);
		m.addAttribute("productsSize", products1.size());

		m.addAttribute("pageNo", page.getNumber());
		m.addAttribute("pageSize", pageSize);
		m.addAttribute("totalElements", page.getTotalElements());
		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("isFirst", page.isFirst());
		m.addAttribute("isLast", page.isLast());

		return "product";
	}

	
	
	@GetMapping("/car/{id}")
	public String product(@PathVariable int id, Model m) {
		Car productById = productService.getProductById(id);
		// for adding something in ui or web page html
		m.addAttribute("car", productById);
		return "view_product";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute UserDtls user, @RequestParam("img") MultipartFile file, HttpSession session,HttpServletRequest request)
			throws IOException , MessagingException{

		Boolean existsEmail = userService.existsEmail(user.getEmail());

		if (existsEmail) {
			session.setAttribute("errorMsg", "Email already exist");
		} else {
			String imageName = file.isEmpty() ? "default.jpg" : file.getOriginalFilename();
			user.setProfileImage(imageName);
			
			 // Generate a confirmation token
            String confirmationToken = UUID.randomUUID().toString();
            user.setConfirmationToken(confirmationToken);
	       
			UserDtls saveUser = userService.saveUser(user);

			if (!ObjectUtils.isEmpty(saveUser)) {
				if (!file.isEmpty()) {
					File saveFile = new ClassPathResource("static/img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "profile_img" + File.separator
							+ file.getOriginalFilename());

//					System.out.println(path);
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				}
				
				// Send confirmation email
	            String confirmationUrl = CommonUtil.generateUrl(request) + "/confirm?token=" + confirmationToken;
	            commonUtil.sendMail1(confirmationUrl, user.getEmail());
				session.setAttribute("succMsg", "Register email notification send");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
			}
		}

		return "redirect:/register";
	}
	
	@GetMapping("/confirm")
	public String confirmRegistration(@RequestParam("token") String token, HttpSession session) {
	    UserDtls user = userService.getUserByConfirmationToken(token);
	    
	    if (user != null) {
	        // Enable the user's account and remove the confirmation token
	        user.setIsEnable(true);
	        user.setConfirmationToken(null); 
	        userService.updateUser(user);

	        // Send a final confirmation email to the user
	        try {
	            commonUtil.sendMailWithCustomContent1(user.getEmail(), "Registration Complete", 
	                    "<p>Your registration is now complete!</p>");
	        } catch (MessagingException | UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }

	        // Set success message in session
	        session.setAttribute("succMsg", "Registration confirmed successfully.");
	        
	        // Redirect to sign-in page
	        return "redirect:/signin"; 
	    } 
	    
	    return "redirect:/signin"; 
	    
	}

	
	
	//forgot password module
	@GetMapping("/forgot-password")
	public String showForgotPassword() {
		return "forgot_password.html";
	}

	@PostMapping("/forgot-password")
	public String processForgotPassword(@RequestParam String email, HttpSession session, HttpServletRequest request)
			throws UnsupportedEncodingException, MessagingException {

		UserDtls userByEmail = userService.getUserByEmail(email);

		if (ObjectUtils.isEmpty(userByEmail)) {
			session.setAttribute("errorMsg", "Invalid email");
		} else {

			String resetToken = UUID.randomUUID().toString();
			userService.updateUserResetToken(email, resetToken);

			// Generate URL :
			// http://localhost:678/reset-password?token=sfgdbgfswegfbdgfewgvsrg

			String url = CommonUtil.generateUrl(request) + "/reset-password?token=" + resetToken;

			Boolean sendMail = commonUtil.sendMail(url, email);

			if (sendMail) {
				session.setAttribute("succMsg", "Please check your email..Password Reset link sent");
			} else {
				session.setAttribute("errorMsg", "Somethong wrong on server ! Email not send");
			}
		}

		return "redirect:/forgot-password";
	}

	@GetMapping("/reset-password")
	public String showResetPassword(@RequestParam String token, HttpSession session, Model m) {

		UserDtls userByToken = userService.getUserByToken(token);

		if (userByToken == null) {
			m.addAttribute("msg", "Your link is invalid or expired !!");
			return "message";
		}
		m.addAttribute("token", token);
		return "reset_password";
	}

	@PostMapping("/reset-password")
	public String resetPassword(@RequestParam String token, @RequestParam String password, HttpSession session,
			Model m) {

		UserDtls userByToken = userService.getUserByToken(token);
		if (userByToken == null) {
			m.addAttribute("errorMsg", "Your link is invalid or expired !!");
			return "message";
		} else {
			userByToken.setPassword(passwordEncoder.encode(password));
			userByToken.setResetToken(null);
			userService.updateUser(userByToken);

			m.addAttribute("msg", "Password change successfully");

			return "message";
		}

	}
	
	


}
