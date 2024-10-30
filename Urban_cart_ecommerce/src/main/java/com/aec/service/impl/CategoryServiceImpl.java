package com.aec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aec.model.Category;
import com.aec.repository.CategoryRepository;
import com.aec.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public boolean existsCategory(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.existsByName(name);
	}

}
