package com.ride.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ride.model.Car;

public interface CarRepository extends JpaRepository<Car,Integer>{
	
	List<Car> findByIsActiveTrue();

	Page<Car> findByIsActiveTrue(Pageable pageable);

	List<Car> findByCategory(String category);

	List<Car> findByModelContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2);

	Page<Car> findByCategory(Pageable pageable,String category);

	Page<Car> findByModelContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2, Pageable pageable);
	
	
	 List<Car> findByIsActiveTrueAndStockGreaterThan(int stock);

	Page<Car> findByisActiveTrueAndModelContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2,
			Pageable pageable);

}
