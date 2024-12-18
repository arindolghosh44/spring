package com.becoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.becoder.model.Product;
import com.becoder.service.ProductService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	// @RequestBody convert the json folder to java
	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {

		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);

	}
	
	@GetMapping("/")
	public ResponseEntity<?>getAllProduct()
	{
		return new  ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getProductById(@PathVariable Integer id)
	{
		return new  ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/deleteProduct/{id}")
	public ResponseEntity<?>deleteProduct(@PathVariable Integer id)
	{
		return new  ResponseEntity<>(productService.Deleteproduct(id),HttpStatus.OK);
	}
	
	@PostMapping("/editProduct/{id}")
	public ResponseEntity<?>EditProduct(@RequestBody Product product,@PathVariable Integer id)
	{
		return new ResponseEntity<>(productService.editProduct(product, id), HttpStatus.CREATED);
	}
	
	
	
	

}
