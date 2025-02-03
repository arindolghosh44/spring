package com.ride.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.model.Feedback;
import com.ride.repository.Feedbackrepository;
import com.ride.service.FeedbackService;


@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	
	@Autowired
	private Feedbackrepository  feedbackrepository;

	@Override
	public Feedback saveProduct(Feedback feedback) {
		return feedbackrepository.save(feedback);
	}

}
