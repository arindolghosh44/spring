package com.becoder.model;

import java.sql.Date;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "orders")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	  
	@ManyToOne
	private User customer;
	
	@JsonIgnore
	@ManyToOne
	private Restaurent restaurent;
	
	private Long totalAmount;
	
	private String OrderStatus;
	
	
	private Date createdAt;
	
	@ManyToOne
	private Address DeliveryAddress;
	
	
	
	@OneToMany
	private List<Orderitem> items;
	
	
	//private Payment payment;
	
	private int totalItem;
	
	
	private int totalPrice;


	
	
	
	
	
	
	
	
	
	
	
	
}
