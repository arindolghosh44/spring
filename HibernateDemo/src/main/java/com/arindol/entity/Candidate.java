package com.arindol.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//getter setter and toString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Candidate {
	
	@Id
	@Column(length = 10)
	private String Cndid;
	
	@Column(length = 25,nullable = false)
	private String Cnum;

}
