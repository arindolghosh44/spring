package com.aec.service;

import java.util.List;

import com.aec.model.Category;

public interface CategoryService {

	
	public Category saveCategory(Category category);
	
	
	public List<Category> getAllCategory();
	
	
	public boolean existsCategory(String name);
	
	
	
	
	
	
	
}
