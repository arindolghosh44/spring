package com.becoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.model.Product;
import com.becoder.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	
	
	
	
	
	
	@Override
	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		
		return productRepo.findById(id).get();
	}

	@Override
	public String Deleteproduct(int id) {
	
		
	Product product=productRepo.findById(id).get();
	
	if(product!=null)
	{
		productRepo.delete(product);
		return "Product Deleted Suuceesfully";
	}
		
		
		
		
		return "something Wrong on Server";
		
		
		
		
		
		
		
		
		
	}

	@Override
	public Product editProduct(Product p, Integer id) {
		Product product1=productRepo.findById(id).get();
		
		product1.setProductname(p.getProductname());
		
		product1.setDescription(p.getDescription());
		
		product1.setPrice(p.getPrice());
		
		product1.setStatus(p.getStatus());
		
		
		
		
		
		return productRepo.save(product1);
	}

}
