package com.arindol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	@Id
	@Column(length = 10)
	private int ano;
	
	@Column(length = 250)
	private Double bal;
	
	
	
	
	
	
	
}
