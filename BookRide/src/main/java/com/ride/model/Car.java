package com.ride.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String plateId;

	@Column(length = 500)
	private String model;

	@Column(length = 500)
	private String make;

	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String year;

	private String category;

	private Double price;

	private int stock;

	private String image;

	private int discount;

	private Double discountPrice;

	private Boolean isActive;
	
	@OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Reserved reserved;



}
