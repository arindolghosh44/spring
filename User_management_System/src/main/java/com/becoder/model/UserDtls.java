package com.becoder.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserDtls {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String fullname;
	private String emailAdd;
	private String address;
	private String qualification;
	private String password;
}
