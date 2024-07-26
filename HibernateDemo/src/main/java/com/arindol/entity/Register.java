package com.arindol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {

	@Id
	@Column(length = 15)
	private String UNAME;
	
	@Column(length = 10,nullable = false)
	private String PASS;
	
	@Column(length = 25,nullable = false)
	private String NM;
	
	@Column(length = 30,nullable = false)
	private String EMAIL;
	
	
	
	
	
}
