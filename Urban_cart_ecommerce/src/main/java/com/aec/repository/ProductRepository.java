package com.aec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aec.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByIsActiveTrue();

	List<Product> findByCategory(String category);
	
	
	
	
	
}
