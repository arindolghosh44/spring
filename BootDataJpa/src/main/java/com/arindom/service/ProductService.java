package com.arindom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindom.entity.Product;
import com.arindom.repository.ProductRepository;

@Service // @Component + transactions management
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public void addData(Product p) {
		repo.save(p);
	}

	public List<Product> getDATA() {
		return repo.findAll();
	}

	public void delete(String id) {
		repo.deleteById(id);
	}

	public Product findbyPid(String id) {
		return repo.findById(id).orElse(null);
	}

	public void update(String id) {
		Product p = repo.findById(id).orElse(null);

		p.setPname("Lap");
		p.setPqty(6);
		p.setPrice(26000.00);

		repo.save(p);
	}

	public List<Product> findByName(String name) {

		return repo.getPname(name);

	}

	public List<Product> findByPrice() {

		return repo.getPrice();

	}

	public List<Product> Start() {

		return repo.getStart();

	}
	
	public List<Product> Start1() {

		return repo.getPprice();

	}
	
	

}
