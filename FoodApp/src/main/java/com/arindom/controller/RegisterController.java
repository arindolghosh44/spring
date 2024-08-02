package com.arindom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindom.entity.Food;
import com.arindom.entity.Register;
import com.arindom.service.FoodService;
import com.arindom.service.RegisterService;
@CrossOrigin(origins="http://localhost:3000")
@RestController 
@RequestMapping("/register")
public class RegisterController {

	
	@Autowired
	private RegisterService se;
	

	@PostMapping("/add")
	public ResponseEntity<String> addData(@RequestBody Register o)
	{
		String msg="Register Successfully";
		
		se.addData(o);
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get")
	public ResponseEntity <List<Register>> getData()
	{
		List<Register> olist = se.getData();
		
		return new ResponseEntity <List<Register>>(olist,HttpStatus.OK);
	}
	
	
	@GetMapping("/login/{uname}/{pass}")
	public ResponseEntity<String> checkLogin(@PathVariable  String uname, @PathVariable String pass)
	{
		String msg="Login Successful";
		String msg1="Login Failed";
		
		
		Register olist = se.checkLogin(uname, pass);
		if(olist!=null)
		{
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>(msg1,HttpStatus.OK);
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
