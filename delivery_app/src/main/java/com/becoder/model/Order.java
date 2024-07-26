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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getCustomer() {
		return customer;
	}


	public void setCustomer(User customer) {
		this.customer = customer;
	}


	public Restaurent getRestaurent() {
		return restaurent;
	}


	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}


	public Long getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getOrderStatus() {
		return OrderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Address getDeliveryAddress() {
		return DeliveryAddress;
	}


	public void setDeliveryAddress(Address deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}


	public List<Orderitem> getItems() {
		return items;
	}


	public void setItems(List<Orderitem> items) {
		this.items = items;
	}


	public int getTotalItem() {
		return totalItem;
	}


	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Order(Long id, User customer, Restaurent restaurent, Long totalAmount, String orderStatus, Date createdAt,
			Address deliveryAddress, List<Orderitem> items, int totalItem, int totalPrice) {
		super();
		this.id = id;
		this.customer = customer;
		this.restaurent = restaurent;
		this.totalAmount = totalAmount;
		OrderStatus = orderStatus;
		this.createdAt = createdAt;
		DeliveryAddress = deliveryAddress;
		this.items = items;
		this.totalItem = totalItem;
		this.totalPrice = totalPrice;
	}


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
