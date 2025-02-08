package com.ride.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.ride.model.Car;

public interface CarService {
	public 	Car saveProduct(Car product);

	public List<Car> getAllProducts();

	public Boolean deleteProduct(Integer id);

	public Car getProductById(Integer id);

	public Car updateProduct(Car product, MultipartFile file);

	public List<Car> getAllActiveProducts(String category);

	public List<Car> searchProduct(String ch);

	public Page<Car> getAllActiveProductPagination(Integer pageNo, Integer pageSize, String category);

	public Page<Car> searchProductPagination(Integer pageNo, Integer pageSize, String ch);

	public Page<Car> getAllProductsPagination(Integer pageNo, Integer pageSize);
	
	public Page<Car> searchActiveProductPagination(Integer pageNo, Integer pageSize, String category, String ch);

	
}
