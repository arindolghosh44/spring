package com.aec.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aec.model.Category;
import com.aec.service.CategoryService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	public String index() {

		return "admin/index";

	}

	@GetMapping("/loadAddProduct")
	public String loadAddProduct() {

		return "admin/loadAddProduct";

	}

	@GetMapping("/category")
	public String Category() {

		return "admin/category";

	}

	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute Category category, @RequestParam("file") MultipartFile file,
			HttpSession session)throws Exception {

		String image = file != null ? file.getOriginalFilename() : "default.jpg";

		category.setImagename(image);

		boolean existsCategory = categoryService.existsCategory(category.getName());

		if (existsCategory) {

			session.setAttribute("errorMsg", "Category name already exists");
		} else {
			Category saveCategory = categoryService.saveCategory(category);

			if (ObjectUtils.isEmpty(saveCategory)) {
				session.setAttribute("errorMsg", "Not Saved !!!!!!! internal server error");
			} else {
				
				
				File saveFile=new ClassPathResource("static/img").getFile();
				
				
				
				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+"category_img"+file.getOriginalFilename());
				
				
				
				System.out.println(path);
				
				Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
				
				
				
				
				
				
				
				
				
				
				
				
				session.setAttribute("succMsg", "Element successfully saved");
			}

		}

		return "redirect:/admin/category";
	}

}