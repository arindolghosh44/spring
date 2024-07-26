package com.becoder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class IngredientsItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne
	private IngredientCategory category;
	
	@JsonIgnore
	@ManyToOne 
	private Restaurent restaurent;
	
	
	private boolean inStoke=true;


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


	public IngredientCategory getCategory() {
		return category;
	}


	public void setCategory(IngredientCategory category) {
		this.category = category;
	}


	public Restaurent getRestaurent() {
		return restaurent;
	}


	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}


	public boolean isInStoke() {
		return inStoke;
	}


	public void setInStoke(boolean inStoke) {
		this.inStoke = inStoke;
	}


	public IngredientsItem(Long id, String name, IngredientCategory category, Restaurent restaurent, boolean inStoke) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.restaurent = restaurent;
		this.inStoke = inStoke;
	}


	public IngredientsItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
