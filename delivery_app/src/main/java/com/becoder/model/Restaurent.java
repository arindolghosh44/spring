package com.becoder.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	  
	@OneToOne
	private User owner;
	
	
	private String name;
	
	
	private String description;
	
	
	private String cvisionType;
	
	@OneToOne
	private Address address;
	
	@Embedded
	private ContactInformation contactinformation;
	
	private String openingHours;
	 
	@OneToMany(mappedBy = "restaurent",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Order> orders=new ArrayList<>();
	
	@ElementCollection
	@Column(length = 1000)
	private List<String>images;
	
	
	private LocalDateTime registrationTime;
	
	
	private boolean open;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurent",cascade = CascadeType.ALL)
	private List<Food> foods=new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCvisionType() {
		return cvisionType;
	}

	public void setCvisionType(String cvisionType) {
		this.cvisionType = cvisionType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactInformation getContactinformation() {
		return contactinformation;
	}

	public void setContactinformation(ContactInformation contactinformation) {
		this.contactinformation = contactinformation;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public Restaurent(Long id, User owner, String name, String description, String cvisionType, Address address,
			ContactInformation contactinformation, String openingHours, List<Order> orders, List<String> images,
			LocalDateTime registrationTime, boolean open, List<Food> foods) {
		super();
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.description = description;
		this.cvisionType = cvisionType;
		this.address = address;
		this.contactinformation = contactinformation;
		this.openingHours = openingHours;
		this.orders = orders;
		this.images = images;
		this.registrationTime = registrationTime;
		this.open = open;
		this.foods = foods;
	}

	public Restaurent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
