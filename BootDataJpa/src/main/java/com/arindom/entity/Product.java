package com.arindom.entity;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product_manager")
public class Product {
	
	@Id
	@Column(length = 10)
   private String pid;
	
	@Column(length = 25)
	private String pname;
	
	
	private int pqty;
	
	
	private Double price;
	
	

}
