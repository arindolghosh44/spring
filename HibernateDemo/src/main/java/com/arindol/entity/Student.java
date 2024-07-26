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
public class Student {

	@Id
	@Column(length = 10)
	private String sroll;
	
	@Column(length = 25,nullable = false)
	private String sname;
	
	@Column(length = 25,nullable = false)
	private String sdept;
	
	
	
}
