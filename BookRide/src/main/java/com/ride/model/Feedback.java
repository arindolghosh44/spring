package com.ride.model;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feedback {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int f_id;
	
	private String email;
	
	@Column(length = 500)
	private String fullName;
	
	
	@Column(length = 500)
	private String description;
	
	private int rating;
	
	
	@ManyToOne
	private UserDtls user;
	
	
	

}
