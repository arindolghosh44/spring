package com.arindom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.arindom.entity.Food;

import com.arindom.service.FoodService;
@CrossOrigin(origins="http://localhost:3000")
@RestController 
@RequestMapping("/food")
public class FoodController {
	
	
	@Autowired
	private FoodService se;
	

	@PostMapping("/add")
	public ResponseEntity<String> addData(@RequestBody Food o)
	{
		String msg="Food Added Successfully";
		
		se.addData(o);
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get")
	public ResponseEntity <List<Food>> getData()
	{
		List<Food> olist = se.getData();
		
		return new ResponseEntity <List<Food>>(olist,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{nid}")
	public ResponseEntity <String> delete(@PathVariable String nid)
	{  
		
		String msg="Data deleted Successfully";
		se.delete(nid);
		return new ResponseEntity <String>(msg,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{nid}")
	public ResponseEntity <Food> update(@PathVariable String nid,@RequestBody Food od)
	{  
		
		
		Food od1=se.update(nid, od);
		return new ResponseEntity <Food>(od1,HttpStatus.OK);
	}
	
	
	@PutMapping("/get/{nid}")
	public ResponseEntity <Food> get(@PathVariable String nid)
	{
		Food od = se.getDataById(nid);
		
		return new ResponseEntity <Food>(od,HttpStatus.OK);
	}
	
	
}
