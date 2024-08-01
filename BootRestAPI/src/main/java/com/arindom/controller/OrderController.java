package com.arindom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.arindom.entity.Order;
import com.arindom.service.OrderService;
@CrossOrigin(origins="http://localhost:3001")
@RestController // Conroller + Response
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService se;
	
	@PostMapping("/add")
	public ResponseEntity<String> addData(@RequestBody Order o)
	{
		String msg="Data Inserted Successfully";
		
		se.addData(o);
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get")
	public ResponseEntity <List<Order>> getData()
	{
		List<Order> olist = se.getData();
		
		return new ResponseEntity <List<Order>>(olist,HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{nid}")
	public ResponseEntity <Order> findbyOrderId(@PathVariable String nid)
	{
		Order od = se.findbyOrderId(nid);
		
		return new ResponseEntity <Order>(od,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{nid}")
	public ResponseEntity <String> delete(@PathVariable String nid)
	{  
		
		String msg="Data deleted Successfully";
		se.delete(nid);
		return new ResponseEntity <String>(msg,HttpStatus.OK);
	}
	
	//putmapping fro update the data
	@PutMapping("/update/{nid}")
	public ResponseEntity <Order> update(@PathVariable String nid,@RequestBody Order od)
	{  
		
		
		Order od1=se.update(nid, od);
		return new ResponseEntity <Order>(od1,HttpStatus.OK);
	}
	
	
	/*@GetMapping("/get/{nid}")
	public ResponseEntity <Order> get(@PathVariable String nid)
	{
		Order od = se.getDataById(nid);
		
		return new ResponseEntity <Order>(od,HttpStatus.OK);
	}*/
	
	
	
	
	
	
	

}
