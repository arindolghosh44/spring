package com.ride.model;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDtls {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;

	private String lastName;

	private String email;
	
	private String phoneNumber;

	private String holderName;
	
	private String credit_card_no;
	
	
	private String expiryDate;
	
	
	private String credit_card_cvv;

	private String password;

	private String role;
	
	private String profileImage;
	
	private Boolean isEnable;
	
	
	private Boolean accountNonLocked;

	private Integer failedAttempt;

	private Date lockTime;
	private String resetToken;
	
	private String confirmationToken;

	

}
