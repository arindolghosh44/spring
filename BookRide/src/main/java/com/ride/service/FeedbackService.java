package com.ride.service;

import java.util.List;

import com.ride.model.Feedback;
import com.ride.model.UserDtls;

public interface FeedbackService {
	
	public 	Feedback saveProduct(Feedback feedback);
	
	public List<Feedback> getFeedback();

}
