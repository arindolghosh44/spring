package com.becoder.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String productName;
	
	
	
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Catagory> catagories=new ArrayList<>();





	





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getProductName() {
		return productName;
	}





	public void setProductName(String productName) {
		this.productName = productName;
	}





	public List<Catagory> getCatagories() {
		return catagories;
	}





	public void setCatagories(List<Catagory> catagories) {
		this.catagories = catagories;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
