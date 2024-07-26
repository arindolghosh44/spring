package com.arindol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class addhar {

	@Id
	@Column(length = 10)
	private String Adid;
	
	@Column(length = 25,nullable = false)
	private String City;
	
	
	
	
	
}
