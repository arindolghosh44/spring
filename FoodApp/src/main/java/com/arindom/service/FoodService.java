package com.arindom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindom.entity.Food;

import com.arindom.repository.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository repo;

	public void addData(Food f) {
		repo.save(f);

	}

	public List<Food> getData() {

		return repo.findAll();

	}
	
	
	public void delete(String nid)
	{
		Food o=repo.findById(nid).orElse(null);
		if(o!=null)
		{
			repo.delete(o);
		}
	}
	
	
	public Food update(String nid,Food od)
	{
		Food o=repo.findById(nid).orElse(null);
		if(o!=null)
		{
			o.setFid(nid);
			o.setFname(od.getFname());
			o.setPrice(od.getPrice());
			
			
			repo.save(o);
			
		}
		
		
		return o;
		
		
	}
	
	
	
	public Food getDataById(String nid)
	{
		Food o=repo.findById(nid).orElse(null);
		return o;
	}
	
	

}
