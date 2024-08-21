package com.arindom.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arindom.controller.Job;

@Service
public class JobImplimentation implements JobService {
	private List<Job> jobs = new ArrayList<>();

	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		// TODO Auto-generated method stub
		jobs.add(job);
	}

}
