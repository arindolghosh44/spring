package com.becoder.model;

import java.util.*;

import com.becoder.dto.RestaurentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fullName;
	
	private String email;
	
	
	private String password;
	
	
	private USER_ROLE role=USER_ROLE.ROLE_CUSTOMER;
	
	@JsonIgnore
	@OneToMany(cascade =CascadeType.ALL , mappedBy = "customer")
	private List<Order> orders=new ArrayList<>();
	
	@ElementCollection
	private List<RestaurentDto>favorites=new ArrayList<>();
	
	@OneToMany(cascade =CascadeType.ALL,orphanRemoval = true)
	private List<Address> address=new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public USER_ROLE getRole() {
		return role;
	}

	public void setRole(USER_ROLE role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<RestaurentDto> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<RestaurentDto> favorites) {
		this.favorites = favorites;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public User(Long id, String fullName, String email, String password, USER_ROLE role, List<Order> orders,
			List<RestaurentDto> favorites, List<Address> address) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.orders = orders;
		this.favorites = favorites;
		this.address = address;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
