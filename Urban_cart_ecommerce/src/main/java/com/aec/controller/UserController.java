package com.aec.controller;

import java.security.Principal;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aec.model.Cart;
import com.aec.model.Category;
import com.aec.model.OrderRequest;
import com.aec.model.ProductOrder;
import com.aec.model.UserDtls;
import com.aec.service.CartService;
import com.aec.service.CategoryService;
import com.aec.service.OrderService;
import com.aec.service.UserService;
import com.aec.util.CommonUtil;
import com.aec.util.OrderStatus;

import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.ObjectUtils;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private CategoryService categoryService;

	
	
	@Autowired
	private UserService userService;
	
	
	
	@Autowired
	private CartService cartService;
	
	
	
	
	@Autowired
	private OrderService orderService;
	
	
	
	
	
	@Autowired
	private CommonUtil commonUtil;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;



	
	
	@GetMapping("/")
	public String home() {
		return "user/home";
	}
	
	
	
	@ModelAttribute
	public void getUserDetails(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			UserDtls userDtls = userService.getUserByEmail(email);
			m.addAttribute("user", userDtls);
			
			
			Integer countCart = cartService.getCountCart(userDtls.getId());
			m.addAttribute("countCart", countCart);
		}

		List<Category> allActiveCategory = categoryService.getAllActiveCategory();
		m.addAttribute("categorys", allActiveCategory);
	}
	
	
	
	@GetMapping("/addCart")
	public String addToCart(@RequestParam Integer pid, @RequestParam Integer uid,HttpSession session) {
		Cart saveCart = cartService.saveCart(pid, uid);
		
		if (ObjectUtils.isEmpty(saveCart)) {
			session.setAttribute("errorMsg", "Product add to cart failed");
		}else {
			session.setAttribute("succMsg", "Product added to cart");
		}
		return "redirect:/product/" + pid;
	}
	
	
	@GetMapping("/cart")
	public String loadCartPage(Principal p, Model m) {

		UserDtls user = getLoggedInUserDetails(p);
		List<Cart> carts = cartService.getCartsByUser(user.getId());
		m.addAttribute("carts", carts);
		if (carts.size() > 0) {
			Double totalOrderPrice =(double) Math.round((carts.get(carts.size() - 1).getTotalOrderPrice()));
			m.addAttribute("totalOrderPrice", totalOrderPrice);
		}
		return "/user/cart";
	}
	
	/*@GetMapping("/cartQuantityUpdate")
	public String updateCartQuantity(@RequestParam String sy, @RequestParam Integer cid) {
		cartService.updateQuantity(sy, cid);
		return "redirect:/user/cart";
	}*/

	
	private UserDtls getLoggedInUserDetails(Principal p) {
		String email = p.getName();
		UserDtls userDtls = userService.getUserByEmail(email);
		return userDtls;
	}
	
	
	
	@GetMapping("/orders")
	public String orderPage(Principal p, Model m) {
		UserDtls user = getLoggedInUserDetails(p);
		List<Cart> carts = cartService.getCartsByUser(user.getId());
		m.addAttribute("carts", carts);
		if (carts.size() > 0) {
			Double orderPrice =(double) Math.round((carts.get(carts.size() - 1).getTotalOrderPrice()));
			Double totalOrderPrice = (double) Math.round((carts.get(carts.size() - 1).getTotalOrderPrice() + 250 + 100));
			m.addAttribute("orderPrice", orderPrice);
			m.addAttribute("totalOrderPrice", totalOrderPrice);
		}
		return "/user/order";
	}

	
	@PostMapping("/save-order")
	public String saveOrder(@ModelAttribute OrderRequest request, Principal p) throws Exception {
		
		UserDtls user = getLoggedInUserDetails(p);
		orderService.saveOrder(user.getId(), request);

		return "redirect:/user/success";
	}
	
	@GetMapping("/success")
	public String loadSuccess() {
		return "/user/success";
	}
	
	
	
	@GetMapping("/user-orders")
	public String myOrder(Model m, Principal p) {
		UserDtls loginUser = getLoggedInUserDetails(p);
		List<ProductOrder> orders = orderService.getOrdersByUser(loginUser.getId());
		m.addAttribute("orders", orders);
		return "/user/my_orders";
	}
	
	
	@GetMapping("/update-status")
	public String updateOrderStatus(@RequestParam Integer id, @RequestParam Integer st, HttpSession session) {

		OrderStatus[] values = OrderStatus.values();
		String status = null;

		for (OrderStatus orderSt : values) {
			if (orderSt.getId().equals(st)) {
				status = orderSt.getName();
			}
		}

		ProductOrder updateOrder = orderService.updateOrderStatus(id, status);
		
		try {
			commonUtil.sendMailForProductOrder(updateOrder, status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!ObjectUtils.isEmpty(updateOrder)) {
			session.setAttribute("succMsg", "Status Updated");
		} else {
			session.setAttribute("errorMsg", "status not updated");
		}
		return "redirect:/user/user-orders";
	}
	
	
	@GetMapping("/profile")
	public String profile() {
		return "/user/profile";
	}
	
	
	
	@PostMapping("/update-profile")
	public String updateProfile(@ModelAttribute UserDtls user, 
	                            @RequestParam MultipartFile img, 
	                            HttpSession session) {
	    
	    UserDtls updatedUser = userService.updateUserProfile(user, img);
	    
	    if (ObjectUtils.isEmpty(updatedUser)) {
	        session.setAttribute("errorMsg", "Profile not updated");
	    } else {
	        session.setAttribute("succMsg", "Profile Updated");

	        // Send email notification
	        String email = updatedUser.getEmail();
	        String subject = "Profile Updated Successfully!";
	        String content = "<p>Hello " + updatedUser.getName() + ",</p>" +
	                         "<p>Your profile has been updated successfully.</p>" +
	                         "<p>If you did not make this change, please contact support immediately.</p>";

	        try {
	            commonUtil.sendMailadminsave(subject, content, email);
	        } catch (Exception e) {
	            session.setAttribute("errorMsg", "Profile updated but email notification failed.");
	            e.printStackTrace();
	        }
	    }
	    
	    return "redirect:/user/profile";
	}

	@PostMapping("/change-password")
	public String changePassword(@RequestParam String newPassword, 
	                             @RequestParam String currentPassword, 
	                             Principal p, 
	                             HttpSession session) {
	    
	    UserDtls loggedInUserDetails = getLoggedInUserDetails(p);

	    boolean matches = passwordEncoder.matches(currentPassword, loggedInUserDetails.getPassword());

	    if (matches) {
	        String encodePassword = passwordEncoder.encode(newPassword);
	        loggedInUserDetails.setPassword(encodePassword);
	        UserDtls updatedUser = userService.updateUser(loggedInUserDetails);

	        if (ObjectUtils.isEmpty(updatedUser)) {
	            session.setAttribute("errorMsg", "Password not updated! Error in server.");
	        } else {
	            session.setAttribute("succMsg", "Password Updated successfully!");

	            // Send email notification
	            String email = updatedUser.getEmail();
	            String subject = "Password Changed Successfully!";
	            String content = "<p>Hello " + updatedUser.getName() + ",</p>" +
	                             "<p>Your password has been changed successfully.</p>" +
	                             "<p>If you did not request this change, please contact support immediately.</p>";

	            try {
	                commonUtil.sendMailadminsave(subject, content, email);
	            } catch (Exception e) {
	                session.setAttribute("errorMsg", "Password updated, but email notification failed.");
	                e.printStackTrace();
	            }
	        }
	    } else {
	        session.setAttribute("errorMsg", "Current Password incorrect.");
	    }

	    return "redirect:/user/profile";
	}

	@GetMapping("/cartQuantityUpdate")
	public String updateCartQuantity(@RequestParam String sy, @RequestParam Integer cid, HttpSession session) {
	    cartService.updateQuantity(sy, cid, session);
	    return "redirect:/user/cart";
	}

	
	
	
	

}
