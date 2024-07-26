package com.becoder.model;

import java.util.*;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	
	private Long price;
	
	@ManyToOne
	private Category foodCategory;
	
	@Column(length=1000)
	@ElementCollection
	private List<String> images;
	
	
	
	private boolean available;
	
	@ManyToOne
	private Restaurent restaurent;
	
	
	private boolean isVegetarian;
	
	
	private boolean isSessional;
	
	
	
	@ManyToMany
	private List<IngredientsItem> ingredients = new ArrayList<>();
	
	
	private Date creationDate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public Category getFoodCategory() {
		return foodCategory;
	}


	public void setFoodCategory(Category foodCategory) {
		this.foodCategory = foodCategory;
	}


	public List<String> getImages() {
		return images;
	}


	public void setImages(List<String> images) {
		this.images = images;
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	public Restaurent getRestaurent() {
		return restaurent;
	}


	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}


	public boolean isVegetarian() {
		return isVegetarian;
	}


	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}


	public boolean isSessional() {
		return isSessional;
	}


	public void setSessional(boolean isSessional) {
		this.isSessional = isSessional;
	}


	public List<IngredientsItem> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<IngredientsItem> ingredients) {
		this.ingredients = ingredients;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Food(Long id, String name, String description, Long price, Category foodCategory, List<String> images,
			boolean available, Restaurent restaurent, boolean isVegetarian, boolean isSessional,
			List<IngredientsItem> ingredients, Date creationDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.foodCategory = foodCategory;
		this.images = images;
		this.available = available;
		this.restaurent = restaurent;
		this.isVegetarian = isVegetarian;
		this.isSessional = isSessional;
		this.ingredients = ingredients;
		this.creationDate = creationDate;
	}


	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
