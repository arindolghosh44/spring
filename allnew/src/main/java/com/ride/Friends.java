package com.ride;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Friends {

	@PostConstruct
	public void init() {
		System.out.println("init job doing here");

		friends = new ArrayList<>();

		friends.add("ram");

		friends.add("sam");
	}

	List<String> friends;

	public List<String> getAll() {

		return friends;
	}

	public int getAllCount() {

		return friends.size();
	}

	public void addAllfrriends(String name) {

		friends.add(name);

	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("doing destroy");
		friends.clear();
	}
	
	

}
