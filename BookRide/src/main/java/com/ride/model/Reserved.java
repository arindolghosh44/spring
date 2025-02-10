package com.ride.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserved")
public class Reserved {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
	    private Car car;

	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	    private UserDtls user;

	    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
	    private Boolean payNow;
    
    
	    private String pickupDate;
	    
	    
	    private String returnDate;

    
}
