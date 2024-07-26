package com.becoder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class IngredientCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String name;
	
	@ManyToOne
	@JsonIgnore
	private Restaurent restaurent;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<IngredientsItem> ingredients=new ArrayList<>();

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

	public Restaurent getRestaurent() {
		return restaurent;
	}

	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}

	public List<IngredientsItem> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientsItem> ingredients) {
		this.ingredients = ingredients;
	}

	public IngredientCategory(Long id, String name, Restaurent restaurent, List<IngredientsItem> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.restaurent = restaurent;
		this.ingredients = ingredients;
	}

	public IngredientCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
