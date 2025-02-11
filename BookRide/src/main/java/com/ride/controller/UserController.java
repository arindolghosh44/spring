package com.ride.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ride.model.Car;
import com.ride.model.Category;
import com.ride.model.Feedback;
import com.ride.model.Reserved;
import com.ride.model.UserDtls;
import com.ride.repository.CarRepository;
import com.ride.repository.ReserveRepository;
import com.ride.service.CarService;
import com.ride.service.CategoryService;
import com.ride.service.FeedbackService;
import com.ride.service.ReservedService;
import com.ride.service.UserService;
import com.ride.util.CommonUtil;

import io.micrometer.common.util.StringUtils;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarService productService;
	

	@Autowired
	private CommonUtil commonUtil;
	
	
	@Autowired
	private ReservedService reservedService;
	


	


	

	
	
	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
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
	
	
	@GetMapping("/book")
	public String bookCar(@RequestParam(value = "carId", required = false) Integer carId, Model model, HttpSession session) {
	    if (carId == null) {
	        session.setAttribute("errorMsg", "Invalid car selection.");
	        return "redirect:/cars"; // Redirect to car listing page instead of error
	    }

	    Car car = productService.getProductById(carId);
	    if (car == null) {
	        session.setAttribute("errorMsg", "Car not found.");
	        return "redirect:/user/book";
	    }

	    model.addAttribute("car", car); // Ensure this is added
	    return "book";
	}


	
	@PostMapping("/saveReserved")
	public String saveReservation(@RequestParam("carId") Integer carId,
	                              @RequestParam("pickupDate") String pickupDate,
	                              @RequestParam("returnDate") String returnDate,
	                              @RequestParam(value = "payNow", required = false, defaultValue = "false") Boolean payNow,
	                              HttpSession session,
	                              Principal principal) {
	    if (carId == null) {
	        session.setAttribute("errorMsg", "Car selection is required.");
	        return "redirect:/user/book"; // Redirect to car selection
	    }

	    String email = principal.getName();
	    UserDtls user = userService.getUserByEmail(email);

	    if (user == null) {
	        session.setAttribute("errorMsg", "User not found. Please log in.");
	        return "redirect:/login";
	    }

	    Car car = productService.getProductById(carId);
	    if (car == null || !car.getIsActive() || car.getStock() <= 0) {
	        session.setAttribute("errorMsg", "Car is unavailable.");
	        return "redirect:/user/book";
	    }

	    Reserved savedReserved = reservedService.saveReservation(user, car, payNow, pickupDate, returnDate);

	    if (savedReserved != null && savedReserved.getId() > 0) {
	        session.setAttribute("succMsg", "Reservation successful!");
	    } else {
	        session.setAttribute("errorMsg", "Reservation failed. Try again.");
	    }

	    return "redirect:/user/book";
	}

}
