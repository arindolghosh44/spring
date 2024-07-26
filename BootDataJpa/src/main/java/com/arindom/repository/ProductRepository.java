package com.arindom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arindom.entity.Product;

@Repository//@Component(object Creation) + Database operation
public interface ProductRepository extends JpaRepository<Product, String>{

	@Query("from Product where pname =:name")
	 public List<Product> getPname(String name);
	
	@Query("from Product where  price > 25000 and pname='TV'")
	 public List<Product> getPrice();
	
	@Query("from Product where pname like '%e'")
	 public List<Product> getEnd();
	
	@Query("from Product where pname like 'p%'")
	 public List<Product> getStart();
	
	@Query("from Product where  pname in('TV','Phone')")
	 public List<Product> getPprice();
	
}
