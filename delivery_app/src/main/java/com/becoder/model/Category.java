package com.becoder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JsonIgnore
	private Restaurent restaurent;

	public Category(Long id, String name, Restaurent restaurent) {
		super();
		this.id = id;
		this.name = name;
		this.restaurent = restaurent;
	}

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

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
