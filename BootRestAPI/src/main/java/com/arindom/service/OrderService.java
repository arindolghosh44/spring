package com.arindom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindom.entity.Order;
import com.arindom.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	
	public void addData(Order r)
	{
		repo.save(r);
		
	}
	
	
	public List<Order> getData(){
		
		return repo.findAll();
		
	}
	
	
	public Order findbyOrderId(String nid)
	{
		Order o=repo.findById(nid).orElse(null);
		return o;
	}
	
	
	public void delete(String nid)
	{
		Order o=repo.findById(nid).orElse(null);
		if(o!=null)
		{
			repo.delete(o);
		}
	}
	
	
	public Order update(String nid,Order od)
	{
		Order o=repo.findById(nid).orElse(null);
		if(o!=null)
		{
			o.setNid(nid);
			o.setPqty(od.getPqty());
			o.setPrice(od.getPrice());
			
			
			repo.save(o);
			
		}
		
		
		return o;
		
		
	}
	
	
	
	public Order getDataById(String nid)
	{
		Order o=repo.findById(nid).orElse(null);
		return o;
	}
	
	
	
	
	
	
	
}
