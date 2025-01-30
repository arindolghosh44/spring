package com.ride.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ride.model.Category;
import com.ride.service.CategoryService;
import com.ride.service.CarService;

import com.ride.model.Car;

import io.micrometer.common.util.StringUtils;

@Controller
public class Homecontroller {
	
	
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CarService productService;
	
	@GetMapping("/")
	public String index() {
		
		return "index";
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
		m.addAttribute("products", products1);
		m.addAttribute("productsSize", products1.size());

		m.addAttribute("pageNo", page.getNumber());
		m.addAttribute("pageSize", pageSize);
		m.addAttribute("totalElements", page.getTotalElements());
		m.addAttribute("totalPages", page.getTotalPages());
		m.addAttribute("isFirst", page.isFirst());
		m.addAttribute("isLast", page.isLast());

		return "product";
	}

	
	
	@GetMapping("/product/{id}")
	public String product(@PathVariable int id, Model m) {
		Car productById = productService.getProductById(id);
		// for adding something in ui or web page html
		m.addAttribute("product", productById);
		return "view_product";
	}


}
