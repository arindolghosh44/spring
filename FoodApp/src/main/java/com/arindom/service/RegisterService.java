package com.arindom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.arindom.entity.Register;

import com.arindom.repository.RegisterRepository;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepository repo;

	public void addData(Register r) {
		repo.save(r);

	}

	public List<Register> getData() {

		return repo.findAll();

	}
	public Register checkLogin(String uname,String pass) {
		
		return repo.checkLogin(uname, pass);
		
	
	}

}
