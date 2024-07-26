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


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
