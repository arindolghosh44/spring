package com.arindom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
public class Order {

	@Id
	@Column(length = 10)
	private String nid;
	
	
	private int pqty;
	
	
	
	private Double price;
	
	
	
	
	
}
