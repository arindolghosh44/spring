package com.ride.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.model.Feedback;
import com.ride.model.UserDtls;

public interface Feedbackrepository extends JpaRepository<Feedback,Integer> {
	
	
	

}
