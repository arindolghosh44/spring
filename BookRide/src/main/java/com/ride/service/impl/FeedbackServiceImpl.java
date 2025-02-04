package com.ride.service.impl;

import java.util.List;

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

	@Override
	public List<Feedback> getFeedback() {
		
		return feedbackrepository.findAll();
	}


}
