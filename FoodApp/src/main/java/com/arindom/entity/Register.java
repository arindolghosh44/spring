package com.arindom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Register {
	
	@Id
	@Column(length = 15)
	private String uname;
	
	@Column(length = 10)
	private String pass;
	
	@Column(length = 25)
	private String mn;

}
