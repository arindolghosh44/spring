package com.ride.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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


import com.ride.model.Car;
import com.ride.model.Category;
import com.ride.service.CarService;
import com.ride.service.CategoryService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class Admincontroller {
	

	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private CarService carService;

	
	
	@GetMapping("/")
	public String index() {
		
		return "admin/index";
	}
	
	
	@GetMapping("/loadAddProduct")
	public String loadAddProduct(Model m) {
		
		List<Category> categories = categoryService.getAllCategory();

		m.addAttribute("categories", categories);

		
		return "admin/add_new_car";
	}

 
	
	@GetMapping("/category")
	public String category(Model m) {
		
		m.addAttribute("categorys", categoryService.getAllCategory());
		
		return "admin/category";
	}
	
	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute Category category, @RequestParam("file") MultipartFile file,
			HttpSession session) throws IOException {

		String imageName = file != null ? file.getOriginalFilename() : "default.jpg";

		category.setImageName(imageName);

		Boolean existCategory = categoryService.existCategory(category.getName());

		if (existCategory) {

			session.setAttribute("errorMsg", "Category Name already exists");
		} else {
			Category saveCategory = categoryService.saveCategory(category);

			if (ObjectUtils.isEmpty(saveCategory)) {
				session.setAttribute("errorMsg", "internal Server Error !!!!!!! Not Saved");
			} else {

				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "Category_image" + File.separator
						+ file.getOriginalFilename());

				System.out.println(path);

				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				session.setAttribute("succMsg", "Saved Successfully");

			}

		}

		return "redirect:/admin/category";
	}

	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id, HttpSession session) {
		Boolean deleteCategory = categoryService.deleteCategory(id);

		if (deleteCategory) {
			session.setAttribute("succMsg", "category delete success");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/category";
	}

	@GetMapping("/loadEditCategory/{id}")
	public String loadEditCategory(@PathVariable int id, Model m) {

		m.addAttribute("category", categoryService.getCategoryById(id));

		// by using "category" we can get the get all the from database and show it in
		// the HTML page
		return "admin/edit_category";
	}

	@PostMapping("/updateCategory")
	public String updateCategory(@ModelAttribute Category category, @RequestParam("file") MultipartFile file,
			HttpSession session) throws IOException {

		Category Oldcategory = categoryService.getCategoryById(category.getId());
		String imageName = file.isEmpty() ? Oldcategory.getImageName() : file.getOriginalFilename();

		if (!ObjectUtils.isEmpty(Oldcategory)) {
			Oldcategory.setName(category.getName());

			Oldcategory.setIsActive(category.getIsActive());

			Oldcategory.setImageName(imageName);
		}

		Category updateCategory = categoryService.saveCategory(Oldcategory);
		if (!ObjectUtils.isEmpty(updateCategory)) {
			if (!file.isEmpty()) {
				File saveFile = new ClassPathResource("static/img").getFile();

				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "Category_image" + File.separator
						+ file.getOriginalFilename());

				System.out.println(path);
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			}
			session.setAttribute("succMsg", "category updated successfully");
		}

		else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/loadEditCategory/" + category.getId();
	}
	
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute Car product, @RequestParam("img") MultipartFile image,
			HttpSession session) throws IOException {

		String imageName = image.isEmpty() ? "default.jpg" : image.getOriginalFilename();

		product.setImage(imageName);
		product.setDiscount(0);
		product.setDiscountPrice(product.getPrice());

		Car saveProduct = carService.saveProduct(product);

		if (!ObjectUtils.isEmpty(saveProduct)) {

			File saveFile = new ClassPathResource("static/img").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "product_img" + File.separator
					+ image.getOriginalFilename());

			System.out.println(path);
			Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			session.setAttribute("succMsg", "Car Saved Success");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
		}

		return "redirect:/admin/loadAddProduct";
	}
	
	@GetMapping("/car_status")
	public String loadViewProduct(Model m) {
		
		
	/*	List<Car> products = null;
	if (ch != null && ch.length() > 0) {
		products = carService.searchProduct(ch);
	} else {
		products = carService.getAllProducts();
		}*/
	
		List<Car> products = carService.getAllProducts();
		m.addAttribute("products", products);
		
		return "admin/car_status";
	}
	
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, HttpSession session) {
		Boolean deleteProduct = carService.deleteProduct(id);
		if (deleteProduct) {
			session.setAttribute("succMsg", "Car delete successfully");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}
		return "redirect:/admin/car_status";
	}


	
	@GetMapping("/editProduct/{id}")
	public String editProduct(@PathVariable int id, Model m) {
		m.addAttribute("product", carService.getProductById(id));
		m.addAttribute("categories", categoryService.getAllCategory());
		return "admin/edit_product";
	}

	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute Car product, @RequestParam("img") MultipartFile image,
			HttpSession session, Model m) {

		if (product.getDiscount() < 0 || product.getDiscount() > 100) {
			session.setAttribute("errorMsg", "invalid Discount");
		}

		else {

			Car updateProduct = carService.updateProduct(product, image);
			if (!ObjectUtils.isEmpty(updateProduct)) {
				session.setAttribute("succMsg", "Product update successfully");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}
		}

		return "redirect:/admin/editProduct/" + product.getId();
	}
}
